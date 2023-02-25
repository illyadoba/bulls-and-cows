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
            System.out.printf("Grade: None. The secret code is %s.", secretCode);
        } else if (bulls == 0) {
            System.out.printf("Grade: %d cow(s). The secret code is %s.", cows, secretCode);
        } else {
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secretCode);
        }
    }
}