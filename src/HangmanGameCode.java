
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGameCode {

    public static void main(String[] args) {

        Music music = new Music();
        RandomWord randomWord = new RandomWord();
        Scanner input = new Scanner(System.in);
        boolean playing = true;

        int lives;
        int difficultyLevel;
        boolean gameOver;
        boolean isWinner;
        String ans;
        ArrayList<String> guess;
        String choice;

        while(playing) {

            lives = 0;
            difficultyLevel = 0;
            gameOver = false;
            isWinner = false;
            ans = "";
            guess = new ArrayList<>();

            while (true) {

                TextDrawDisplay.mainMenu();
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("start") & difficultyLevel == 0) {
                    System.out.println("Difficulty Level Selection");
                } else if (choice.equalsIgnoreCase("start") & difficultyLevel != 0) {
                    break;
                } else if (choice.equalsIgnoreCase("easy")) {
                    difficultyLevel = 1;
                    System.out.println("Easy Mode");
                } else if (choice.equalsIgnoreCase("normal")) {
                    difficultyLevel = 2;
                    System.out.println("Normal Mode");
                } else if (choice.equalsIgnoreCase("hard")) {
                    difficultyLevel = 3;
                    System.out.println("Sicko Mode Good Luck!");
                } else if (choice.equalsIgnoreCase("quit")) {
                    System.out.println("Thank you for playing");
                    playing = false;
                    gameOver = true;
                    ans = "";
                    difficultyLevel = 0;
                    break;
                } else
                    System.out.println("Invalid entry. Please select a valid option");
            }

            if (difficultyLevel == 1) {
                if (randomWord.getLengthEasy() == 0)
                    randomWord.newEasy();
                ans = randomWord.getEasyWord();
            } else if (difficultyLevel == 2) {
                if (randomWord.getLengthNormal() == 0)
                    randomWord.newNormal();
                ans = randomWord.getNormalWord();
            } else if (difficultyLevel == 3) {
                if (randomWord.getLengthHard() == 0)
                    randomWord.newHard();
                ans = randomWord.getHardWord();
            }

            while (!gameOver) {

                TextDrawDisplay.startHangman(lives);
                printGuess(guess);
                printAnswer(ans, guess);
                TextDrawDisplay.startMenu();
                choice = input.nextLine();
                switch (choice) {
                    case "1" -> {
                        System.out.println("Guess a Letter");
                        String letterInput = input.nextLine();
                        while (letterInput.equals("")) {
                            System.out.println("Please enter a valid letter");
                            letterInput = input.nextLine();
                        }
                        char letter = letterInput.toLowerCase().charAt(0);
                        while (!(letter >= 'a' && letter <= 'z')) {
                            System.out.println("Please enter a valid letter");
                            letter = input.nextLine().toLowerCase().charAt(0);
                        }
                        if (guess.contains(String.valueOf(letter))) {
                            System.out.println("Letter guessed. Try again");
                            guess.remove(String.valueOf(letter));
                        }
                        if (ans.contains(String.valueOf(letter))) {
                            System.out.println("Correct!");
                            music.gameSoundEffect(1);
                            guess.add(String.valueOf(letter));
                            if (guess.size() == ans.length()) {
                                gameOver = true;
                                isWinner = true;
                            }
                        } else {
                            System.out.println("Incorrect.");
                            lives += 1;
                            music.gameSoundEffect(2);
                            guess.add(String.valueOf(letter));
                        }
                    }
                    case "2" -> {
                        System.out.println("Guess the word?");
                        String word = input.nextLine();
                        if (ans.equals(word)) {
                            gameOver = true;
                            isWinner = true;
                        } else {
                            System.out.println("Incorrect.");
                            music.gameSoundEffect(2);
                            lives += 1;
                        }
                    }
                    case "3" -> gameOver = true;
                    default -> System.out.println("Invalid Entry.");
                }
                    if (lives == 5) {
                        TextDrawDisplay.startHangman(lives);
                        gameOver = true;
                    }
                }
                if (isWinner & ans.length() > 1) {
                    music.gameSoundEffect(3);
                    System.out.println("Game over: YOU WIN!");
                    System.out.println("You guessed: " + ans);
                } else if (!isWinner & ans.length() > 1) {
                    music.gameSoundEffect(4);
                    System.out.println("Exit");
                    System.out.println("Game over: YOU LOSE!");
                    System.out.println("The word was: " + ans);
                }
                System.out.println("Play again? Y/N");
                String letterInput = input.nextLine();
                while (letterInput.equals("")) {
                    System.out.println("Enter a valid option");
                    letterInput = input.nextLine();
                }
                char letter = letterInput.toLowerCase().charAt(0);
                if (letter == 'y') {
                    System.out.println("New Game Start");
                } else {
                    System.out.println("See you soon!");
                    playing = false;
                }
        }
    }

    public static void printGuess (ArrayList<String> guess) {
        for (String guess : guess) {
            System.out.print("[" + guess + "]");
        }
        System.out.println();
    }

    public static void printAnswer (String ans, ArrayList<String> guess) {
        for (int i = 0; i < ans.length(); i++) {
            if (guess.contains(String.valueOf(ans.charAt(i)))) {
                System.out.print(ans.charAt(i));
            } else {
                System.out.print("_");
            }
        }
        System.out.println();
    }
}
