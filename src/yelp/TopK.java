package yelp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class TopK {
    class Entry implements Comparable<Entry> {
        public String url = "";
        public int num = -1;

        public Entry(String et1, int et2) {
            this.url = et1;
            this.num = et2;
        }

        @Override
        public int compareTo(Entry o) {
            return this.num - o.num;
        }
    }
    
    public HashMap<String, Integer> getFreqs(ArrayList<String> input) {
        HashMap<String, Integer> urlFreqs = new HashMap<String, Integer>();
        for (int i = 0; i < input.size(); i++) {
            if (urlFreqs.containsKey(input.get(i))) {
                urlFreqs.put(input.get(i), urlFreqs.get(input.get(i)) + 1);
            } else {
                urlFreqs.put(input.get(i), 1);
            }
        }
        return urlFreqs;
    }
    
    public void printTopK(HashMap<String, Integer> urlFreqs, int k){
        PriorityQueue<Entry> heap = new PriorityQueue<Entry>();
        for (Map.Entry<String, Integer> entry : urlFreqs.entrySet()) {
            heap.add(new Entry(entry.getKey(), entry.getValue()));
        }
        int hSize = heap.size();
        for(int i = 0; i < Math.min(k, hSize); i++){
            Entry iter = heap.poll();
            System.out.println(iter.url + " - " + iter.num);
        }
    }
    
    public static void main(String[] args) {
        TopK test = new TopK();
        ArrayList<String> input = new ArrayList<String>();
        input.add("checkcheck");
        input.add("checkcheck");
        input.add("checkcheck");
        input.add("haha");
        input.add("haha");
        input.add("haha");
        input.add("haha");
        input.add("good");
        input.add("good");
        test.printTopK(test.getFreqs(input), 3);
    }
}
