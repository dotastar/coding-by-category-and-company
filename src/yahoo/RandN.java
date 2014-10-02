/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RandN.java
 *         Created:   5/31
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   generate Random_N() {0, ...n}using given function Random_1() {0, 1}
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class RandN {
    
    public int randomN(int n){//assume n >= 1
        if(n == 1){
            return random1();
        }
        int bitsNum = getNumbits(n), i = 0, res = 0;
        while(i < Integer.MAX_VALUE){//max_iteration
            res = 0;
            while(bitsNum > 0){
                res = res << 1;
                res += random1();
                bitsNum--;
            }
            if(res >= 0 && res <= n){
                return res;
            }
            i++;
        }
        return -1;
    }
    
    private int getNumbits(int n){
        int num = 0;
        while(n > 0){
            n = n >> 1;
            num++;
        }
        return num;
    }
    
    /**
     * this interface is provided by outside to generate 0/1 with equal probability 
     */
    private int random1(){
        return 0 + (int)(Math.random() * (1 - 0 + 1));
    }
}
