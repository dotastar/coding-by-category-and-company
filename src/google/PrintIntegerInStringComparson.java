/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   PrintIntegerInStringComparson.java
 *         Created:   Nov 17, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Output top N positive integer in string comparison order. For example, let's say N=1000, then you need to output in string comparison order as below: 
 *                    1, 10, 100, 1000, 101, 102, ... 109, 11, 110, ...
 *                    
 * All rights reserved.
 ******************************************************************************/
package google;

public class PrintIntegerInStringComparson {
    public void print(int N){
        for(int i = 1; i < 10; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            printRec(sb, N);
        }
    }
    
    public void printRec(StringBuilder str, int N){
        if(Integer.parseInt(str.toString()) > N){
            return;
        }
        System.out.println(str);
        for(int i = 0; i < 10; i++){
            str.append(i);
            printRec(str, N);
            str.deleteCharAt(str.length() - 1);
        }
    }
    
    public static void main(String[] args) {
        PrintIntegerInStringComparson test = new PrintIntegerInStringComparson();
        test.print(500);
    }
}
