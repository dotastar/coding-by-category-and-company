/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   EntryIterator.java
 *         Created:   Sep 24, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   implement a simple map entry iterator
 *                    
 * All rights reserved.
 ******************************************************************************/
package datastructure;

import java.util.NoSuchElementException;


public class EntryIterator<K, V> {

    Node<K, V> next; // next entry to return
    Node<K, V> current; // current entry
    int index; // current slot
    Node<K, V>[] t;

    EntryIterator(Node<K, V>[] table, int size) {
        Node<K, V>[] t = table;
        current = next = null;
        index = 0;
        if (t != null && size > 0) {
            do {
            } while (index < t.length && (next = t[index++]) == null);
        }
    }

    public final boolean hasNext() {
        return next != null;
    }

    final Node<K, V> nextNode() {
        Node<K, V> current = next;
        if (current == null) {
            throw new NoSuchElementException();
        }
        do {
        } while (index < t.length && (next = t[index++]) == null);
        return current;
    }

    public final void remove() {
        Node<K, V> p = current;
        if (p == null) {
            throw new IllegalStateException();
        }
        current = null;
    }
}
