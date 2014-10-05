package javabasic;

public class NestedClassTip {
    /**
     * tip for diff between inner class and inner static class
     */
    private String name = "instance name";
    private static String staticName = "static name";

    public static void main(String args[]) {
        NestedClassTip nt = new NestedClassTip();

        NestedClassTip.NestedOne nco = nt.new NestedOne();

        NestedClassTip.NestedTwo nct = new NestedClassTip.NestedTwo();
        
    }

    class NestedOne {
        NestedOne() {
            System.out.println(name);
            System.out.println(staticName);
        }
    }

    static class NestedTwo {
        NestedTwo() {
            System.out.println(staticName);
        }
    }
}
