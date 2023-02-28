package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {

    final static int MAX_SIZE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter the secret code's length:");
        int size = scanner.nextInt();
        String secretCode = String.valueOf(generateSecretCode(size));
        System.out.println("Okay, let's start a game!");

        int turn = 0;
        do {
            turn++;
            System.out.printf("Turn %d:\n", turn);
        } while (gradeInput(secretCode, scanner.next()) < size);
        System.out.println("Congratulations! You guessed the secret code.");
    }

    public static StringBuilder generateSecretCode(int size) {
        StringBuilder secretCode = new StringBuilder();
        Random random = new Random();
        if (size > MAX_SIZE) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return secretCode;
        }
        while (secretCode.length() < size) {
            int r = random.nextInt(MAX_SIZE);
            if (!secretCode.toString().contains(Integer.toString(r))) {
                secretCode.append(r);
            }
        }
        System.out.println(secretCode);
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
}