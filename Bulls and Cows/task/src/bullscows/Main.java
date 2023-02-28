package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = String.valueOf(generateSecretCode(scanner.nextInt()));
        System.out.println("The random secret number is " + secretCode);
//        String guessCode = scanner.nextLine();
        int cows = 0;
        int bulls = 0;
//
//        for (int i = 0; i < secretCode.length(); i++) {
//            if (secretCode.charAt(i) == guessCode.charAt(i)) {
//                bulls++;
//            } else if (secretCode.contains(String.valueOf(guessCode.charAt(i)))) {
//                cows++;
//            }
//        }
//
//        if (cows == 0 && bulls == 0) {
//            System.out.printf("Grade: None. The secret code is %s.", secretCode);
//        } else if (bulls == 0) {
//            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, secretCode);
//        } else {
//            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secretCode);
//        }
    }

    public static StringBuilder generateSecretCode(int size) {
        StringBuilder secretCode = new StringBuilder();
        if (size > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return secretCode;
        }
        while (secretCode.length() < size) {
            String pseudoRandomNumber = Long.toString(System.nanoTime());
            for (int i = 0; i < pseudoRandomNumber.length(); i++) {
                if (!secretCode.toString().contains(String.valueOf(pseudoRandomNumber.charAt(i)))) {
                    secretCode.append(pseudoRandomNumber.charAt(i));
                }
                if (secretCode.length() == size) {
                    break;
                }
            }
        }
        return secretCode;
    }
}