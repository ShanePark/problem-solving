package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats100.00%
 */
public class Q3254FindthePowerofKSizeSubarraysI2 {

    @Test
    public void test() {
        assertThat(resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)).containsExactly(3, 4, -1, -1, -1);
        assertThat(resultsArray(new int[]{1, 3, 4}, 2)).containsExactly(-1, 4);
        assertThat(resultsArray(new int[]{2, 2, 2, 2, 2}, 4)).containsExactly(-1, -1);
        assertThat(resultsArray(new int[]{3, 2, 3, 2, 3, 2}, 2)).containsExactly(-1, 3, -1, 3, -1);
    }

    public int[] resultsArray(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            answer[i - k + 1] = nums[i];
        }
        int wrongCnt = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] != nums[i - 1] + 1)
                wrongCnt++;
        }
        if (wrongCnt > 0)
            answer[0] = -1;
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] + 1 != nums[i - k + 1])
                wrongCnt--;
            if (nums[i] != nums[i - 1] + 1)
                wrongCnt++;
            if (wrongCnt > 0)
                answer[i - k + 1] = -1;
        }
        return answer;
    }

}
