package javabasic;

import java.io.IOException;

public class CheckedOrUnCkExceptionExample {
    public void checkedExceptionWithoutTryCatch1(int a) throws IOException {
        if (a < 0)
            throw new IOException("sdfs");
    }

    public void checkedExceptionWithoutTryCatch2() throws IOException {

        checkedExceptionWithoutTryCatch1(-1);
        System.out.println("sdfsdfs");//NOTE: will not excute!
    }

    public void uncheckedException(int b) {
        if (b < 0)
            throw new ArrayIndexOutOfBoundsException();
    }

    public void checkedExceptionWithTryCatch1() throws IOException {

        checkedExceptionWithoutTryCatch1(-1);
    }

    public void checkedExceptionWithTryCatch2() {
        try {
            checkedExceptionWithTryCatch1();
        } catch (IOException e) {

        }
        System.out.println("sdfsdfs");
    }

    public static void main(String[] args) throws IOException {
        CheckedOrUnCkExceptionExample c = new CheckedOrUnCkExceptionExample();
        c.checkedExceptionWithTryCatch2();
        System.out.println("opoopo");
    }
}
