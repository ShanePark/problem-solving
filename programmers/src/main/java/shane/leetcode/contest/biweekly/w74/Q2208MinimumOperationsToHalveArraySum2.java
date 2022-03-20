package shane.leetcode.contest.biweekly.w74;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2208MinimumOperationsToHalveArraySum2 {

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

        double target = -pq.stream().mapToDouble(Double::valueOf).sum() / 2;
        double reduce = 0;
        int cnt = 0;
        while (reduce < target) {
            Double poll = pq.poll();
            reduce -= poll / 2;
            pq.offer(poll / 2);
            cnt++;
        }
        return cnt;
    }

}
