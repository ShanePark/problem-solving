package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 473ms
 * Beats27.46%
 */
public class Q1792MaximumAveragePassRatio3 {

    @Test
    public void test() {
        assertThat(maxAverageRatio(Ps.intArray("[[2,4],[3,9],[4,5],[2,10]]"), 4)).isEqualTo(0.53485, Offset.offset(0.00001));
        assertThat(maxAverageRatio(Ps.intArray("[[1,2],[3,5],[2,2]]"), 2)).isEqualTo(0.78333, Offset.offset(0.00001));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            double o1Gap = (o1[0] + 1.0) / (o1[1] + 1) - (double) o1[0] / o1[1];
            double o2Gap = (o2[0] + 1.0) / (o2[1] + 1) - (double) o2[0] / o2[1];
            return Double.compare(o2Gap, o1Gap);
        });
        for (int[] aClass : classes) {
            pq.offer(aClass);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = pq.poll();
            pq.offer(new int[]{poll[0] + 1, poll[1] + 1});
        }
        double sum = 0;
        for (int[] ints : pq) {
            sum += (double) ints[0] / ints[1];
        }
        return sum / pq.size();
    }

}
