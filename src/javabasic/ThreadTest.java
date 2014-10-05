/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   ThreadTest.java
 *         Created:   Oct 2, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   beside the Thread(ThreadTest), we also have a user-thread which run main() 
 *                    
 * All rights reserved.
 ******************************************************************************/
package javabasic;

public class ThreadTest implements Runnable{
    public String myString = "Yes ";

    public void run() {
        this.myString = "No ";
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        new Thread(t).start();
        for (int i = 0; i < 10; i++)
            System.out.print(t.myString);
    }
}
