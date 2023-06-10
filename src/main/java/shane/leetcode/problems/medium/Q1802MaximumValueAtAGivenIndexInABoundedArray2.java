package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100%
 * Memory 39.9 MB Beats 24.60%
 */
public class Q1802MaximumValueAtAGivenIndexInABoundedArray2 {

    @Test
    void test() {
        assertThat(maxValue(4, 2, 6)).isEqualTo(2);
        assertThat(maxValue(6, 1, 10)).isEqualTo(3);
        assertThat(maxValue(2354294, 2306843, 457811956)).isEqualTo(21342);
    }

    @Test
    void tle() {
        int max = (int) 1e9;
        assertThat(maxValue(max, max / 2, max)).isEqualTo(1);
    }

    @Test
    void sumTest() {
        assertThat(sum(4, 2, 2)).isEqualTo(5);
        assertThat(sum(4, 2, 3)).isEqualTo(8);
        assertThat(sum(5, 1, 2)).isEqualTo(6);
    }

    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (maxSum < sum(n, index, mid)) {
                right = mid - 1;
                continue;
            }
            left = mid;
        }
        return left;
    }


    private long sum(int n, int index, int value) {
        long sum = 0;

        // Sum left
        int leftMin = Math.max(1, value - index);
        sum += (long) (value - 1 + leftMin) * (value - leftMin) / 2;
        sum += index - (value - leftMin); // 1's on the left side

        // Sum right
        int rightMin = Math.max(1, value - (n - index - 1));
        sum += (long) (value - 1 + rightMin) * (value - rightMin) / 2;
        sum += n - index - 1 - (value - rightMin); // 1's on the right side

        return sum + value;
    }

}
