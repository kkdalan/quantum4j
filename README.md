# Quantum4J

🚀 A lightweight quantum computing simulation library for Java.  
🎯 Designed for education, experimentation, and fun!

## Features

- Qubit representation with superposition
- Quantum gates: Hadamard, Pauli-X, CNOT
- Entanglement creation (Bell state)
- Simple circuit-based API

## Example

```java
QuantumCircuit qc = new QuantumCircuit(2);
qc.entangle(0, 1);
int[] result = qc.measureAll();
System.out.println(Arrays.toString(result)); // → [0, 0] or [1, 1]
