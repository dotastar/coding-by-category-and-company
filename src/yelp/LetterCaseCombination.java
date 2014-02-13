package yelp;

import java.util.ArrayList;

public class LetterCaseCombination {
    public ArrayList<String> solution(String input) {
        ArrayList<String> ans = new ArrayList<String>();
        search(input, 0, new char[input.length()], ans);
        return ans;
    }

    public void search(String input, int idx, char[] cal, ArrayList<String> ans) {
        if(idx == input.length()){
            ans.add(new String(cal));
            return;
        }
        cal[idx] = Character.toLowerCase(input.charAt(idx));
        search(input, idx + 1, cal, ans);
        cal[idx] = Character.toUpperCase(input.charAt(idx));
        search(input, idx + 1, cal, ans);
    }
    public static void main(String[] args) {
        LetterCaseCombination test = new LetterCaseCombination();
        String input = new String("big");
        for(String iter : test.solution(input)){
            System.out.println(iter);
        }
    }
}
