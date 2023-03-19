package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 100%
 * Memory 59.2 MB Beats 100%
 */
public class Q2598SmallestMissingNonnegativeIntegerAfterOperations {

    @Test
    void test() {
        assertThat(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7)).isEqualTo(2);
        assertThat(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5)).isEqualTo(4);
        assertThat(findSmallestInteger(new int[]{0}, 1)).isEqualTo(1);
        assertThat(findSmallestInteger(new int[]{1}, 1)).isEqualTo(1);
        assertThat(findSmallestInteger(new int[]{1, 2, 3}, 1)).isEqualTo(3);
        assertThat(findSmallestInteger(new int[]{-2}, 7)).isEqualTo(0);
    }

    public int findSmallestInteger(int[] nums, int value) {
        int[] arr = new int[value];
        for (int num : nums) {
            int mod = Math.floorMod(num, value);
            arr[mod]++;
        }
        for (int answer = 0; ; answer++) {
            arr[answer % value]--;
            if (arr[answer % value] < 0)
                return answer;
        }
    }

}
