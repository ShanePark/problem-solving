package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 100.00%of users with Java
 * Memory Details 44.47MB Beats 81.29%of users with Java
 */
public class Q4MedianOfTwoSortedArrays {

    @Test
    public void test() {
        assertThat(findMedianSortedArrays(new int[]{}, new int[]{2})).isEqualTo(2);
        assertThat(findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1})).isEqualTo(1.0);
        assertThat(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5})).isEqualTo(3.0);
        assertThat(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})).isEqualTo(2.5);
        assertThat(findMedianSortedArrays(new int[]{1, 3}, new int[]{2})).isEqualTo(2.0);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int fullLength = length1 + length2;

        int index1 = 0;
        int index2 = 0;

        while (index1 + index2 < (fullLength + 1) / 2 - 1) {
            if (index1 == length1) {
                index2++;
                continue;
            }
            if (index2 == length2) {
                index1++;
                continue;
            }
            if (index2 < length2 && nums1[index1] >= nums2[index2]) {
                index2++;
                continue;
            }
            index1++;
        }

        int mid;

        if (index1 == length1) {
            mid = nums2[index2++];
        } else if (index2 == length2) {
            mid = nums1[index1++];
        } else if (nums1[index1] >= nums2[index2]) {
            mid = nums2[index2++];
        } else {
            mid = nums1[index1++];
        }

        int nextMid = mid;
        if (fullLength % 2 == 0) {
            nextMid = findNextMid(nums1, nums2, index1, index2);
        }

        return (double) (mid + nextMid) / 2;
    }

    private int findNextMid(int[] nums1, int[] nums2, int index1, int index2) {
        if (index1 == nums1.length)
            return nums2[index2];
        if (index2 == nums2.length)
            return nums1[index1];

        if (nums1[index1] >= nums2[index2]) {
            return nums2[index2];
        }
        return nums1[index1];
    }

}
