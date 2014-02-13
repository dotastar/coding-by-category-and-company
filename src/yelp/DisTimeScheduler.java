/*******************************************************************************
 * Copyright (c) 2014 Nan Zhang.
 * 
 *        Filename:   DisTimeScheduler.java
 *         Version:   1.0
 *         Created:   2/14 
 *          Author:   Nan Zhang 
 *    Organization:   https://github.com/Nan-Zhang
 *            Note:   How to get a un-conflict discussion time list for course set.
 *            
 * All rights reserved.
 ******************************************************************************/
package yelp;

import java.util.HashSet;

public class DisTimeScheduler {

    public class Course {
        public int courseId;
        public TimeSlot[] courseTime;
        public TimeSlot[] dicTime;
    }

    public class TimeSlot {
        public int date;
        public int time;

        public TimeSlot(int et1, int et2) {
            this.date = et1;
            this.time = et2;
        }

        @Override
        public int hashCode() {
            return 31 * date + time;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TimeSlot)) {
                return false;
            }
            TimeSlot temp = (TimeSlot) o;
            return this.date == temp.date && this.time == temp.time;
        }
    }

    public class DisChoice {
        public int courseId;
        public TimeSlot slot;
    }

    public DisChoice[] solution(Course[] courses) {
        HashSet<TimeSlot> set = new HashSet<TimeSlot>();
        for (int i = 0; i < courses.length; i++) {
            for (int j = 0; j < courses[i].courseTime.length; j++) {
                set.add(courses[i].courseTime[j]);
            }
        }
        DisChoice[] output = new DisChoice[courses.length];
        return search(courses, 0, set, output) ? output : null;
    }

    public boolean search(Course[] courses, int idx, HashSet<TimeSlot> set, DisChoice[] output) {
        if (idx == courses.length) {
            return true;
        }
        for (int i = 0; i < courses[idx].dicTime.length; i++) {
            if (!set.contains(courses[idx].dicTime[i])) {
                set.add(courses[idx].dicTime[i]);
                output[idx].courseId = courses[idx].courseId;
                output[idx].slot = new TimeSlot(courses[idx].dicTime[i].date, courses[idx].dicTime[i].time);
                if (search(courses, idx + 1, set, output)) {
                    return true;
                }
            }
        }
        return false;
    }
}
