/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DecimalToFraction.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   The range allowed is 0.0001 to 0.9999. Only four decimal places are allowed. 
 *                    The output should be an irreducible fraction. 
 *                    
 * All rights reserved.
 ******************************************************************************/
package epic;

public class DecimalToFraction {
    public void convert(double input) {
        int numerator = (int)(input * 10000), denomitor = 10000;
        int gcd = GCD(numerator, denomitor);
        System.out.println(numerator / gcd + "/" + denomitor / gcd);
    }
    
    public int GCD(int numerator, int denomitor) {
        return denomitor == 0 ? numerator : GCD(denomitor, numerator % denomitor);
    }
    
    public static void main(String[] args) {
        DecimalToFraction test = new DecimalToFraction();
        test.convert(0.358);
    }
}
