package util;

public class RacerInfo implements Comparable<RacerInfo> {
    public int id;
    public long time;
    public boolean isStart;

    public RacerInfo(int et1, long et2, boolean et3) {
        this.id = et1;
        this.time = et2;
        this.isStart = et3;
    }

    @Override
    public int compareTo(RacerInfo o) {
        if (this.time < o.time) {
            return -1;
        } else if (this.time == o.time) {
            return 0;
        } else {
            return 1;
        }
    }

}
