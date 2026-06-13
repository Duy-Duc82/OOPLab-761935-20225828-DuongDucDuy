import java.util.Scanner;

public class MonthDaysDisplay {
    public static boolean ktraYear(int n) {
        return n >= 0;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int yy;
        while (true) {
            System.out.print("Enter a year: ");
            yy = keyboard.nextInt();
            if (ktraYear(yy)) break;
            System.out.println("The year is invalid. Please enter again.");
        }
        keyboard.nextLine();

        boolean isLeapYear = (yy % 4 == 0 && (yy % 100 != 0 || yy % 400 == 0));

        while (true) {
            System.out.print("Enter a month: ");
            String mm = keyboard.nextLine();

            switch (mm) {
                case "January", "Jan.", "Jan", "1":
                case "March", "Mar.", "Mar", "3":
                case "May", "5":
                case "July", "Jul", "7":
                case "August", "Aug.", "Aug", "8":
                case "October", "Oct.", "Oct", "10":
                case "December", "Dec.", "Dec", "12":
                    System.out.println("This month has 31 days.");
                    break;

                case "April", "Apr.", "Apr", "4":
                case "June", "Jun", "6":
                case "September", "Sep.", "Sep", "9":
                case "November", "Nov.", "Nov", "11":
                    System.out.println("This month has 30 days.");
                    break;

                case "February", "Feb.", "Feb", "2":
                    System.out.println(isLeapYear ? "This month has 29 days." : "This month has 28 days.");
                    break;

                default:
                    System.out.println("Invalid month entered. Please enter again.");
                    continue;
            }
            break;
        }

        keyboard.close();
    }
}
