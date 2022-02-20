package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Time Limit Exceeded
 */
public class Q421MaximumXorOfTwoNumbersInAnArray {

    @Test
    void test() {
        Assertions.assertThat(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8})).isEqualTo(28);
        Assertions.assertThat(findMaximumXOR(new int[]{14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70})).isEqualTo(127);
    }

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

}
