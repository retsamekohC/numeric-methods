package nonlinear.equation.solve.methods;

import java.util.function.Function;

public class Dihotomia extends AbstractMethod{

    public Dihotomia(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative) {
        super(function, derivative, secondDerivative);
    }

    @Override
    public String findRoot(double a, double b) {
        while ((b - a)/2*iteration_count > epsilon) {
            double xi = (a + b) / 2;
            if (function.apply(xi) * function.apply(a) < 0)
                b = xi;
            else if (function.apply(xi) * function.apply(b) < 0)
                a = xi;
            iteration_count+=1;
        }
        iteration_count -=1;
        return String.format("1. Метод половинного деления\r\nРешение: %.10f, Итераций: %d", (a + b) / 2, iteration_count);
    }
}
