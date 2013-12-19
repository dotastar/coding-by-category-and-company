package Parasoft;

import java.io.IOException;

public class question3 {
    
    /**
     * how to represent a ratinalNumber
     * @author hadoop
     *
     */
    public class rationalNum {
        public int numerator;
        public int denomitor;
        public int gcd;

        public rationalNum() {
            numerator = 0;
            denomitor = 1;
            gcd = 1;
        }

        public rationalNum(int numerator, int denomitor) throws IOException {
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

        public void add(rationalNum other) {
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
    
}
