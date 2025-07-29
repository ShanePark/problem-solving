package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 127ms
 * Beats9.46%
 */
public class Q2411SmallestSubarraysWithMaximumBitwiseOR {

    @Test
    public void test() {
        assertThat(smallestSubarrays(new int[]{1, 0, 2, 1, 3})).containsExactly(3, 3, 2, 2, 1);
        assertThat(smallestSubarrays(new int[]{1, 2})).containsExactly(2, 1);
        assertThat(smallestSubarrays(new int[]{0})).containsExactly(1);
    }

    public int[] smallestSubarrays(int[] nums) {
        int[][] acc = new int[nums.length][32];
        acc[0] = toBinary(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int[] binary = toBinary(nums[i]);
            for (int j = 0; j < 32; j++) {
                acc[i][j] = acc[i - 1][j] + binary[j];
            }
        }

        int[] answer = new int[nums.length];
        int curBitCnt = 0;
        int[] bitCnt = new int[32];
        int right = -1;
        for (int left = 0; left < nums.length; left++) {
            int targetBitCnt = 0;
            for (int i = 0; i < 32; i++) {
                if (acc[nums.length - 1][i] - (left == 0 ? 0 : acc[left - 1][i]) > 0) {
                    targetBitCnt++;
                }
            }
            while (curBitCnt < targetBitCnt) {
                int[] rightBinary = toBinary(nums[++right]);
                for (int i = 0; i < 32; i++) {
                    bitCnt[i] += rightBinary[i];
                    if (bitCnt[i] == 1 && rightBinary[i] == 1) {
                        curBitCnt++;
                    }
                }
            }
            answer[left] = Math.max(1, right - left + 1);
            int[] leftBinary = toBinary(nums[left]);
            for (int i = 0; i < 32; i++) {
                bitCnt[i] -= leftBinary[i];
                if (bitCnt[i] == 0 && leftBinary[i] == 1) {
                    curBitCnt--;
                }
            }
        }
        return answer;
    }

    private int[] toBinary(int num) {
        int index = 0;
        int[] answer = new int[32];
        while (0 < num) {
            answer[index] = num % 2;
            num /= 2;
            index++;
        }
        return answer;
    }

}
