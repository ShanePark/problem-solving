package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2040KthSmallestProductOfTwoSortedArrays {

    @Test
    public void test() {
        assertThat(kthSmallestProduct(new int[]{-2, -1, 0, 1, 2}, new int[]{-3, -1, 2, 4, 5}, 3)).isEqualTo(-6);
        assertThat(kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 2)).isEqualTo(8);
        assertThat(kthSmallestProduct(new int[]{-4, -2, 0, 3}, new int[]{2, 4}, 6)).isEqualTo(0);
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = (long) -1e10;
        long right = -left;
        while (left < right) {
            long mid = left + right + 1 >> 1;
            if (count(nums1, nums2, mid) < k) {
                left = mid;
                continue;
            }
            right = mid - 1;
        }
        return left;
    }

    private long count(int[] nums1, int[] nums2, long value) {
        long answer = 0;
        for (long num : nums1) {
            int left = 0;
            int right = nums2.length;
            if (num < 0) {
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums2[mid] * num >= value) {
                        left = mid + 1;
                        continue;
                    }
                    right = mid;
                }
                answer += nums2.length - left;
                continue;
            }
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums2[mid] * num < value) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }
            answer += left;
        }
        return answer;
    }

}
