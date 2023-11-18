package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 93ms Beats 5.65%of users with Java
 * Memory Details 58.08MB Beats 17.72%of users with Java
 */
public class Q1838FrequencyOfTheMostFrequentElement2 {

    @Test
    public void test() {
        assertThat(maxFrequency(new int[]{1, 4, 8, 13}, 5)).isEqualTo(2);
        assertThat(maxFrequency(new int[]{1, 2, 4}, 5)).isEqualTo(3);
        assertThat(maxFrequency(new int[]{3, 9, 6}, 2)).isEqualTo(1);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        Arrays.fill(arr, 100000);

        assertThat(maxFrequency(arr, 5)).isEqualTo(100000);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = left + (right - left) / 2;
                boolean isValid = isValid(mid, i, num, sums, k);
                if (isValid) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int range = i - left + 1;
            max = Math.max(max, range);
        }

        return max;
    }

    private boolean isValid(int from, int end, int num, long[] sums, int k) {
        int range = end - from + 1;
        long required = (long) range * num;
        long sum = sums[end] - (from == 0 ? 0 : sums[from - 1]);
        return required <= sum + k;
    }

}
