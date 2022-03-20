package shane.leetcode.contest.biweekly.w74;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2208MinimumOperationsToHalveArraySum {

    @Test
    void test() {
        assertThat(halveArray(new int[]{5, 19, 8, 1})).isEqualTo(3);
        assertThat(halveArray(new int[]{3, 8, 20})).isEqualTo(3);
    }

    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(-(double) num);
        }

        double sum = -pq.stream().mapToDouble(Double::valueOf).sum();
        int cnt = 0;
        while (true) {
            double currentSum = -pq.stream().mapToDouble(Double::valueOf).sum();
            if (currentSum <= sum / 2) {
                break;
            }
            Double poll = pq.poll();
            pq.offer(poll / 2);
            cnt++;
        }
        return cnt;
    }

}
