package javabasic;

import java.io.UnsupportedEncodingException;

public class SignExtension {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //NOTE 0xff and 0b...'s meaning
        //0xff, denoted by hex, is a int, and its higher bytes are all zero (don't need sign extension)
        //0b101010101, denoted by binary, is a int, and higher bytes are all zero (don't need sign extension)
        System.out.println(0b10101010);
        System.out.println(0b1000_0000_0000_0000_0000_0000_0000_0000);

        //NOTE how to initialize the byte array
        byte[] testDynamicArray = new byte[] { 0x01, (byte) 0xff };
        byte[] testStaticArray = { 0x01, (byte) 0xff };

        //NOTE how to print a integer to binary code
        int testInt = 150;
        System.out.println(Integer.toBinaryString(testInt));

        //NOTE (byte extends to int before doing shift operation)
        byte b = (byte) 0xf1;
        byte c = (byte) (b >> 4);
        byte d = (byte) (b >>> 4);
        byte e = (byte) ((b & 0xff) >> 4);
        System.out.println(e);//see stackoverflow

        //NOTE 0b.. and 0x.. are all int, and don't do sign extension
        byte g = (byte) (0b10101010 >> 1);
        System.out.println(g);
        byte x = (byte) 0b10101010;
        byte h = (byte) (x >> 1);//before doing a computation, byte will convert to integer and do the sign extension first! 
        System.out.println(h);
    }
}
