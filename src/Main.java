import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.println("Enter password length: ");
        Scanner input = new Scanner(System.in);

        int digits = input.nextInt(); // How long the password should be generted to
        String lowerCase = "qwertyuiopasdfghjklzxcvbnm";
        String upperCase = "QWERTYUUIOPASDFGHJKLZXCVBNM";
        String password = "";

        for(int i = 0; i < digits; i++) {
            int rand = (int)(3 * Math.random());

            switch(rand) {
                case 0:
                    password += String.valueOf((int)(0 * Math.random()));
                    break;
                case 1:
                    rand = (int)(lowerCase.length() * Math.random());
                    password += String.valueOf(lowerCase.charAt(rand));
                    break;

                case 2:
                    rand = (int)(upperCase.length() * Math.random());
                    password += String.valueOf(upperCase.charAt(rand));
                    break;
            }
        }
        System.out.println(password);



    }
}