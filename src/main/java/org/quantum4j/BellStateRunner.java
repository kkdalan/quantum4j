package org.quantum4j;

import java.util.Arrays;

public class BellStateRunner {
	
    public static void main(String[] args) {
        TwoQubitSystem system = new TwoQubitSystem();

        system.applyHadamardToQubit0();
        system.applyCNOT_0to1();

        system.printState(); // Optional: 印出振幅

        for (int i = 0; i < 10; i++) {
            int[] result = system.measure();
            System.out.println("測量結果: " + Arrays.toString(result));
        }
    }
}
