import java.util.Random;
import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    Player player = new Player();
    Random random = new Random();

    int roundsPlayed = 0;
    int roundsWon = 0;
    int roundsLost = 0;

    public void startGame() {

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();
        player.setPlayerName(name);

        System.out.println("\nWelcome " + player.getPlayerName());

        char playAgain;

        do {

            roundsPlayed++;

            int randomNumber = random.nextInt(100) + 1;

            int attempts = 0;
            int maxAttempts = 7;

            boolean guessed = false;

            while (attempts < maxAttempts) {

                System.out.print("\nEnter Your Guess (1-100): ");
                int guess = sc.nextInt();

                attempts++;

                if (guess > randomNumber) {
                    System.out.println("Too High!");
                } else if (guess < randomNumber) {
                    System.out.println("Too Low!");
                } else {
                    guessed = true;
                    roundsWon++;
                    System.out.println("\nCongratulations!");
                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Attempts Used : " + attempts);
                    break;
                }

                System.out.println("Attempts Left : " + (maxAttempts - attempts));
            }

            if (!guessed) {
                roundsLost++;
                System.out.println("\nYou Lost!");
                System.out.println("Correct Number : " + randomNumber);
            }

            System.out.print("\nPlay Again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n           GAME SUMMARY        ");
        System.out.println("Player Name   : " + player.getPlayerName());
        System.out.println("Rounds Played : " + roundsPlayed);
        System.out.println("Rounds Won    : " + roundsWon);
        System.out.println("Rounds Lost   : " + roundsLost);
    }
}