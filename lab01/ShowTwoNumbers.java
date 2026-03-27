// Example 5: ShowTwoNumbers.java
import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1;
        String strNum2;
        String strNotification;

        strNum1 = JOptionPane.showInputDialog("Please input the first number:");
        strNum2 = JOptionPane.showInputDialog("Please input the second number:");
        strNotification = "You just entered: " + strNum1 + " and " + strNum2;

        JOptionPane.showMessageDialog(null, strNotification, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}