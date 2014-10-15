package strings;

public class DetectDescreteSubStr {
    /**
     * time complexity: O(n) just scan only 1 time; 
     * use greedy idea; cause substr can descrete and can not rotate (so greedy will get the global optimal!)
     * "java"  "jv" is true; "vj" is false
     */
    public static boolean detectDescreteSubStr(String src, String dest) {
        int i = 0, j = 0;
        while (i < src.length()) {
            if (src.charAt(i) == dest.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            if (j == dest.length()) {
                break;
            }
        }
        return j == dest.length() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(DetectDescreteSubStr.detectDescreteSubStr("javailoveyou", "uu"));
    }
}
