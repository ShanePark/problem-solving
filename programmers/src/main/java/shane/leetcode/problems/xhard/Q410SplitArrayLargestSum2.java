package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q410SplitArrayLargestSum2 {

    @Test
    public void test() {
        assertThat(splitArray(new int[]{7, 2, 5, 10, 8}, 2)).isEqualTo(18);
        assertThat(splitArray(new int[]{1, 2, 3, 4, 5}, 2)).isEqualTo(9);
        assertThat(splitArray(new int[]{1, 4, 4}, 3)).isEqualTo(4);
    }


    public int splitArray(int[] nums, int m) {
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        while (max <= sum) {
            int mid = (max + sum) / 2;
            if (valid(mid, nums, m)) {
                sum = mid - 1;
            } else {
                max = mid + 1;
            }
        }
        return max;

    }

    private boolean valid(int maxSum, int[] nums, int m) {
        int cnt = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                if (++cnt > m) {
                    return false;
                }
                sum = num;
            }
        }
        return true;
    }
}
