package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Got Heap idea from the community
 *
 * Runtime: 466 ms, faster than 14.28% of Java online submissions for The Skyline Problem.
 * Memory Usage: 51.9 MB, less than 62.94% of Java online submissions for The Skyline Problem.
 */
public class Q218TheSkylineProblem2 {

    @Test
    public void test() {
        assertThat(getSkyline(Ps.intArray("[[1,2,1],[1,2,2],[1,2,3]]"))).isEqualTo(Ps.intList("[[1,3],[2,0]]"));
        assertThat(getSkyline(Ps.intArray("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]")))
                .isEqualTo(Ps.intList("[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]"));
        assertThat(getSkyline(Ps.intArray("[[0,2,3],[2,5,3]]")))
                .isEqualTo(Ps.intList("[[0,3],[5,0]]"));
    }

    @Test
    public void tle() {
        assertThat(getSkyline(Ps.intArray("[[0,2147483647,2147483647]]"))).isEqualTo(Ps.intList("[[0, 2147483647], [2147483647, 0]]"));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Change> changes = new ArrayList<>();
        for (int[] b : buildings) {
            int left = b[0];
            int right = b[1];
            int height = b[2];
            changes.add(new Change(left, Status.START, height));
            changes.add(new Change(right, Status.END, height));
        }

        Collections.sort(changes);

        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int beforeHeight = -1;
        for (Change h : changes) {
            if (h.status == Status.START) {
                pq.offer(h.height);
            } else {
                pq.remove(h.height);
            }
            int currentHeight = pq.peek();
            if (beforeHeight != currentHeight) {
                answer.add(List.of(h.place, currentHeight));
                beforeHeight = currentHeight;
            }
        }
        return answer;
    }

    private class Change implements Comparable {
        int place;
        Status status;
        int height;

        public Change(int place, Status status, int height) {
            this.place = place;
            this.status = status;
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            Change b = (Change) o;
            if (place != b.place)
                return place - b.place;
            if (status != b.status) {
                return status == Status.START ? -1 : 1;
            }
            if (status == Status.START) {
                return b.height - height;
            } else {
                return height - b.height;
            }
        }
    }

    enum Status {
        START, END
    }
}
