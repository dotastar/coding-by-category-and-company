/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RealAverage.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   To compute the average for the unlimited series of numbers without including the largest three numbers. 
 *                    3,6,12,55,289,600,534,900 and 172.  avg=(3+6+12+55+289+172) /6 and eliminating 534,900,600
 *                    
 * All rights reserved.
 ******************************************************************************/
package epic;

import java.util.Scanner;

public class RealAverage {
    public double adaverage() {
        Scanner in = new Scanner(System.in);
        int next = 0;
        if(in.hasNext()){
            next = in.nextInt();            
        }else{
            in.close();
            return 0;
        }
        int[] max = new int[3];
        int count = 0, sum = 0;
        while (in.hasNext()) {
            if (count < 3) {
                max[count] = next;
            } else {
                for (int i = 0; i < 3; i++) {//NOTE get the mimum from unsorted array in this way
                    if (next > max[i]) {
                        int temp = max[i];
                        max[i] = next;
                        next = temp;
                    }
                }
                sum += next;
            }
            count++;
            next = in.nextInt();
        }
        in.close();
        if (count > 3)
            return ((double) (sum)) / (count - 3);
        else
            return 0;
    }
}
