package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 17 ms, faster than 8.22% of Java online submissions for Increasing Triplet Subsequence.
 * Memory Usage: 92.2 MB, less than 71.98% of Java online submissions for Increasing Triplet Subsequence.
 */
public class Q334IncreasingTripletSubsequence {

    @Test
    public void test() {
        assertThat(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13})).isTrue();
        assertThat(increasingTriplet(new int[]{1, 2, 3, 4, 5})).isTrue();
        assertThat(increasingTriplet(new int[]{5, 4, 3, 2, 1})).isFalse();
        assertThat(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})).isTrue();
    }

    public boolean increasingTriplet(int[] nums) {
        Integer[] min = {null, null};
        for (int num : nums) {
            if (min[0] == null) {
                min[0] = num;
            } else if (min[0] < num) {
                if (min[1] != null) {
                    if (min[1] < num) {
                        return true;
                    } else {
                        min[1] = Math.min(min[1], num);
                    }
                } else {
                    min[1] = num;
                }
            } else {
                min[0] = num;
            }
        }
        return false;
    }

}
