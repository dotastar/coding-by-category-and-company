/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FlattenIterator.java
 *         Created:   Nov 12, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Given a iterator of iterator of Strings, flatten this iterator.
 *                    
 * All rights reserved.
 ******************************************************************************/
package google;

import java.util.Iterator;

public class FlattenIterator implements Iterator<String> {
    private Iterator<String> curIterator = null;
    private Iterator<Iterator<String>> nested = null;

    public FlattenIterator(Iterator<Iterator<String>> nested) {
        this.nested = nested;
    }

    @Override
    public boolean hasNext() {
        if(curIterator!=null && curIterator.hasNext()){
            return true;
        }
        while(nested.hasNext()){
            curIterator = nested.next();
            if(curIterator.hasNext()){
                return true;
            }
        }
        return false;
    }

    @Override
    public String next() {
        if(!hasNext()){
            return null;
        }
        return curIterator.next();
    }

    @Override
    public void remove() {
        if(curIterator != null){
            curIterator.remove();
        }
    }
}
