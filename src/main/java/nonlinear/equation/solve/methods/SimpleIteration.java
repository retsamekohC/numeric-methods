package nonlinear.equation.solve.methods;

import java.util.function.Function;

public class SimpleIteration extends AbstractMethod{

    Function<Double, Double> functionSimpleIterationMethod;

    public SimpleIteration(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative, Function<Double, Double> functionSimpleIterationMethod) {
        super(function, derivative, secondDerivative);
        this.functionSimpleIterationMethod = functionSimpleIterationMethod;
    }

    @Override
    public String findRoot(double a, double b) {
        double xn = a;
        var xn_plus_1 = functionSimpleIterationMethod.apply(xn);
        var delta = Math.abs(xn_plus_1-xn);
        var q = 0.842;
        while(Math.abs(xn-xn_plus_1)>=epsilon)
        {
            xn = xn_plus_1;
            xn_plus_1 = functionSimpleIterationMethod.apply(xn);
            iteration_count+=1;
        }
        return String.format("6. Метод простой итерации\r\nРешение: %.10f, Итераций: %d", xn_plus_1, iteration_count);
    }
}
