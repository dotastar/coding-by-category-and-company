/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DecimalToFraction.java
 *         Created:   9/10
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   how to represent a ratinalNumber
 *                    
 * All rights reserved.
 ******************************************************************************/
package math_number;

import java.io.IOException;

public class RationalNumber {

    public int numerator;
    public int denomitor;
    public int gcd;

    public RationalNumber() {
        numerator = 0;
        denomitor = 1;
        gcd = 1;
    }

    public RationalNumber(int numerator, int denomitor) throws IOException {
        if (denomitor == 0)
            throw new IOException("denomitor can not be 0!");
        this.gcd = GCD(this.numerator, this.denomitor);
        simplest(this.numerator, this.denomitor);
    }

    public int GCD(int numerator, int denomitor) {
        return denomitor == 0 ? numerator : GCD(denomitor, numerator % denomitor);
    }

    public int LCM(int etc1, int etc2) {
        return etc1 * etc2 / GCD(etc1, etc2);
    }

    public void simplest(int numerator, int denomitor) {
        this.numerator = this.numerator / gcd;
        this.denomitor = this.denomitor / gcd;
    }

    public void printDecimal() {
        String decimal = String.valueOf(((double) (this.numerator % this.denomitor) / this.denomitor));
        decimal.substring(1);
        decimal = String.valueOf(this.numerator / this.denomitor) + decimal;
        System.out.println(decimal);
    }

    public void printFraction() {
        System.out.println(this.numerator + "/" + this.denomitor);
    }

    public void add(RationalNumber other) {
        int lcm = LCM(this.denomitor, other.denomitor);
        this.denomitor *= lcm;
        this.numerator *= lcm;
        other.denomitor *= lcm;
        other.numerator *= lcm;
        int commonNumerator = this.numerator + other.numerator;
        this.numerator = commonNumerator;
        this.gcd = GCD(this.numerator, this.denomitor);
        simplest(this.numerator, this.denomitor);
    }
}
