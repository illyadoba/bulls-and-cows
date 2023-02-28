package bullscows;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    final static int MAX_SIZE = 36;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        int possibleChar = 0;
        try {
            System.out.println("Please, enter the secret code's length:");
            length = scanner.nextInt();
            System.out.println("Input the number of possible symbols in the code:");
            possibleChar = scanner.nextInt();
            if (length > possibleChar) {
                System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + possibleChar + " unique symbols.");
                System.exit(0);
            }
            if (possibleChar > MAX_SIZE) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(0);
            }
            if (length < 1) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                System.exit(0);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: \"" + scanner.next() + "\" isn't a valid number.");
            System.exit(0);
        }


        secretPrepared(length, possibleChar);

        String secretCode = String.valueOf(generateSecretCode(length, possibleChar));
        System.out.println("Okay, let's start a game!");

        int turn = 0;
        do {
            turn++;
            System.out.printf("Turn %d:\n", turn);
        } while (gradeInput(secretCode, scanner.next()) < length);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static StringBuilder generateSecretCode(int size, int possibleChar) {
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        while (secretCode.length() < size) {
            int rNumber = random.nextInt(10);
            int rChar = random.nextInt('z' - 'a' + 1) + 'a';
            boolean checkRandomNumber = !secretCode.toString().contains(Integer.toString(rNumber));
            if (possibleChar < 11) {
                if (checkRandomNumber) {
                    secretCode.append(rNumber);
                }
            } else {
                if (random.nextBoolean()) {
                    if (!secretCode.toString().contains(String.valueOf((char) rChar))) {
                        secretCode.append((char) rChar);
                    }
                } else {
                    if (checkRandomNumber) {
                        secretCode.append(rNumber);
                    }
                }
            }
        }
        return secretCode;
    }

    public static int gradeInput(String secretCode, String guessCode) {
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < secretCode.length(); i++) {
            if (secretCode.charAt(i) == guessCode.charAt(i)) {
                bulls++;
            } else if (secretCode.contains(String.valueOf(guessCode.charAt(i)))) {
                cows++;
            }
        }

        if (cows == 0 && bulls == 0) {
            System.out.println("Grade: None.");
        } else if (bulls == 0) {
            System.out.printf("Grade: %d cow(s).\n", cows);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s).\n", bulls, cows);
        }
        return bulls;
    }

    public static void secretPrepared(int length, int possibleChar) {
        System.out.print("The secret is prepared: ");
        for (int i = 0; i < length; i++) {
            System.out.print('*');
        }
        System.out.print(" (0-9");
        if (possibleChar > 10) {
            System.out.printf(", a-%c", 'a' + possibleChar - 11);
        }
        System.out.println(").");
    }
}