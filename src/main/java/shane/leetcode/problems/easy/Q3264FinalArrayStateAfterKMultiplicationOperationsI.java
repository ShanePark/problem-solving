package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime3msBeats33.80%
 */
public class Q3264FinalArrayStateAfterKMultiplicationOperationsI {

    @Test
    public void test() {
        assertThat(getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2)).isEqualTo(new int[]{8, 4, 6, 5, 6});
        assertThat(getFinalState(new int[]{1, 2}, 3, 4)).isEqualTo(new int[]{16, 8});
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
        }
        for (int i = 0; i < k; i++) {
            int[] poll = pq.poll();
            poll[1] *= multiplier;
            nums[poll[0]] = poll[1];
            pq.offer(poll);
        }
        return nums;
    }

}
