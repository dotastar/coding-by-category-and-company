/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Deadlock.java
 *         Created:   Sep 29, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to simulate a deadlock using thread
 *                    
 * All rights reserved.
 ******************************************************************************/
package javabasic;

public class Deadlock {
    public static void main(String[] args) {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";
        Thread t1 = new Thread() {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
