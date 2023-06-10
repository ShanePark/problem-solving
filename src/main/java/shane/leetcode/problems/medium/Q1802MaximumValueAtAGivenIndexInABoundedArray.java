package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 213 / 370 testcases passed
 */
public class Q1802MaximumValueAtAGivenIndexInABoundedArray {

    @Test
    void test() {
        assertThat(maxValue(4, 2, 6)).isEqualTo(2);
        assertThat(maxValue(6, 1, 10)).isEqualTo(3);
        assertThat(maxValue(2354294, 2306843, 457811956)).isEqualTo(21342);
    }

    /**
     * 13 sec
     */
    @Test
    void tle() {
        int max = (int) 1e9;
        assertThat(maxValue(max, max / 2, max)).isEqualTo(1);
    }

    @Test
    void isValidTest() {
        assertThat(isValid(4, 2, 6, 2)).isTrue();
        assertThat(isValid(4, 2, 6, 3)).isFalse();
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (!isValid(n, index, maxSum, mid)) {
                right = mid - 1;
                continue;
            }
            left = mid;
        }
        return left;
    }

    private boolean isValid(int n, int index, int maxSum, int value) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(i - index);
            int valueOnPosition = Math.max(1, value - diff);
            sum += valueOnPosition;
            if (maxSum < sum)
                return false;
        }
        return true;
    }

}
