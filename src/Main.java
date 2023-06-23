import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter password length: ");
        Scanner input = new Scanner(System.in);

        int digits = input.nextInt(); // How long the password should be generated

        String lowerCase = "qwertyuiopasdfghjklzxcvbnm"; // Lowercase letters
        String upperCase = "QWERTYUUIOPASDFGHJKLZXCVBNM"; // Uppercase letters
        String password = ""; // Variable to store the generated password

        for (int i = 0; i < digits; i++) {
            int rand = (int) (3 * Math.random()); // Generate a random number between 0 and 2

            switch (rand) {
                case 0:
                    // If rand is 0, append a random digit (0-9) to the password
                    password += String.valueOf((int) (0 * Math.random()));
                    break;
                case 1:
                    // If rand is 1, append a random lowercase letter to the password
                    rand = (int) (lowerCase.length() * Math.random());
                    password += String.valueOf(lowerCase.charAt(rand));
                    break;

                case 2:
                    // If rand is 2, append a random uppercase letter to the password
                    rand = (int) (upperCase.length() * Math.random());
                    password += String.valueOf(upperCase.charAt(rand));
                    break;
            }
        }
        System.out.println(password); // Print the generated password
    }
}
