package java;

public class IntegerImmutable {

    public static void big(Integer s) {
        s++; //NOTE each time when s++, s--, s automatically create a new instance and pointed to this new instance
    }

    public static void main(String[] args) {
        Integer s = new Integer(1); //NOTE after Integer, String is created, they are fixed, can not change the value
                                    //NOTE string+= operation just create new instance
        big(s);
        System.out.println(s); //NOTE found that s didn't change the value outside
    }
}
