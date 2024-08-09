package aritmetic;

import java.util.function.BiFunction;

public class Calculator {

    public double compute(double a, double b, Arithmetic arithmetic) {
        return arithmetic.operation(a, b);
    }

    public double computeFunctional(double a, double b, BiFunction<Double, Double, Double> lambda)
    {
        return lambda.apply(a, b);
    }
}
