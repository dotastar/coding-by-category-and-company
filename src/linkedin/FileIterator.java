/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FileIterator.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   32767815.html
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<String>{

    BufferedReader br;
    String nextLine;
    String curLine;
    FileIterator(File file) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(file));
    }
    
    @Override
    public boolean hasNext() {
        if(nextLine != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String next() {
        if(nextLine != null){
            curLine = nextLine;            
            try {
                nextLine = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return curLine;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }
    
}
