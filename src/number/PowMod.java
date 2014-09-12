/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PowMod.java
 *         Version:   1.0
 *         Created:   4/6 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to get pow(a, b) % c quickly ?
 *                    NOTE: mod(a * b) = mod(a) * mod(b) think why?
 *            
 * All rights reserved.
 ******************************************************************************/

package number;

public class PowMod {
    
    public static int mod(int a, int b, int c){
        int ans = 1, scale = a % c;
        while(b != 0){
            if((1 & b) == 1){
                ans *= scale;
            }
            ans = ans % c;
            scale = (scale * scale) % c;
            b = b >> 1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(PowMod.mod(5, 6, 5));
    }
}
