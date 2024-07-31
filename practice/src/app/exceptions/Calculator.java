package app.exceptions;

public class Calculator {
    public double divide(int a, int b) throws ZeroDivisionExeption {
        if (b == 0) {
            throw new ZeroDivisionExeption("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public double divide(String a, String b) throws ZeroDivisionExeption {
        try {
            int intA = Integer.parseInt(a);
            int intB = Integer.parseInt(b);
            return divide(intA, intB);
        } catch (NumberFormatException e) {
            throw new ZeroDivisionExeption("Cannot parse input to integer");
        }
    }
}
