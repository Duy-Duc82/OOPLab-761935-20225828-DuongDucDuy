package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java hust.soict.hedspi.garbage.NoGarbage <path-to-large-file>");
            return;
        }

        Path filePath = Path.of(args[0]);
        byte[] inputBytes = Files.readAllBytes(filePath);

        long start = System.nanoTime();
        StringBuffer buffer = new StringBuffer(inputBytes.length);

        for (byte b : inputBytes) {
            buffer.append((char) (b & 0xFF));
        }

        String output = buffer.toString();
        long end = System.nanoTime();

        System.out.println("File: " + filePath.toAbsolutePath());
        System.out.println("Bytes read: " + inputBytes.length);
        System.out.println("Output length: " + output.length());
        System.out.printf("NoGarbage (StringBuffer) time: %.3f ms%n", (end - start) / 1_000_000.0);

        if (output.length() > 0) {
            System.out.println("First char code: " + (int) output.charAt(0));
        }
    }
}
