package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Assertions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Runtime: 245 ms, faster than 5.11% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
 * Memory Usage: 141.4 MB, less than 5.06% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
 */
public class Q452MinimumNumberofArrowstoBurstBalloons {

    public static void main(String[] args) {
        Assertions.assertEquals(2, findMinArrowShots(STool.convertToIntArray("[[10,16],[2,8],[1,6],[7,12]]")));
        Assertions.assertEquals(4, findMinArrowShots(STool.convertToIntArray("[[1,2],[3,4],[5,6],[7,8]]")));
        Assertions.assertEquals(2, findMinArrowShots(STool.convertToIntArray("[[1,2],[2,3],[3,4],[4,5]]")));
    }

    public static int findMinArrowShots(int[][] points) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));
        for (int[] point : points) {
            pq.add(new Point(point));
        }

        Point poll = pq.poll();
        int start = poll.start;
        int end = poll.end;

        int sum = 0;

        while (!pq.isEmpty()) {
            poll = pq.poll();
            if (poll.overlap(start, end)) {
                start = Math.max(start, poll.start);
                end = Math.min(end, poll.end);
            } else {
                sum++;
                start = poll.start;
                end = poll.end;
            }

        }

        return sum + 1;
    }

    static class Point {
        int start;
        int end;

        Point(int[] arr) {
            this.start = arr[0];
            this.end = arr[1];
        }

        @Override
        public String toString() {
            return "Point{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public boolean overlap(int start, int end) {
            return (start <= this.start && this.start <= end) || (start <= this.end && this.end <= end);
        }
    }

}
