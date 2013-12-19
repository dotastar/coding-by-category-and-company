package FreePractise;

import java.io.IOException;

import junit.framework.Assert;

public class DetectValidNumber {

    /**
     * 1. don't consider scientific notation;
     * 2. 1.xxxxx true; 1.x.xxxx false; x. false;
     * 3. 0.xxxx true; 0xxxxx false;
     * using finite-state machine to complete this task is very efficient!
     * 
     * @param src
     * @return
     */
    static enum STATE {
        INITIAL_STATE,
        POSITIVE_STATE,
        NEGATIVE_STATE,
        INTEGER_STATE,
        ZERO_STATE,
        DOT_STATE,
        DECIMAL_STATE,
        FAIL_STATE;
    }

    public static boolean detectValidNumber(String src) {
        STATE curState = STATE.INITIAL_STATE;
        for (int i = 0; i < src.length(); i++) {
            curState = stateTransmission(curState, src.charAt(i));
            if (curState == STATE.FAIL_STATE)
                return false;
        }
        if (curState == STATE.INTEGER_STATE || curState == STATE.DECIMAL_STATE) //NOTE the only condition for success!
            return true;
        else
            return false;
    }

    public static STATE stateTransmission(STATE state, char c) {
        STATE output = STATE.FAIL_STATE;
        switch (state) {
            case INITIAL_STATE:
                if (c == '+') {
                    output = STATE.POSITIVE_STATE;
                } else if (c == '-') {
                    output = STATE.NEGATIVE_STATE;
                } else if ((c > '0') && (c <= '9'))
                    output = STATE.INTEGER_STATE;
                else if (c == '0')
                    output = STATE.ZERO_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case POSITIVE_STATE:
                if ((c > '0') && (c <= '9'))
                    output = STATE.INTEGER_STATE;
                else if (c == '0')
                    output = STATE.ZERO_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case NEGATIVE_STATE:
                if ((c > '0') && (c <= '9'))
                    output = STATE.INTEGER_STATE;
                else if (c == '0')
                    output = STATE.ZERO_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case INTEGER_STATE:
                if ((c >= '0') && (c <= '9'))
                    output = STATE.INTEGER_STATE;
                else if (c == '.')
                    output = STATE.DOT_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case ZERO_STATE:
                if (c == '.')
                    output = STATE.DOT_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case DOT_STATE:
                if ((c >= '0') && (c <= '9'))
                    output = STATE.DECIMAL_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case DECIMAL_STATE:
                if ((c >= '0') && (c <= '9'))
                    output = STATE.DECIMAL_STATE;
                else
                    output = STATE.FAIL_STATE;
                break;
            case FAIL_STATE:
                break;
            default:
                break;
        }
        return output;
    }

    public static void test() throws IOException {
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("adsjbfjdbf"));
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("012345"));
        Assert.assertEquals(true, DetectValidNumber.detectValidNumber("-1"));
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("-0")); 
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("+0"));//NOTE
        Assert.assertEquals(true, DetectValidNumber.detectValidNumber("94599450"));
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("578456846i893749375"));
        Assert.assertEquals(true, DetectValidNumber.detectValidNumber("0.1234567"));
        Assert.assertEquals(true, DetectValidNumber.detectValidNumber("335845684.0000"));
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("335845680.00001u1290"));
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("335845680.")); //NOTE
        Assert.assertEquals(true, DetectValidNumber.detectValidNumber("1.7")); //NOTE
        Assert.assertEquals(false, DetectValidNumber.detectValidNumber("1.7.")); //NOTE
        Assert.assertEquals(true, DetectValidNumber.detectValidNumber("0.00")); //NOTE
    }

    public static void main(String[] args) throws IOException {
        DetectValidNumber.test();
        System.out.println("complete!");
    }
}
