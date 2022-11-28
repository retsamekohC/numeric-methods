package org.example;

import nonlinear.equation.solve.methods.*;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        Function<Double, Double> function = new Function<Double, Double>() {
            @Override
            public Double apply(Double x) {
                return 1/Math.tan(x + 1) - x * x;
            }
        };
        Function<Double, Double> derivative = new Function<Double, Double>() {
            @Override
            public Double apply(Double x) {
                return -1 / (Math.sin(x + 1) * Math.sin(x + 1)) - 2 * x;
            }
        };
        Function<Double, Double> secondDerivative = new Function<Double, Double>() {
            @Override
            public Double apply(Double x) {
                return 2 * Math.cos(x + 1) / Math.sin(x + 1) * Math.sin(x + 1) * Math.sin(x + 1) - 2;
            }
        };
        Function<Double, Double> simpleIterFunc = new Function<Double, Double>() {
            @Override
            public Double apply(Double x) {
                return Math.sqrt(1/Math.tan(x+1));
            }
        };
        AbstractMethod dihotomia = new Dihotomia(function, derivative, secondDerivative);
        System.out.println(dihotomia.findRoot(0,1));
        AbstractMethod notMovingHords = new NotMovingHords(function, derivative, secondDerivative);
        System.out.println(notMovingHords.findRoot(0,1));
        AbstractMethod movingHords = new MovingHords(function, derivative, secondDerivative);
        System.out.println(movingHords.findRoot(0,1));
        AbstractMethod newton = new Newton(function, derivative, secondDerivative);
        System.out.println(newton.findRoot(0,1));
        AbstractMethod parabola = new Parabola(function, derivative, secondDerivative);
        System.out.println(parabola.findRoot(0,1));
        AbstractMethod simpleIter = new SimpleIteration(function, derivative, secondDerivative, simpleIterFunc);
        System.out.println(simpleIter.findRoot(0.4,0.45));
    }
}