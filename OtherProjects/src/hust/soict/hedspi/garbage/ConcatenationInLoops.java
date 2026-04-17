package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    private static final int NUMBER_OF_INTEGERS = 65_536;

    public static void main(String[] args) {
        int[] data = new int[NUMBER_OF_INTEGERS];
        Random random = new Random();

        for (int i = 0; i < NUMBER_OF_INTEGERS; i++) {
            data[i] = random.nextInt();
        }

        long plusStart = System.nanoTime();
        String plusResult = concatWithPlus(data);
        long plusEnd = System.nanoTime();

        long builderStart = System.nanoTime();
        String builderResult = concatWithStringBuilder(data);
        long builderEnd = System.nanoTime();

        System.out.println("Integers concatenated: " + NUMBER_OF_INTEGERS);
        System.out.printf("Using '+' operator: %.3f ms%n", (plusEnd - plusStart) / 1_000_000.0);
        System.out.printf("Using StringBuilder: %.3f ms%n", (builderEnd - builderStart) / 1_000_000.0);

        // Print lengths so the compiler cannot optimize away generated strings.
        System.out.println("Result lengths -> plus: " + plusResult.length() + ", builder: " + builderResult.length());
    }

    private static String concatWithPlus(int[] data) {
        String result = "";
        for (int value : data) {
            result += value;
        }
        return result;
    }

    private static String concatWithStringBuilder(int[] data) {
        StringBuilder builder = new StringBuilder();
        for (int value : data) {
            builder.append(value);
        }
        return builder.toString();
    }
}
