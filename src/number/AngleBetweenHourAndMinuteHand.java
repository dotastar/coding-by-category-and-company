/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   AngleBetweenHourAndMinuteHand.java
 *         Created:   Nov 5, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   1) Calculate the angle made by hour hand with respect to 12:00 in h hours and m minutes.
 *                    2) Calculate the angle made by minute hand with respect to 12:00 in h hours and m minutes.
 *                    3) The difference between two angles is the angle between two hands.
 *                    The minute hand moves 360 degree in 60 minute(or 6 degree in one minute) and hour hand moves 360 degree in 12 hours(or 0.5 degree in 1 minute).
 *                    In h hours and m minutes, the minute hand would move (h*60 + m)*6 and hour hand would move (h*60 + m)*0.5.
 * All rights reserved.
 ******************************************************************************/
package number;

public class AngleBetweenHourAndMinuteHand {
    public int calcAngle(double h, double m){
        if(h == 12){
            h = 0;
        }
        if(m == 60){
            m = 0;
        }
        int hourAngle = (int)(0.5 * (h*60 + m));
        int minAngle = (int)(6*(h*60 + m));
        int angle = Math.abs(hourAngle - minAngle);
        
        // Return the smaller angle of two possible angles
        angle = Math.min(360-angle, angle);
        return angle;
    }
}
