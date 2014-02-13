package yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GroupAnagram {
    public void group(ArrayList<String> input){
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String iter : input){
            char[] temp = iter.replaceAll("[^A-Za-z0-9]", "").toLowerCase().toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if(map.containsKey(key)){
                ArrayList<String> val = map.get(key);
                val.add(iter);
                map.put(key, val);
            }else{
                ArrayList<String> val = new ArrayList<String>();
                val.add(iter);
                map.put(key, val);
            }
        }
        for(Map.Entry<String, ArrayList<String>> iter : map.entrySet()){
            for(String elem : iter.getValue()){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GroupAnagram test = new GroupAnagram();
        ArrayList<String> input = new ArrayList<String>();
        input.add("car");
        input.add("arc");
        input.add("rca");
        input.add("good");
        input.add("doog");
        test.group(input);
    }
}
