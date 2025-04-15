package org.quantum4j;

import java.util.Arrays;

public class QuantumCircuit {
	
    private final QuantumBit[] qubits;

    public QuantumCircuit(int numQubits) {
        this.qubits = new QuantumBit[numQubits];
        for (int i = 0; i < numQubits; i++) {
            qubits[i] = new QuantumBit();
        }
    }

    public void applyHadamard(int index) {
        qubits[index].applyGate(QuantumGate.HADAMARD);
    }

    public void entangle(int q1, int q2) {
        applyHadamard(q1);
        QuantumGate.applyCNOT(qubits[q1], qubits[q2]);
    }

    public int[] measureAll() {
        int[] results = new int[qubits.length];
        for (int i = 0; i < qubits.length; i++) {
            results[i] = qubits[i].measure();
        }
        return results;
    }

    public QuantumBit[] getQubits() {
        return qubits;
    }

    @Override
    public String toString() {
        return Arrays.toString(qubits);
    }
}
