package nonlinear.equation.solve.methods;

import java.util.function.Function;

public class Newton extends AbstractMethod{

    public Newton(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative) {
        super(function, derivative, secondDerivative);
    }

    @Override
    public String findRoot(double a, double b) {
        double xn = a;
        var M = Math.abs(secondDerivativeFunction.apply(b));
        var m = Math.abs(derivativeFunction.apply(a));
        var xnPlus1 = xn - function.apply(xn) / derivativeFunction.apply(xn);
//Критейрий остановки
        while ((M / (2 * m) * Math.abs(xnPlus1 - xn)*Math.abs(xnPlus1 - xn)) >= epsilon) {
            xn = xnPlus1;
            xnPlus1 = xn - function.apply(xn) / derivativeFunction.apply(xn);
            iteration_count += 1;
        }
        return String.format("4. Метод Ньютона\r\nРешение: %.10f, Итераций: %d", xnPlus1, iteration_count);
    }
}
