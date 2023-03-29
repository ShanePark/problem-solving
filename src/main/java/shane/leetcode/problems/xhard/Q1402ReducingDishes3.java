package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 54.38%
 * Memory 40.8 MB Beats 60.5%
 */
public class Q1402ReducingDishes3 {

    @Test
    public void test() {
        assertThat(maxSatisfaction(new int[]{-1, -8, 0, 5, -9})).isEqualTo(14);
        assertThat(maxSatisfaction(new int[]{4, 3, 2})).isEqualTo(20);
        assertThat(maxSatisfaction(new int[]{-1, -4, -5})).isEqualTo(0);
    }

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int max = 0;
        for (int i = 0; i < satisfaction.length; i++) {
            int sum = 0;
            for (int j = i; j < satisfaction.length; j++) {
                sum += (j - i + 1) * satisfaction[j];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
