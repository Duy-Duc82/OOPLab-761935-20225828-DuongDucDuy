import java.util.Arrays;
import java.util.Scanner;

public class ArrayStatsSort {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n;
        do {
            System.out.print("Enter number of elements (positive integer): ");
            while (!keyboard.hasNextInt()) {
                System.out.print("Invalid input. Enter a positive integer: ");
                keyboard.next();
            }
            n = keyboard.nextInt();
        } while (n <= 0);

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            while (!keyboard.hasNextInt()) {
                System.out.print("Invalid input. Enter an integer: ");
                keyboard.next();
            }
            arr[i] = keyboard.nextInt();
        }

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        double avg = (double) sum / n;

        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("Sorted array:   " + Arrays.toString(sorted));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);

        keyboard.close();
    }
}
