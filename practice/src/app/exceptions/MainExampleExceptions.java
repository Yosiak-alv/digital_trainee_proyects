package app.exceptions;

import javax.swing.*;

public class MainExampleExceptions {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        String numerator = JOptionPane.showInputDialog("Enter the numerator:");
        String denominator = JOptionPane.showInputDialog("Enter the denominator:");

        try {
            double result = calculator.divide(numerator, denominator);
            JOptionPane.showMessageDialog(null, "Result: " + result);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (ZeroDivisionExeption e2) {
            JOptionPane.showMessageDialog(null, e2.getMessage());
        }
        finally {
            JOptionPane.showMessageDialog(null, "Thank you for using our calculator!");
        }
    }
}
