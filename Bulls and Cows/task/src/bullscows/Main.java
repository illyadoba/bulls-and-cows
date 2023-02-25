package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = "9305";
        String guessCode = scanner.nextLine();
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
            System.out.println("Grade: None. The secret code is " + secretCode + ".");
        } else if (bulls == 0) {
            System.out.println("Grade: " + cows + " cow(s). The secret code is " + secretCode + ".");
        } else {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is " + secretCode + ".");
        }
    }
}