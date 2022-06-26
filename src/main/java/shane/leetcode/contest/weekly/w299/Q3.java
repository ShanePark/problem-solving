package shane.leetcode.contest.weekly.w299;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(maximumsSplicedArray(new int[]{60, 60, 60}, new int[]{10, 90, 10})).isEqualTo(210);
        assertThat(maximumsSplicedArray(new int[]{20, 40, 20, 70, 30}, new int[]{50, 20, 50, 40, 20})).isEqualTo(220);
        assertThat(maximumsSplicedArray(new int[]{7, 11, 13}, new int[]{1, 1, 1})).isEqualTo(31);
    }

    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int length = nums1.length;

        // find the bigger one
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();

        int[] bigger, smaller;
        if (sum1 >= sum2) {
            bigger = nums1;
            smaller = nums2;
        } else {
            bigger = nums2;
            smaller = nums1;
        }


        int best = 0;
        int bestStart = -1;
        int bestEnd = -1;
        // find the best part
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += smaller[j] - bigger[j];
                if (best < sum) {
                    bestStart = i;
                    bestEnd = j;
                    best = sum;
                }
            }
        }

        if (bestStart < 0)
            return Math.max(sum1, sum2);

        // swap and return the best result
        int result = 0;

        for (int i = 0; i < bestStart; i++) {
            result += bigger[i];
        }
        for (int i = bestStart; i <= bestEnd; i++) {
            result += smaller[i];
        }
        for (int i = bestEnd + 1; i < length; i++) {
            result += bigger[i];
        }

        return result;
    }

}
