package com.aostrovskyi.samples.patterns.strategy;

public class RealDiscriminantStrategy implements DiscriminantStrategy {
    @Override
    public double calculateDiscriminant(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return Double.NaN;
        }
        return discriminant;
    }
}
