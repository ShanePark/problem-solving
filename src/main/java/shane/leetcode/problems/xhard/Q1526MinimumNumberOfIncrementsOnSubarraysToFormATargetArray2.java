package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1526MinimumNumberOfIncrementsOnSubarraysToFormATargetArray2 {

    @Test
    public void test() {
        assertThat(minNumberOperations(new int[]{1, 2, 3, 2, 1})).isEqualTo(3);
        assertThat(minNumberOperations(new int[]{3, 1, 1, 2})).isEqualTo(4);
        assertThat(minNumberOperations(new int[]{3, 1, 5, 4, 2})).isEqualTo(7);
    }

    public int minNumberOperations(int[] target) {
        int ans = target[0];
        for (int i = 1; i < target.length; i++) {
            ans += Math.max(target[i] - target[i - 1], 0);
        }
        return ans;
    }

}
