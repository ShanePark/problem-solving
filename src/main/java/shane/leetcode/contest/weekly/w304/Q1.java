package shane.leetcode.contest.weekly.w304;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(minimumOperations(new int[]{10})).isEqualTo(1);
        assertThat(minimumOperations(new int[]{1, 5, 0, 3, 5})).isEqualTo(3);
        assertThat(minimumOperations(new int[]{0})).isEqualTo(0);
    }


    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num > 0)
                pq.offer(num);
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            Integer min = pq.poll();
            PriorityQueue<Integer> temp = new PriorityQueue<>();
            while (!pq.isEmpty()) {
                Integer p = pq.poll();
                if (p > min) {
                    temp.offer(p - min);
                }
            }
            pq = temp;
            cnt++;
        }

        return cnt;
    }


}
