import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class Utils {

    static final String INPUT_FILE = "lexicon.txt";
    static final String EXAMPLE_FILE = "input.example.txt";

    public static BufferedReader readExampleFile() {
        return Utils.readFileFromPath(Utils.EXAMPLE_FILE);
    }

    public static BufferedReader readInputFile() {
        return Utils.readFileFromPath(Utils.INPUT_FILE);
    }

    public static BufferedReader readFileFromPath(String filePath) {
        BufferedReader bufferedReader = null;

        try {
            FileReader fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
            System.out.printf("Failed to read '%s' file.", filePath);
            System.exit(1);
        }

        return bufferedReader;
    }
}