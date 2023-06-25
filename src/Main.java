import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter password length: ");
        Scanner input = new Scanner(System.in);
        int length = input.nextInt(); // Length of the password

        // Check if the specified length is less than 8, and set it to 8 if necessary
        if (length < 8) {
            length = 8;
            System.out.println("Password length scaled up to 8 characters for security.");
        }

        // Define character pools for different types of characters
        String uppercaseChars = "ABCDEFGHJKLMNPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijkmnpqrstuvwxyz";
        String numberChars = "123456789";
        String specialChars = "!#$@?";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // Generate at least one character from each character pool
        password.append(getRandomChar(uppercaseChars, random));
        password.append(getRandomChar(lowercaseChars, random));
        password.append(getRandomChar(numberChars, random));
        password.append(getRandomChar(specialChars, random));

        // Generate remaining characters based on the given length
        int remainingLength = length - 4;
        for (int i = 0; i < remainingLength; i++) {
            // Select a random character pool
            String pool = getRandomCharPool(uppercaseChars, lowercaseChars, numberChars, specialChars);
            // Append a random character from the selected pool to the password
            password.append(getRandomChar(pool, random));
        }

        // Shuffle the password characters
        String shuffledPassword = shuffleString(password.toString(), random);

        System.out.println(shuffledPassword);
    }

    /* Generates a random character from the given character pool.*/
    private static char getRandomChar(String charPool, Random random) {
        int randomIndex = random.nextInt(charPool.length());
        return charPool.charAt(randomIndex);
    }

    /* Selects a random character pool from the given array of character pools. */
    private static String getRandomCharPool(String... charPools) {
        Random random = new Random();
        int randomIndex = random.nextInt(charPools.length);
        return charPools[randomIndex];
    }

    /* Shuffles the characters of the given input string using a Fisher-Yates algorithm. */
    private static String shuffleString(String input, Random random) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}
