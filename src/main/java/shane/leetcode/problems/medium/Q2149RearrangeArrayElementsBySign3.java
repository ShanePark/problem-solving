package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 16 ms Beats 5.39% of users with Java
 */
public class Q2149RearrangeArrayElementsBySign3 {

    @Test
    void test() {
        Assertions.assertThat(rearrangeArray(new int[]{28, -41, 22, -8, -37, 46, 35, -9, 18, -6, 19, -26, -37, -10, -9, 15, 14, 31}))
                .containsExactly(28, -41, 22, -8, 46, -37, 35, -9, 18, -6, 19, -26, 15, -37, 14, -10, 31, -9);
        Assertions.assertThat(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})).containsExactly(3, -2, 1, -5, 2, -4);
        Assertions.assertThat(rearrangeArray(new int[]{-1, 1})).containsExactly(1, -1);
    }

    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();
        for (int num : nums) {
            if (num > 0) {
                positive.offer(num);
                continue;
            }
            negative.offer(num);
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = positive.poll();
            nums[i + 1] = negative.poll();
        }
        return nums;
    }

}
