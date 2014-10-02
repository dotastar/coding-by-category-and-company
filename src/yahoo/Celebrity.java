/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   Celebrity.java
 *         Created:   5/30
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   find a celebrity who doesn't know anyone else, but is known by all anyone else
 *                    This celebrity may exist, or may not.
 *                    We also have a hypothetical function knows(A, B) which returns true if A knows B, false otherwise.
 *            
 * All rights reserved.
 ******************************************************************************/

package yahoo;

public class Celebrity {
    
    /**
     * time complexity is 3 * (n - 1)
     */
    public int search(int[] persons) {
        if (persons.length < 1) {
            return -1;
        }
        int candidate = persons[0];
        for (int i = 1; i < persons.length; i++) {
            if (knows(candidate, persons[i + 1])) {
                candidate = i + 1;
            }
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

    private boolean knows(int pA, int pB) {
        return true;
    }
}
