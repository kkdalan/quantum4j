package org.quantum4j;

import java.util.Random;

public class QuantumBit {
    private double alpha; // amplitude of |0⟩
    private double beta;  // amplitude of |1⟩
    private static final Random random = new Random();

    public QuantumBit() {
        // Start in |0⟩ state
        this.alpha = 1.0;
        this.beta = 0.0;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBeta() {
        return beta;
    }

    public void setState(double alpha, double beta) {
        double norm = Math.sqrt(alpha * alpha + beta * beta);
        this.alpha = alpha / norm;
        this.beta = beta / norm;
    }

    public int measure() {
        double p0 = alpha * alpha;
        return (random.nextDouble() < p0) ? 0 : 1;
    }

    public void applyGate(double[][] gate) {
        double newAlpha = gate[0][0] * alpha + gate[0][1] * beta;
        double newBeta  = gate[1][0] * alpha + gate[1][1] * beta;
        setState(newAlpha, newBeta);
    }

    @Override
    public String toString() {
        return String.format("α=%.2f |0⟩, β=%.2f |1⟩", alpha, beta);
    }
}
