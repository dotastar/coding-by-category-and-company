/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   RateLimit.java
 *         Created:   Nov 16, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   interface RateLimit { 
 *                    // Sets the rate, from 1 to 1000000 queries per second  
 *                    void setQPS(int qps); 
 *                    // accept or reject a request, called when request is received 
 *                    boolean allowThisRequest(); } 
 *                    server instantiates your object, calls setQPS(1) 
 *                    at at time t, user1 makes a request, allowThisRequest() returns true 
 *                    at time t+0.01 sec, user2 makes a request, allowThisRequest() returns false
 *                    at at time t+1, user4 makes a request, allowThisRequest() returns true 
 *                    at time t+5 sec, user3 makes a request, allowThisRequest() returns true
 * All rights reserved.
 ******************************************************************************/
package google;

public class RateLimit {
    int qps;
    long qps_millis;
    long time = -1;
    
    public void setQPS(int qps){
        if(qps < 1 || qps > 1000000){
            throw new RuntimeException();
        }
        this.qps = qps;
        this.qps_millis = this.qps * 1000;
    }
    
    public boolean allowThisRequest(){
        long currentTime = System.currentTimeMillis();
        if(this.time == -1){
            time = currentTime;
            return true;
        }else{
            long timeDiff = currentTime - time;
            if(timeDiff < this.qps_millis){
                return false;
            }else{
                this.time = currentTime;
                return true;
            }
        }
    }
}
