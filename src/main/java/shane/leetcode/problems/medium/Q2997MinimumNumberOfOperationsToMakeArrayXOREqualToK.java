package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100.00% of users with Java
 */
public class Q2997MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{2, 1, 3, 4}, 1)).isEqualTo(2);
        assertThat(minOperations(new int[]{2, 0, 2, 0}, 0)).isEqualTo(0);
        assertThat(minOperations(new int[]{4}, 7)).isEqualTo(2);
        assertThat(minOperations(new int[]{1, 2, 3, 4}, 2)).isEqualTo(2);
    }

    public int minOperations(int[] nums, int k) {
        for (int num : nums) {
            k ^= num;
        }
        return Integer.bitCount(k);
    }

}
