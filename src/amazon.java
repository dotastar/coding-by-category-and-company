import junit.framework.Assert;

public class amazon {
    public static String removeVowels1(String str) {
        char[] data = str.toCharArray();
        int newLen = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != 'a' && data[i] != 'e' && data[i] != 'i' && data[i] != 'o' && data[i] != 'u'
                    && data[i] != 'A' && data[i] != 'E' && data[i] != 'I' && data[i] != 'O' && data[i] != 'U') {
                data[newLen++] = data[i];
            }
        }
        return new String(data, 0, newLen);
    }

    public static String removeVowels2(String string) {
        final String vowels = "AaEeIiOoUu";
        final StringBuilder builder = new StringBuilder();
        for (final char c : string.toCharArray())
            if (vowels.indexOf(c) < 0) {
                builder.append(c);
            }
        return builder.toString();
    }

    public static String removeVowels3(String s) {
        StringBuffer res = new StringBuffer();
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                case 'u':
                case 'U':
                    break; // Do nothing
                default:
                    res.append(c);
            }
        }
        return res.toString();
    }

    public static boolean checkRotation(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        return (s1 + s1).indexOf(s2) != -1;
    }

    public static boolean checkGrayCode(int a, int b) {
        int c = a ^ b;
        return (c & (c - 1)) == 0;
    }

    public static void main(String[] args) {
        Assert.assertEquals(removeVowels1("A really COOL string"), removeVowels3("A really COOL string"));
        System.out.println("test complete!");
    }
}
