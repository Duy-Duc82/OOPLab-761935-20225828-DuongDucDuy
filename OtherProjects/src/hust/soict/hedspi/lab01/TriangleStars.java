package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class TriangleStars {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter n (height of triangle, positive integer): ");
            while (!keyboard.hasNextInt()) {
                System.out.print("Invalid input. Enter a positive integer: ");
                keyboard.next();
            }
            n = keyboard.nextInt();
        } while (n <= 0);

        for (int i = 1; i <= n; i++) {
            int spaces = n - i;
            int stars = 2 * i - 1;

            for (int s = 0; s < spaces; s++) {
                System.out.print(" ");
            }
            for (int s = 0; s < stars; s++) {
                System.out.print("*");
            }
            System.out.println();
        }

        keyboard.close();
    }
}

