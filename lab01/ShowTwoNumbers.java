// Example 5: ShowTwoNumbers.java
import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Please input the first number:");
        String strNum2 = JOptionPane.showInputDialog("Please input the second number:");

        try {
            double num1 = Double.parseDouble(strNum1);
            double num2 = Double.parseDouble(strNum2);

            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;

            String quotientStr;
            if (num2 == 0.0) {
                quotientStr = "Cannot divide by zero";
            } else {
                double quotient = num1 / num2;
                quotientStr = String.valueOf(quotient);
            }

            String message = "You entered: " + strNum1 + " and " + strNum2 + "\n"
                    + "Sum: " + sum + "\n"
                    + "Difference: " + difference + "\n"
                    + "Product: " + product + "\n"
                    + "Quotient: " + quotientStr;

            JOptionPane.showMessageDialog(null, message, "Calculation Results", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }

        System.exit(0);
    }
}