package originate;

import java.util.Arrays;

public class Questions3 {
    public void printFibonacciSequence(int n) {
        if (n == 0)
            System.out.println(0);
        if (n == 1) {
            System.out.println(0);
            System.out.println(1);
        } else {
            int[] output = new int[n];
            output[0] = 0;
            output[1] = 1;
            for (int i = 2; i < n; i++) {
                output[i] = output[i - 1] + output[i - 2];
            }
            System.out.println(Arrays.toString(output));
        }
    }

}
