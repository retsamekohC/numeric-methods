package nonlinear.equation.solve.methods;

import java.util.function.Function;

public class NotMovingHords extends AbstractMethod {

    public NotMovingHords(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative) {
        super(function, derivative, secondDerivative);
    }

    @Override
    public String findRoot(double a, double b) {
        var xn = b;
        var xn_plus_1 = xn - (function.apply(xn) * (xn - a) / (function.apply(xn) - function.apply(a)));
        while (Math.abs(function.apply(xn_plus_1))>=epsilon){
            xn = xn_plus_1;
            xn_plus_1 = xn - (function.apply(xn) / (function.apply(xn) - function.apply(a))) * (xn - a);
            iteration_count += 1;
        }
        return String.format("2. Метод неподвижных хорд\r\nРешение: %.10f, Итераций: %d", xn_plus_1, iteration_count);
    }
}
