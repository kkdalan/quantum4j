package org.quantum4j;

public class QuantumGate {

    public static final double[][] HADAMARD = {
        { 1 / Math.sqrt(2), 1 / Math.sqrt(2) },
        { 1 / Math.sqrt(2), -1 / Math.sqrt(2) }
    };

    public static final double[][] PAULI_X = {
        { 0, 1 },
        { 1, 0 }
    };

    // Apply CNOT to two qubits (control, target)
    public static void applyCNOT(QuantumBit control, QuantumBit target) {
        // Simple simulation for Bell state generation
        int controlMeasured = control.measure(); // collapse
        if (controlMeasured == 1) {
            target.applyGate(PAULI_X); // flip target
        }
    }

    private QuantumGate() {
        // static only
    }
}
