import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int totalScore = 0;
        System.out.println("Number of Attempts is 10.");

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("Round " + rounds + ": Guess the number between " + minRange + " and " + maxRange + ".");

            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    int score = calculateScore(attempts, maxAttempts);
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    System.out.println("Score for this round: " + score);
                    totalScore += score;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is lower than the target number.");
                } else {
                    System.out.println("Your guess is higher than the target number.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was " + targetNumber + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }

    private static int calculateScore(int attempts, int maxAttempts) {
        int maxScore = 100; // Maximum score for a round
        double deductionPerAttempt = maxScore / (double) maxAttempts;
        int score = (int) Math.round(maxScore - (deductionPerAttempt * (attempts - 1)));
        return score;
    }
}
