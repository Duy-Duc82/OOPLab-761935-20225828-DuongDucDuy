package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class GarbageCreator {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java hust.soict.hedspi.garbage.GarbageCreator <path-to-large-file>");
            return;
        }

        Path filePath = Path.of(args[0]);
        byte[] inputBytes = Files.readAllBytes(filePath);

        long start = System.nanoTime();
        String output = "";

        for (byte b : inputBytes) {
            output += (char) (b & 0xFF);
        }

        long end = System.nanoTime();

        System.out.println("File: " + filePath.toAbsolutePath());
        System.out.println("Bytes read: " + inputBytes.length);
        System.out.println("Output length: " + output.length());
        System.out.printf("GarbageCreator (+) time: %.3f ms%n", (end - start) / 1_000_000.0);

        // Prevent dead-code elimination and keep behavior deterministic.
        if (output.length() > 0) {
            System.out.println("First char code: " + (int) output.charAt(0));
        }
    }
}
