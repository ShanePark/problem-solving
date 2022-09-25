package shane.leetcode.contest.weekly.w312;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(longestSubarray(new int[]{311155, 311155, 311155, 311155, 311155, 311155, 311155, 311155, 201191, 311155})).isEqualTo(8);
        assertThat(longestSubarray(new int[]{1, 2, 3, 3, 2, 2})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{1, 2, 3, 4})).isEqualTo(1);
    }

    public int longestSubarray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int cnt = 0;
        int maxCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                maxCnt = Math.max(maxCnt, ++cnt);
            } else {
                cnt = 0;
            }
        }
        return maxCnt;
    }

}
