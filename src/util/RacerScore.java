package util;

public class RacerScore implements Comparable<RacerScore> {
    public int id;
    public int score;

    public RacerScore(int et1, int et2) {
        this.id = et1;
        this.score = et2;
    }

    @Override
    public int compareTo(RacerScore o) {
        if (this.score == o.score) {
            return this.id - o.id;
        }
        return this.score - o.score;
    }

    @Override
    public String toString() {
        return this.id + " " + this.score;
    }
}
