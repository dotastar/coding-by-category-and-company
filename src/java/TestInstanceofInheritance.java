package java;

import java.util.ArrayList;

public class TestInstanceofInheritance {
    public static class people {
        private int a;
        public people() {
            a = 3;
        }
    }

    public static class teacher extends people {
        private int b;
        public teacher() {
            super();
            b = 3;
        }
    }

    public static void main(String[] args) {
        people b = new teacher();
        System.out.println(b instanceof people);
        teacher c = new teacher();
        System.out.println(c instanceof people);
        people a = new people();
        System.out.println(a instanceof teacher);
        ArrayList<Integer> d = new ArrayList<Integer>(100);
        System.out.println(d.size());
    }
}
