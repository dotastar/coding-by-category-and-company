/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   FindDayOfWeekGivenDate.java
 *         Created:   Nov 4, 2014 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   see evernote: algorithm analysis
 *                    
 * All rights reserved.
 ******************************************************************************/
package number;

public class FindDayOfWeekGivenDate {
    public int dayofWeek(int day, int month, int year) {//day, month, and year all start from 1
        int[] monthOffset = new int[] { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
        int offset = year + (year / 4 - year / 100 + year / 400) + (day - 1) + monthOffset[month - 1];//NOTE think about the definition of leap year
        if (month < 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && year != 0) {//y can be allowed to be 0
            offset--;
        }
        int weekday = offset % 7;//monday to sunday: 0~6
        return weekday;
    }
}
