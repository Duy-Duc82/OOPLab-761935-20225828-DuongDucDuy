import java.util.Scanner;

public class ArraySorting {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = keyboard.nextInt();

        int[] a = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();

        for (int i = 1; i < n; i++) {
            int mid = a[i];
            int j = i - 1;
            while (j >= 0 && mid < a[j]) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = mid;
        }

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        double sum=0;
        for (int i = 0; i < n; i++) {
            sum+= (double) a[i];
        }
        double aver= sum/n;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + aver);
        System.exit(0);
    }
}
