package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime392msBeats51.90%
 */
public class Q1792MaximumAveragePassRatio2 {

    @Test
    public void test() {
        assertThat(maxAverageRatio(Ps.intArray("[[1,2],[3,5],[2,2]]"), 2)).isEqualTo(0.78333, Offset.offset(0.00001));
        assertThat(maxAverageRatio(Ps.intArray("[[2,4],[3,9],[4,5],[2,10]]"), 4)).isEqualTo(0.53485, Offset.offset(0.00001));
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o[2]));
        double sum = 0;
        for (int[] aClass : classes) {
            if (aClass[0] == aClass[1]) {
                sum++;
                continue;
            }
            double[] arr = new double[]{aClass[0], aClass[1], 0};
            arr[2] = arr[0] / arr[1] - (arr[0] + 1) / (arr[1] + 1);
            pq.offer(arr);
        }
        for (int i = 0; i < extraStudents; i++) {
            if (pq.isEmpty())
                break;
            double[] poll = pq.poll();
            poll[0]++;
            poll[1]++;
            poll[2] = poll[0] / poll[1] - (poll[0] + 1) / (poll[1] + 1);
            pq.offer(poll);
        }
        while (!pq.isEmpty()) {
            double[] poll = pq.poll();
            sum += poll[0] / poll[1];
        }
        return sum / classes.length;
    }

}
