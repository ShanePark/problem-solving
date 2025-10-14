package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats47.79%
 */
public class Q3349AdjacentIncreasingSubarraysDetectionI {

    @Test
    public void test() {
        assertThat(hasIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3)).isTrue();
        assertThat(hasIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7), 5)).isFalse();
    }

    @Test
    public void test2() {
        assertThat(hasIncreasingSubarrays(List.of(1, 2, 3, 4, 5, 6), 3)).isTrue();
        assertThat(hasIncreasingSubarrays(List.of(-15, 19), 1)).isTrue();
    }


    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int last = nums.get(0);
        int increasingLength = 0;
        boolean flag = false;
        for (int n : nums) {
            if (last < n) {
                increasingLength++;
            } else {
                if (increasingLength >= k * 2 || (flag && k <= increasingLength)) {
                    return true;
                }
                flag = k <= increasingLength;
                increasingLength = 1;
            }
            last = n;
        }
        return increasingLength >= k * 2 || (flag && k <= increasingLength);
    }

}
