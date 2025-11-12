package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2654MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{2, 6, 3, 4})).isEqualTo(4);
        assertThat(minOperations(new int[]{2, 10, 6, 14})).isEqualTo(-1);
    }

    @Test
    public void test2() {
        assertThat(minOperations(new int[]{2, 6, 1, 3, 4})).isEqualTo(4);
    }

    public int minOperations(int[] nums) {
        int oneCnt = 0;
        for (int num : nums) {
            if (num == 1)
                oneCnt++;
        }
        if (0 < oneCnt) {
            return nums.length - oneCnt;
        }

        int minLen = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            for (int j = i; j < nums.length && j - i + 1 < minLen; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == 1) {
                    minLen = j - i + 1;
                    break;
                }
            }
        }

        if (nums.length < minLen) {
            return -1;
        }

        return nums.length + minLen - 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
