package shane.leetcode.contest.weekly.w299;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3_2 {

    @Test
    public void test() {
        assertThat(maximumsSplicedArray(
                new int[]{28, 34, 38, 14, 30, 31, 23, 7, 28, 3},
                new int[]{42, 35, 7, 6, 24, 30, 14, 21, 20, 34})).isEqualTo(288);
        assertThat(maximumsSplicedArray(new int[]{7, 11, 13}, new int[]{1, 1, 1})).isEqualTo(31);
        assertThat(maximumsSplicedArray(new int[]{20, 40, 20, 70, 30}, new int[]{50, 20, 50, 40, 20})).isEqualTo(220);
        assertThat(maximumsSplicedArray(new int[]{60, 60, 60}, new int[]{10, 90, 10})).isEqualTo(210);
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int length = nums1.length;

        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        int[] copy1 = Arrays.copyOf(nums1, length);
        int[] copy2 = Arrays.copyOf(nums2, length);

        for (int i = 0; i < length; i++) {
            copy1[i] -= nums2[i];
            copy2[i] -= nums1[i];
        }

        for (int i = length - 2; i >= 0; i--) {
            if (copy1[i + 1] > 0) {
                copy1[i] = copy1[i] += copy1[i + 1];
            }
            if (copy2[i + 1] > 0) {
                copy2[i] = copy2[i] += copy2[i + 1];
            }
        }

        int swap1 = Arrays.stream(copy1).max().getAsInt();
        int swap2 = Arrays.stream(copy2).max().getAsInt();
        if (swap1 < 0)
            swap1 = 0;
        if (swap2 < 0)
            swap2 = 0;

        return Math.max(sum1 + swap2, sum2 + swap1);
    }

}
