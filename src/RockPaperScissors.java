import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    static Random random;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> rockPaperScissors = List.of(new String[]{"rock", "paper", "scissors"});

        String playAgain = "yes";
        while (playAgain.equalsIgnoreCase("yes")) {
            System.out.println("Welcome to Rock Paper Scissors! Which do you choose?");
            String choice = scan.nextLine();
            if (rockPaperScissors.contains(choice.toLowerCase())) {
                System.out.println("You chose: " + choice);
            } else {
                choice = badInput(choice);
            }

            String opponentChoice = getRandomChoice(rockPaperScissors);
            System.out.println("The computer chose: " + opponentChoice);

            if (choice.equalsIgnoreCase(opponentChoice)) {
                System.out.println("This is a draw. Do you want to play again?");
            } else {
                if (choice.equalsIgnoreCase("rock")) {
                    computerChoseRock(opponentChoice);
                } else if (choice.equalsIgnoreCase("paper")) {
                    computerChosePaper(opponentChoice);
                } else {
                    computerChoseScissor(opponentChoice);
                }
            }
            playAgain = playAgainExceptions(scan.nextLine());
        }
        System.out.println("\nGame over.");
    }

    private static String badInput(String choice) {
        while (!(choice.equalsIgnoreCase("rock") || choice.equalsIgnoreCase("paper") || choice.equalsIgnoreCase("scissors"))) {
            choiceExceptions(choice);
            System.out.println("Which do you choose?");
            choice = scan.nextLine();
            System.out.println("You chose: " + choice);
        }
        return choice;
    }

    private static void choiceExceptions(String input) {
        if (input == null) {
            System.out.println("You didn't type anything. Please type either rock, paper, or scissors.");
        } else {
            System.out.println("That is not an acceptable answer. Please type either rock, paper, or scissors.");
        }
    }

    private static String playAgainExceptions(String input) {
        while (!(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no"))) {
            System.out.println("That is not an acceptable answer. Please enter either yes or no.");
            input = scan.nextLine();
        }
        return input;
    }

    public static String getRandomChoice(List<String> rockPaperScissors) {
        random = new Random();
        return rockPaperScissors.get(random.nextInt(rockPaperScissors.size()));
    }

    public static void computerChoseRock(String opponentChoice) {
        if (opponentChoice.equalsIgnoreCase("paper")) {
            System.out.println("You lose! Do you want to play again?");
        } else if (opponentChoice.equalsIgnoreCase("scissors")) {
            System.out.println("You win! Do you want to play again?");
        }
    }

    public static void computerChosePaper(String opponentChoice) {
        if (opponentChoice.equalsIgnoreCase("scissors")) {
            System.out.println("You lose! Do you want to play again?");
        } else if (opponentChoice.equalsIgnoreCase("rock")) {
            System.out.println("You win! Do you want to play again?");
        }
    }

    public static void computerChoseScissor(String opponentChoice) {
        if (opponentChoice.equalsIgnoreCase("rock")) {
            System.out.println("You lose! Do you want to play again?");
        } else if (opponentChoice.equalsIgnoreCase("paper")) {
            System.out.println("You win! Do you want to play again?");
        }
    }
}