public class TextDrawDisplay {

    public static void startHangman(int lives) {
        if (lives == 0) {
            System.out.println("      _______           ");
            System.out.println("     |/      |          ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |___               ");
        } else if (lives == 1) {
            System.out.println("      _______           ");
            System.out.println("     |/      |          ");
            System.out.println("     |      (_)         ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |___               ");

        } else if (lives == 2) {
            System.out.println("      _______           ");
            System.out.println("     |/      |          ");
            System.out.println("     |      (_)         ");
            System.out.println("     |      \\|/        ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |___               ");
        } else if (lives == 3) {
            System.out.println("      _______           ");
            System.out.println("     |/      |          ");
            System.out.println("     |      (_)         ");
            System.out.println("     |      \\|/        ");
            System.out.println("     |       |          ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |___               ");
        } else if (lives == 4) {
            System.out.println("      _______           ");
            System.out.println("     |/      |          ");
            System.out.println("     |      (_)         ");
            System.out.println("     |      \\|/        ");
            System.out.println("     |       |          ");
            System.out.println("     |       |          ");
            System.out.println("     |                  ");
            System.out.println("     |                  ");
            System.out.println("     |___               ");
        } else if (lives == 5) {
            System.out.println("      _______           ");
            System.out.println("     |/      |          ");
            System.out.println("     |      (_)         ");
            System.out.println("     |      \\|/        ");
            System.out.println("     |       |          ");
            System.out.println("     |       |          ");
            System.out.println("     |      / \\        ");
            System.out.println("     |                  ");
            System.out.println("     |___               ");
        }
    }

    public static void mainMenu() {
        System.out.println("-------------------------");
        System.out.println("Welcome to Hangman");
        System.out.println("To play type: START");
        System.out.println("Easy mode? Type: EASY");
        System.out.println("Normal mode? Type: NORMAL");
        System.out.println("Hard Mode? Type: HARD");
        System.out.println("Type: QUIT to exit.");
        System.out.println("-------------------------");
    }

    public static void startMenu() {
        System.out.println("1. Give me a Letter");
        System.out.println("2. Ready to guess the word");
        System.out.println("3. QUIT");
    }
}
