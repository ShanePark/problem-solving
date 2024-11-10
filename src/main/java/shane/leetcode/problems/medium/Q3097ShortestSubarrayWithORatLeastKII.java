package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3097ShortestSubarrayWithORatLeastKII {

    public int minimumSubarrayLength(int[] nums, int k) {
        int answer = nums.length + 1;
        int[] bitCounts = new int[32];

        for (int start = 0, end = 0; end < nums.length; end++) {
            updateBitCounts(bitCounts, nums[end], 1);
            while (start <= end && k <= bitCountToNum(bitCounts)) {
                answer = Math.min(answer, end - start + 1);
                updateBitCounts(bitCounts, nums[start++], -1);
            }
        }

        if (answer == nums.length + 1)
            return -1;
        return answer;
    }

    private void updateBitCounts(int[] bitCounts, int number, int cnt) {
        for (int bitPosition = 0; bitPosition < 32; bitPosition++) {
            if (((number >> bitPosition) & 1) == 0) {
                continue;
            }
            bitCounts[bitPosition] += cnt;
        }
    }

    private int bitCountToNum(int[] bitCounts) {
        int answer = 0;
        for (int i = 0; i < bitCounts.length; i++) {
            if (bitCounts[i] == 0) {
                continue;
            }
            answer |= 1 << i;
        }
        return answer;
    }

    @Test
    public void test() {
        assertThat(minimumSubarrayLength(new int[]{2, 1, 9, 12}, 21)).isEqualTo(-1);
        assertThat(minimumSubarrayLength(new int[]{2, 1, 8}, 10)).isEqualTo(3);
        assertThat(minimumSubarrayLength(new int[]{1, 2, 3}, 2)).isEqualTo(1);
        assertThat(minimumSubarrayLength(new int[]{1, 2}, 0)).isEqualTo(1);
        assertThat(minimumSubarrayLength(new int[]{1, 2, 3}, 128)).isEqualTo(-1);
    }

}
