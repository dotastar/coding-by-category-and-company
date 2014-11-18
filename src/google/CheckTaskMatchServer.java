/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   CheckTaskMatchServer.java
 *         Created:   Nov 17, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   Each server has got a capacity/memory limit. 
 *                    Each task requires certain capacity/memory to run, and each server can handle multiple tasks as long as the capacity limit is not hit. 
 *                    Write a program to see if all of the given tasks can be scheduled or not on the servers? 
 *                    Servers capacity limits: 8, 16, 8, 32 
 *                    Tasks capacity needs: 18, 4, 8, 4, 6, 6, 8, 8 
 *                    For this example, the program should say 'true'. 
 *                    Server capacity limits: 1, 3 
 *                    Task capacity needs: 4 
For this example, program should return false. 
 * All rights reserved.
 ******************************************************************************/
package google;

public class CheckTaskMatchServer {
    public boolean canArrange(int[] servers, int[] tasks) {
        boolean[] used = new boolean[tasks.length];
        return canArrangeRecursive(servers, tasks, used);
    }

    public boolean canArrangeRecursive(int[] servers, int[] tasks, boolean[] used) {
        boolean allUsed = true;
        for (int i = 0; i < used.length; i++) {
            allUsed = allUsed & used[i];
        }
        if (allUsed) {
            return true;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                for (int j = 0; j < servers.length; j++) {
                    if (servers[j] >= tasks[i]) {
                        servers[j] = servers[j] - tasks[i];
                        if (canArrangeRecursive(servers, tasks, used)) {
                            return true;
                        }
                        servers[j] = servers[j] + tasks[i];
                    }
                }
                used[i] = false;
            }
        }
        return false;
    }
}
