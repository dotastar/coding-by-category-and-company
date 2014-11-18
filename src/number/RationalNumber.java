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
package number;

import java.io.IOException;
import java.util.HashMap;

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
        this.numerator = numerator;
        this.denomitor = denomitor;
        if (this.numerator > this.denomitor) {
            this.gcd = GCD(this.numerator, this.denomitor);
        } else {
            this.gcd = GCD(this.denomitor, this.numerator);
        }
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

    //NOTE prints the decimal representation of the rational number "numerator/denominator".
    //NOTE Since all rational numbers end with a repeating section, print the repeating section of digits inside parentheses
    public void printDecimal() {
        int real = this.numerator / this.denomitor;
        int remain = this.numerator % this.denomitor;
        StringBuilder decimal = new StringBuilder();
        HashMap<Integer, Integer> remainders = new HashMap<Integer, Integer>();
        for (int i = 0; remain != 0; i++) {
            if (!remainders.containsKey(remain)) {
                remainders.put(remain, i);
            } else {
                decimal.insert((int) (remainders.get(remain)), '(');
                break;
            }
            remain *= 10;
            int digit = remain / this.denomitor;
            remain = remain % this.denomitor;
            decimal.append(digit);
        }
        if (remain != 0) {
            decimal.append(')');
        }
        System.out.println(real + "." + decimal.toString());
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

    public static void main(String[] args) throws IOException {
        RationalNumber test = new RationalNumber(22, 7);
        test.printDecimal();
    }
}
