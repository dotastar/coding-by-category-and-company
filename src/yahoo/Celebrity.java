/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Celebrity.java
 *         Version:   1.0
 *         Created:   5/30
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find a celebrity who doesn't know anyone else, but is known by all anyone else
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class Celebrity {
    public int search(int[] persons) {
        if (persons.length < 1) {
            return -1;
        }
        int candidate = -1;
        for (int i = 0; i < persons.length - 1; i++) {
            if (knows(persons[i], persons[i + 1])) {
                candidate = i + 1;
            } else {
                candidate = i;
            }
        }
        if (candidate == -1) {
            return -1;
        }
        for (int i = 0; i < persons.length; i++) {
            if (i != candidate && !knows(persons[i], persons[candidate])) {
                return -1;
            }
        }
        for (int i = 0; i < persons.length; i++) {
            if (i != candidate && knows(persons[candidate], persons[i])) {
                return -1;
            }
        }
        return persons[candidate];
    }

    /**
     * this interface is provided by outside
     * @param pA
     * @param pB
     * @return
     */
    private boolean knows(int pA, int pB) {
        return true;
    }
}
