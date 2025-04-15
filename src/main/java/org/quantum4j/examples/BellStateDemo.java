package org.quantum4j.examples;

import org.quantum4j.QuantumCircuit;
import java.util.Arrays;

public class BellStateDemo {
	
	public static void main(String[] args) {
		QuantumCircuit qc = new QuantumCircuit(2);
		qc.entangle(0, 1);

		int[] result = qc.measureAll();
		System.out.println("Bell state measurement: " + Arrays.toString(result));
	}
}
