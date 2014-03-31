package zillow;

import java.io.IOException;
import junit.framework.Assert;

/**
 * @author Nan Zhang
 */
public class Question1 {

    /**
     * convert a string to long, if this converted number is too big, a exception is thrown
     * @param s
     * @return
     * @throws IOException
     */
    public static long stringToLong(String s) throws IOException {
        boolean isPositive = true;
        if (s.charAt(0) == '-') {
            isPositive = false;
            s = s.substring(1, s.length());
        }
        if (!s.matches("^[0-9]+$"))
            throw new IOException("this string only can contain numeric characters!");
        long result = 0;
        int strLength = s.length();
        for (int i = 0; i < strLength; i++) {
            result *= 10;
            result += isPositive ? (s.charAt(i) - '0') : -1 * (s.charAt(i) - '0');
            if (result < 0 && isPositive)
                throw new IOException("this number is overflow!");
            if (result > 0 && !isPositive)
                throw new IOException("this number is overflow!");
        }
        return result;
    }

    /**
     * test for stringToLong(String s)
     * @throws IOException
     */
    public static void test() throws IOException {
        //create a input string randomly (in normal range!);
        StringBuilder dataInput = new StringBuilder();
        int min = 0;
        int max = 9;
        for (int i = 0; i < 18; i++) {
            dataInput.append(min + (int) (Math.random() * ((max - min) + 1)));
        }
        Assert.assertEquals((long) Long.valueOf(dataInput.toString()), stringToLong(dataInput.toString()));
        Assert.assertEquals((long) Long.valueOf("-" + dataInput.toString()), stringToLong("-" + dataInput.toString()));
        //boundary case: 9223372036854775807(2^63-1); -9223372036854775808(-2^63)
        String boundary1 = "9223372036854775807"; // 2^63-1
        String boundary2 = "-9223372036854775808"; // -2^63
        Assert.assertEquals((long) (Math.pow(2, 63) - 1), stringToLong(boundary1));
        Assert.assertEquals((long) (-1 * Math.pow(2, 63)), stringToLong(boundary2));
        try {
            stringToLong("9223372036854775808");
            Assert.fail("no exception thrown");
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
        try {
            stringToLong("-9223372036854775809");
            Assert.fail("no exception thrown");
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }
    }

    public static void main(String[] args) throws IOException {
        Question1.test();
        System.out.println("test complete!");
    }
}
