
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomWord {

    private final ArrayList<String> wordEasy;
    private final ArrayList<String> wordNormal;
    private final ArrayList<String> wordHard;
    private final InputStream WORD_BANK_INPUT_STREAM = getClass().getResourceAsStream("/assets/randomWords.txt");

    public RandomWord() {
        wordEasy = new ArrayList<>();
        wordNormal = new ArrayList<>();
        wordHard = new ArrayList<>();
        initSetup();
    }

    public void initSetup() {
        assert WORD_BANK_INPUT_STREAM != null;
        try (Scanner file = new Scanner(WORD_BANK_INPUT_STREAM)) {
            while (file.hasNext()) {
                String word = file.nextLine();
                if (word.length() <= 3) {
                    wordHard.add(word);
                } else if (word.length() <= 6) {
                    wordNormal.add(word);
                } else {
                    wordEasy.add(word);
                }
            }
        }
    }

    public void newEasy() {
        assert WORD_BANK_INPUT_STREAM != null;
        try (Scanner file = new Scanner(WORD_BANK_INPUT_STREAM)) {
            while (file.hasNext()) {
                String word = file.nextLine();
                if (word.length() <= 7) {
                    wordEasy.add(word);
                }
            }
        }
    }

    public void newNormal() {
        assert WORD_BANK_INPUT_STREAM != null;
        try (Scanner file = new Scanner(WORD_BANK_INPUT_STREAM)) {
            while (file.hasNext()) {
                String word = file.nextLine();
                if (word.length() >= 4 && word.length() <= 6) {
                    wordNormal.add(word);
                }
            }
        }
    }

    public void newHard() {
        assert WORD_BANK_INPUT_STREAM != null;
        try (Scanner file = new Scanner(WORD_BANK_INPUT_STREAM)) {
            while (file.hasNext()) {
                String word = file.nextLine();
                if (word.length() <= 3) {
                    wordHard.add(word);
                }
            }
        }
    }


    public int getLengthEasy () {
        return wordEasy.size();
    }

    public int getLengthNormal () {
        return wordNormal.size();
    }

    public int getLengthHard () {
        return wordHard.size();
    }


    public String getEasyWord() {
        int randomWord = (int) (Math.random() * wordEasy.size());
        String word = wordEasy.get(randomWord);
        wordEasy.remove(randomWord);
        return word;
    }

    public String getNormalWord() {
        int randomWord = (int) (Math.random() * wordNormal.size());
        String word = wordNormal.get(randomWord);
        wordNormal.remove(randomWord);
        return word;
    }

    public String getHardWord() {
        int randomWord = (int) (Math.random() * wordHard.size());
        String word = wordHard.get(randomWord);
        wordHard.remove(randomWord);
        return word;
    }
}
