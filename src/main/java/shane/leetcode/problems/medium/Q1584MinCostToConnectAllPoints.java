package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1584MinCostToConnectAllPoints {

    @Test
    public void test() {
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]"))).isEqualTo(20);
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[3,12],[-2,5],[-4,1]]"))).isEqualTo(18);
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[-14,-14],[-18,5],[18,-10],[18,18],[10,-2]]"))).isEqualTo(102);
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[11,-6],[9,-19],[16,-13],[4,-9],[20,4],[20,7],[-9,18],[10,-15],[-15,3],[6,6]]"))).isEqualTo(113);
    }

    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] included = new boolean[points.length];

        pq.add(new Pair(0, 0));
        int total = 0;
        int connects = 0;

        while (connects < points.length) {
            Pair poll = pq.poll();
            int cur = poll.value;

            if (included[cur]) {
                continue;
            }
            included[cur] = true;

            total += poll.key;
            connects++;

            for (int next = 0; next < points.length; next++) {
                if (!included[next]) {
                    int nextWeight = Math.abs(points[cur][0] - points[next][0]) + Math.abs(points[cur][1] - points[next][1]);
                    pq.add(new Pair(nextWeight, next));
                }
            }
        }

        return total;
    }

    class Pair implements Comparable {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(key, ((Pair) o).key);
        }
    }

}
