package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats98.65%
 */
public class Q2176CountEqualAndDivisiblePairsInAnArray {

    @Test
    public void test() {
        assertThat(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2)).isEqualTo(4);
        assertThat(countPairs(new int[]{1, 2, 3, 4}, 1)).isEqualTo(0);
    }

    public int countPairs(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] != nums[j])
                    continue;
                if (i * j % k == 0)
                    answer++;
            }
        }
        return answer;
    }

}
