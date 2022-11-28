package nonlinear.equation.solve.methods;

import java.util.function.Function;

public class MovingHords extends AbstractMethod{

    public MovingHords(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative) {
        super(function, derivative, secondDerivative);
    }

    @Override
    public String findRoot(double a, double b) {
        var xn = b;
        var xn_minus_1 = a;
        var xn_plus_1 = xn_minus_1 - (function.apply(xn_minus_1) * (xn - xn_minus_1) / (function.apply(xn) - function.apply(xn_minus_1)));
        while (Math.abs(function.apply(xn)) > epsilon) {
            xn_minus_1 = xn;
            xn = xn_plus_1;
            xn_plus_1 = xn_minus_1 - (function.apply(xn_minus_1) * (xn - xn_minus_1) / (function.apply(xn) - function.apply(xn_minus_1)));
            iteration_count+=1;
        }
        return String.format("3. Метод подвижных хорд\r\nРешение: %.10f, Итераций: %d", xn_plus_1, iteration_count);
    }
}
