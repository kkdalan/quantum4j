package org.quantum4j;

import java.util.Random;

public class TwoQubitSystem {
	// 四個可能狀態的振幅：|00>, |01>, |10>, |11>
	private double[] amplitudes = new double[4]; // 假設全是實數，簡化處理
	private Random random = new Random();

	public TwoQubitSystem() {
		// 初始為 |00⟩，即第一個振幅為 1，其他為 0
		amplitudes[0] = 1.0;
	}

	public void applyHadamardToQubit0() {
		// 初始 amplitudes: [a00, a01, a10, a11]
		// H on qubit0: 會影響 (|00⟩ 和 |10⟩), (|01⟩ 和 |11⟩)
		double[] newAmplitudes = new double[4];
		newAmplitudes[0] = (amplitudes[0] + amplitudes[2]) / Math.sqrt(2);
		newAmplitudes[1] = (amplitudes[1] + amplitudes[3]) / Math.sqrt(2);
		newAmplitudes[2] = (amplitudes[0] - amplitudes[2]) / Math.sqrt(2);
		newAmplitudes[3] = (amplitudes[1] - amplitudes[3]) / Math.sqrt(2);
		amplitudes = newAmplitudes;
	}

	public void applyCNOT_0to1() {
		// CNOT: 對 qubit0=1 的部分翻轉 qubit1
		// |10⟩ <-> |11⟩
		double temp = amplitudes[2];
		amplitudes[2] = amplitudes[3];
		amplitudes[3] = temp;
	}

	public int[] measure() {
		// 根據振幅平方來抽樣
		double[] probs = new double[4];
		double total = 0;
		for (int i = 0; i < 4; i++) {
			probs[i] = amplitudes[i] * amplitudes[i];
			total += probs[i];
		}

		double r = random.nextDouble() * total;
		double cumulative = 0;
		for (int i = 0; i < 4; i++) {
			cumulative += probs[i];
			if (r <= cumulative) {
				// 解碼為 [q0, q1]
				int q0 = (i & 0b10) >> 1;
				int q1 = i & 0b01;
				return new int[] { q0, q1 };
			}
		}

		// fallback
		return new int[] { 0, 0 };
	}

	public void printState() {
		System.out.printf("State: |00⟩=%.2f, |01⟩=%.2f, |10⟩=%.2f, |11⟩=%.2f%n", amplitudes[0], amplitudes[1],
				amplitudes[2], amplitudes[3]);
	}
}
