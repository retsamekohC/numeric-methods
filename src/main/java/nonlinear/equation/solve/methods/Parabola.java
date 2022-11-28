package nonlinear.equation.solve.methods;

import java.util.function.Function;

public class Parabola extends AbstractMethod{

    public Parabola(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative) {
        super(function, derivative, secondDerivative);
    }

    @Override
    public String findRoot(double a, double b) {
        var xn = b;
        var M = Math.abs(secondDerivativeFunction.apply(b));
        var m = Math.abs(derivativeFunction.apply(a));
        a = -M / 2;
        b = derivativeFunction.apply(xn);
        var c = function.apply(xn);
        var deltaXn = getRoots(a, b, c);
        var xnPlus1 = xn + deltaXn;
        while ((M / (2 * m) * Math.abs(xnPlus1 - xn)*Math.abs(xnPlus1 - xn)) >= epsilon) {
            xn = xnPlus1;
            a = -M / 2;
            b = derivativeFunction.apply(xn);
            c = function.apply(xn);
            deltaXn = getRoots(a, b, c);
            xnPlus1 = xn + deltaXn;
            iteration_count+=1;
        }
        return String.format("5. Метод парабол\r\nРешение: %.10f, Итераций: %d", xnPlus1, iteration_count);
    }

    public double getRoots(double a, double b, double c) {
        double sqrt = Math.sqrt(b * b - 4 * a * c);
        var x1 = (-b + sqrt) / (2 * a);
        var x2 = (-b - sqrt) / (2 * a);
        return Math.max(x1, x2);
    }
}
