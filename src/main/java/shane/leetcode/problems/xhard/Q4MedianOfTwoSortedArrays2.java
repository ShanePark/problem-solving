package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2ms Beats 72.48%of users with Java
 * Memory Details 44.39MB Beats 90.08%of users with Java
 */
public class Q4MedianOfTwoSortedArrays2 {

    @Test
    public void test() {
        assertThat(findMedianSortedArrays(new int[]{}, new int[]{2})).isEqualTo(2);
        assertThat(findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 1})).isEqualTo(1.0);
        assertThat(findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{5})).isEqualTo(3.0);
        assertThat(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})).isEqualTo(2.5);
        assertThat(findMedianSortedArrays(new int[]{1, 3}, new int[]{2})).isEqualTo(2.0);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (list.size() < nums1.length + nums2.length) {
            if (index1 == nums1.length) {
                list.add(nums2[index2++]);
            } else if (index2 == nums2.length) {
                list.add(nums1[index1++]);
            } else if (nums1[index1] >= nums2[index2]) {
                list.add(nums2[index2++]);
            } else {
                list.add(nums1[index1++]);
            }
        }

        if (list.size() % 2 == 1) {
            return list.get(list.size() / 2);
        }

        return (((double) list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2);
    }

}
