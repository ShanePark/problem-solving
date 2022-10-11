package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 5 ms, faster than 46.33% of Java online submissions for Increasing Triplet Subsequence.
 * Memory Usage: 84.4 MB, less than 85.06% of Java online submissions for Increasing Triplet Subsequence.
 */
@SuppressWarnings("ALL")
public class Q334IncreasingTripletSubsequence2 {

    @Test
    public void test() {
        assertThat(increasingTriplet(new int[]{2, 4, -2, -3})).isFalse();
        assertThat(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13})).isTrue();
        assertThat(increasingTriplet(new int[]{1, 2, 3, 4, 5})).isTrue();
        assertThat(increasingTriplet(new int[]{5, 4, 3, 2, 1})).isFalse();
        assertThat(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})).isTrue();
    }

    public boolean increasingTriplet(int[] nums) {
        Integer[] min = {nums[0], Integer.MAX_VALUE};
        for (int num : nums) {
            if (num <= min[0]) {
                min[0] = num;
            } else if (min[1] >= num) {
                min[1] = num;
            } else {
                return true;
            }
        }
        return false;
    }

}
