package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 99.26%
 * Memory 44.2 MB Beats 96.51%
 */
public class Q57InsertInterval {

    @Test
    public void test() {
        assertThat(insert(STool.convertToIntArray("[[2,5],[6,7],[8,9]]"), new int[]{0, 1}))
                .isEqualTo(STool.convertToIntArray("[[0,1],[2,5],[6,7],[8,9]]"));
        assertThat(insert(STool.convertToIntArray("[]"), new int[]{5, 7})).isEqualTo(STool.convertToIntArray("[[5,7]]"));
        assertThat(insert(STool.convertToIntArray("[[1,3],[6,9]]"), new int[]{2, 5}))
                .isEqualTo(STool.convertToIntArray("[[1,5],[6,9]]"));
        assertThat(insert(STool.convertToIntArray("[[1,2],[3,5],[6,7],[8,10],[12,16]]"), new int[]{4, 8}))
                .isEqualTo(STool.convertToIntArray("[[1,2],[3,10],[12,16]]"));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> answer = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null) {
                answer.add(new Interval(interval[0], interval[1]));
            } else if (interval[1] < newInterval[0]) {
                answer.add(new Interval(interval[0], interval[1]));
            } else if (isFold(interval, newInterval)) {
                newInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            } else if (newInterval != null) {
                answer.add(new Interval(newInterval[0], newInterval[1]));
                newInterval = null;
                answer.add(new Interval(interval[0], interval[1]));
            } else {
                answer.add(new Interval(interval[0], interval[1]));
            }
        }

        int[][] arr = new int[answer.size() + (newInterval == null ? 0 : 1)][2];
        for (int i = 0; i < answer.size(); i++) {
            Interval interval = answer.get(i);
            arr[i] = new int[]{interval.start, interval.end};
        }
        if (newInterval != null) {
            arr[answer.size()] = newInterval;
        }
        return arr;
    }

    private boolean isFold(int[] interval, int[] newInterval) {
        return interval[0] <= newInterval[1] && interval[1] >= newInterval[0];
    }

    class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
