package GallowsGameGUI;

import java.util.Arrays;
import java.util.Random;

public class PrepareWord {
    private static final String[] WORDS = {"vienna", "brussels", "prague", "copenhagen", "london", "paris", "berlin", "athens", "reykjavik", "rome", "bern", "bratislava", "bucharest", "helsinki", "dublin", "lisbon", "madrid", "moscow", "oslo", "stockholm", "tallinn", "warsaw", "zagreb"};
    private static String[] OPEN_TEXT_ARRAY;
    private static String[] HIDDEN_TEXT_ARRAY;


    public static String pickRandomWord() {
        Random random = new Random();
        int intrandom = random.nextInt(WORDS.length - 1);
        String word = WORDS[intrandom];
        OPEN_TEXT_ARRAY = word.split("", 0);
        HIDDEN_TEXT_ARRAY = new String[OPEN_TEXT_ARRAY.length];
        Arrays.fill(HIDDEN_TEXT_ARRAY, "_");
        return WORDS[intrandom];
    }
}
