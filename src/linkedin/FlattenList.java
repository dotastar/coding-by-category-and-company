/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FlattenList.java
 *         Version:   1.0
 *         Created:   9/10 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   http://rosettacode.org/wiki/Flatten_a_list#Java
 *            
 * All rights reserved.
 ******************************************************************************/
package linkedin;

import java.util.ArrayList;
import java.util.List;

public class FlattenList {
    public static List<Object> flatten(List<?> list) {
        ArrayList<Object> retVal = new ArrayList<Object>();
        flatten(list, retVal);
        return retVal;
    }
 
    public static void flatten(List<?> fromTreeList, List<Object> toFlatList) {
        for (Object item : fromTreeList) {
            if (item instanceof List<?>) {
                flatten((List<?>) item, toFlatList);
            } else {
                toFlatList.add(item);
            }
        }
    }
}
