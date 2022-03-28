package com.aostrovskyi.samples.patterns.strategy;

public class QuadraticEquationSolver {
    private final DiscriminantStrategy strategy;

    public QuadraticEquationSolver(DiscriminantStrategy strategy) {
        this.strategy = strategy;
    }

    public Pair<Complex, Complex> solve(double a, double b, double c) {
        double discriminant = strategy.calculateDiscriminant(a, b, c);
        if (Double.isNaN(discriminant)) {
            return new Pair<>(new Complex(Double.NaN, Double.NaN), new Complex(Double.NaN, Double.NaN));
        }

        Complex discriminantSqrt = Complex.sqrt(discriminant);
        Complex minusB = new Complex(-b, 0);
        Complex twoA = new Complex(2 * a, 0);

        Complex firstSolution = minusB.plus(discriminantSqrt).divides(twoA);
        Complex secondSolution = minusB.minus(discriminantSqrt).divides(twoA);

        return new Pair<>(firstSolution, secondSolution);
    }
}
