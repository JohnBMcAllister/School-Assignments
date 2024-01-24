import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

public class Day1Prob1 {

    static HashMap<String, Integer> spelledDigits = new HashMap<>() {{
        put("one", 1);
        put("two", 2);
        put("three", 3);
        put("four", 4);
        put("five", 5);
        put("six", 6);
        put("seven", 7);
        put("eight", 8);
        put("nine", 9);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = Utils.readInputFile();
        int sum1 = 0;
        int sum2 = 0;

        String line;
        while ((line = reader.readLine()) != null) {
            int[] digits1 = getCalibrationValueDigits(line, false);
            sum1 += digits1[0] * 10 + digits1[1];

            int[] digits2 = getCalibrationValueDigits(line, true);
            sum2 += digits2[0] * 10 + digits2[1];
        }

        System.out.println("Part 1:" + sum1);
        System.out.println("Part 2:" + sum2);
        reader.close();
    }

    public static int[] getCalibrationValueDigits(String line, boolean readSpelledDigits) {
        StringBuilder readPart = new StringBuilder();
        int firstDigit = -1;
        int lastDigit = -1;

        for (int i = 0; i < line.length(); i++) {
            int digit = -1;
            char c = line.charAt(i);
            readPart.append(c);

            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else if (readSpelledDigits) {
                digit = getSpelledDigit(readPart.toString());
            }

            if (digit == -1) continue;

            if (firstDigit == -1) {
                firstDigit = digit;
            }

            lastDigit = digit;
        }

        return new int[]{firstDigit, lastDigit};
    }

    public static int getSpelledDigit(String str) {
        int digit = -1;

        for (String key : spelledDigits.keySet()) {
            if (key.length() > str.length()) continue;

            String subbed = str.substring(str.length() - key.length());
            if (!subbed.equals(key)) continue;

            digit = spelledDigits.get(key);
            break;
        }

        return digit;
    }
}