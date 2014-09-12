package freepractise;

public class ReverseWordsInAString {
    public static String reverse(char[] input){
        int i = 0, j = input.length - 1;
        while(i < j){
            swap(input, i, j);
            i++;
            j--;
        }
        i = 0;
        while(i < input.length){
            j = i;
            while(j < input.length && input[j] != ' '){
                j++;
            }
            int k = i, l = j - 1;
            while(k < l){
                swap(input, k, l);
                k++;
                l--;
            }
            i = j + 1;
        }
        return new String(input);
    }
    
    public static void swap(char[] input, int i, int j){
        char temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
    public static void main(String[] args) {
        System.out.println(ReverseWordsInAString.reverse("   I love you baby    ".toCharArray()));
    }
}
