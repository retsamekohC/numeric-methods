package nonlinear.equation.solve.methods;

import java.util.function.Function;

public abstract class AbstractMethod {
    Double ctg(double arg) {
        return 1 / Math.tan(arg);
    }

    Function<Double, Double> function = new Function<Double, Double>() {
        @Override
        public Double apply(Double x) {
            return ctg(x + 0.4) - x * x;
        }
    };
    Function<Double, Double> derivativeFunction = new Function<Double, Double>() {
        @Override
        public Double apply(Double x) {
            return -1 / (Math.sin(x + 0.4) * Math.sin(x + 0.4)) - 2 * x;
        }
    };
    Function<Double, Double> secondDerivativeFunction = new Function<Double, Double>() {
        @Override
        public Double apply(Double x) {
            return 2 * Math.cos(x + 0.4) / Math.sin(x + 0.4) * Math.sin(x + 0.4) * Math.sin(x + 0.4) - 2;
        }
    };
    Double epsilon = 10e-5;
    Integer iteration_count = 1;

    public AbstractMethod(Function<Double, Double> function, Function<Double, Double> derivative, Function<Double, Double> secondDerivative) {
        this.function = function;
        this.derivativeFunction = derivative;
        this.secondDerivativeFunction = secondDerivative;
    }

    public abstract String findRoot(double a, double b);
}
