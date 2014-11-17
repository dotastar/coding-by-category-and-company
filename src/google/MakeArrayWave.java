/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   MakeArrayWave.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   u = [u1, u2, u3, u4, u5, u6, ..]
 *                    reorder to s = [s1, s2, s3, s4, s5, s5, ..]
 *                    s1 <= s2, s2 >=s3, s3 <= s4, s4 >= s5,.....
 * All rights reserved.
 ******************************************************************************/
package google;

public class MakeArrayWave {
    public void makeWave(int[] data){
        if(data == null || data.length < 1){
            return;
        }
        boolean flag = true;
        for(int i = 1; i < data.length; i++){
            if((flag && data[i - 1] > data[i]) || (!flag && data[i - 1] <= data[i])){
                swap(data, i - 1, i);
            }
            flag = !flag;
        }
    }
    public void swap(int[] data, int i, int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
