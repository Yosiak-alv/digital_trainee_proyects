import aritmetic.Arithmetic;
import aritmetic.Calculator;

public class ExampleInterfaceFunctional {
    public static void main(String[] args) {
        Arithmetic sum = Double::sum;
        Arithmetic subtraction = (a, b) -> a - b;

        Calculator calculator = new Calculator();

        System.out.println(calculator.compute(10, 5, sum));
        System.out.println(calculator.compute(10, 5, subtraction));
        System.out.println(calculator.computeFunctional(10, 5, (a,b) -> a * b));
    }
}
