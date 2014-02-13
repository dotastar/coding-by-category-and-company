package originate;

import java.util.ArrayList;

public class Questions1 {
    public static int[] removeDuplicates(int[] src) {
        if(src == null)
            return null;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int index = 0;
        temp.add(src[0]);
        for (int i = 0; i < src.length; i++) {
            if (src[i] != src[index]) {
                temp.add(src[i]);
                index = i;
            }
        }
        int[] output = new int[temp.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = temp.get(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] test = { 1, 2, 2, 2, 3, 4, 7, 7, 7 };
        int[] print = Questions1.removeDuplicates(test);
        for (int i = 0; i < print.length; i++)
            System.out.println(print[i]);
    }
}
