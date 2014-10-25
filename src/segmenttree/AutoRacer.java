/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   AutoRacer.java
 *         Created:   Oct 22, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   use segment tree to solve autoracer in nlog time
 *                    my evernote(title: autoracer_segmenttree)
 *                    
 * All rights reserved.
 ******************************************************************************/
package segmenttree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import util.RacerInfo;
import util.RacerScore;

public class AutoRacer {
    HashMap<Integer, Integer> startIdx = new HashMap<Integer, Integer>();
    int[] tree;

    public AutoRacer(int n) {
        tree = new int[(int) Math.pow(2, 1 + 1 + (int) (Math.log(n) / Math.log(2))) - 1];
    }

    public int query(int root, int ns, int ne, int qs, int qe) {
        if (qs > ne || qe < ns) {
            return 0;
        }
        if (qs <= ns && qe >= ne) {
            return tree[root];
        }
        int mid = (ns + ne) / 2;
        return query(root * 2 + 1, ns, mid, qs, qe) + query(root * 2 + 2, mid + 1, ne, qs, qe);
    }

    public void updateOne(int root, int ns, int ne, int idx, int addVal) {
        if (ns == ne) {
            if (idx == ns) {
                tree[root] += addVal;
            }
            return;
        }
        int mid = (ns + ne) / 2;
        if (idx <= mid) {
            updateOne(root * 2 + 1, ns, mid, idx, addVal);
        } else {
            updateOne(root * 2 + 2, mid + 1, ne, idx, addVal);
        }
        tree[root] = tree[root * 2 + 1] + tree[root * 2 + 2];
    }

    public void process(RacerInfo[] data) {
        Arrays.sort(data);
        ArrayList<RacerScore> ans = new ArrayList<RacerScore>();
        for (int i = 0; i < data.length; i++) {
            if (data[i].isStart) {
                startIdx.put(data[i].id, i);
            }
        }
        for (int i = 0; i < data.length; i++) {
            if (!data[i].isStart) {
                updateOne(0, 0, data.length - 1, startIdx.get(data[i].id), 1);
                int score = query(0, 0, data.length - 1, startIdx.get(data[i].id) + 1, data.length - 1);
                ans.add(new RacerScore(data[i].id, score));
            }
        }
        Collections.sort(ans);
        for (int j = 0; j < ans.size(); j++) {
            System.out.println(ans.get(j).id + " " + ans.get(j).score);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("RacerRacer_TestCase/input002.txt"));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        RacerInfo[] data = new RacerInfo[2 * n];
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] entry = line.split(" ");
            int et1 = Integer.parseInt(entry[0]);
            long et2 = Long.parseLong(entry[1]), et3 = Long.parseLong(entry[2]);
            data[i++] = new RacerInfo(et1, et2, true);
            data[i++] = new RacerInfo(et1, et3, false);
        }
        br.close();
        AutoRacer racer = new AutoRacer(2 * n);
        racer.process(data);
    }
}
