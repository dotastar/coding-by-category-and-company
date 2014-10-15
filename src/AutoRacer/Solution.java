package AutoRacer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    /**
     * Auto Racer Find the number for each element: start later and finish early. 
     * @author NanZhang
     *
     */
    public static class Racer implements Comparable<Racer>{
        public int racerId;
        public long startTime;
        public long endTime;

        public Racer(int et1, long et2, long et3) {
            this.racerId = et1;
            this.startTime = et2;
            this.endTime = et3;
        }

        @Override
        public int compareTo(Racer o) {
            if(this.startTime < o.startTime){
                return -1;
            }else if(this.startTime == o.startTime){
                return 0;
            }else{
                return 1;
            }
        }
    }

    public static class RacerScore implements Comparable<RacerScore> {
        public int racerId;
        public int score;

        public RacerScore(int et1, int et2) {
            this.racerId = et1;
            this.score = et2;
        }

        @Override
        public int compareTo(RacerScore o) {
            if (this.score < o.score) {
                return -1;
            } else if (this.score == o.score && this.racerId < o.racerId) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("RacerRater_testcases/input004.txt"));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        Racer[] racerData = new Racer[n];
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] entry = line.split(" ");
            int et1 = Integer.parseInt(entry[0]);
            long et2 = Long.parseLong(entry[1]), et3 = Long.parseLong(entry[2]);
            racerData[i++] = new Racer(et1, et2, et3);
        }
        br.close();
        Arrays.sort(racerData);
        ArrayList<RacerScore> finalScore = new ArrayList<RacerScore>();
        for(int j = 0; j < n; j++){
            int k = j + 1;
            int count = 0;
            while(k < n && racerData[k].startTime < racerData[j].endTime){
                if(racerData[k].endTime < racerData[j].endTime){
                    count++;
                }
                k++;
            }
            finalScore.add(new RacerScore(racerData[j].racerId, count));
        }
        Collections.sort(finalScore);
        for(int j = 0; j < n; j++){
            System.out.println(finalScore.get(j).racerId + " " + finalScore.get(j).score);
        }
    }
}
