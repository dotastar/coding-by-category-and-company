package javabasic;

import java.util.ArrayList;
import java.util.List;

public class GenericTests<T> {

    public static void main(String[] args) {
        Class<String> c = String.class;
        String a = new String();
        Number n = 0;
        //     
        ArrayList[] lst = new ArrayList<?>[10];
        lst.getClass();
        List[] lsa = new List[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        // Unsound, but passes run time store check
        oa[1] = li;
        //
        // Run-time error: ClassCastException.
        String s = (String) lsa[1].get(0);

    }
}
