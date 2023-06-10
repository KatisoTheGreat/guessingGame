import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("BMW", "Audi", "Mercedes", "Ferrari", "Porsche", "Lamborghini", "Tesla", "Bugatti", "Bentley", "Ford");

        System.out.println("List of cars:");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(i + 1 + ". " + words.get(i));
        }

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int randomIndex = rand.nextInt(words.size());
            String randomWord = words.get(randomIndex);
            int chances = 3;
            boolean guessedCorrectly = false;

            while (chances > 0 && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                String guess = scanner.nextLine();
                if (guess.equalsIgnoreCase(randomWord)) {
                    System.out.println("Correct! :)");
                    guessedCorrectly = true;
                } else {
                    chances--;
                    if (chances == 2) {
                        System.out.println("Incorrect :( Clue: The first letter is '" + randomWord.charAt(0) + "'");
                    } else if (chances == 1) {
                        System.out.println("Incorrect :( Clue: The word has " + randomWord.length() + " letters.");
                    } else {
                        System.out.println("Incorrect :( The word was '" + randomWord + "'");
                    }
                }
            }

            words.remove(randomIndex);
            System.out.println("\nCars remaining in the list: " + words.size());

            System.out.print("\nWould you like to play again? (y/n): ");
            String playAgainInput = scanner.nextLine();
            if (!playAgainInput.equalsIgnoreCase("y")) {
                playAgain = false;
            }
        }

        scanner.close();
    }
}