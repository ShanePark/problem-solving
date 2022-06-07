package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q88MergeSortedArray {

    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        merge(nums1, 3, nums2, 3);
        assertThat(nums1).containsExactly(1, 2, 2, 3, 5, 6);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};
        merge(nums1, 1, nums2, 0);
        assertThat(nums1).containsExactly(1);
    }

    @Test
    public void test3() {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
        assertThat(nums1).containsExactly(1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] answer = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if (p1 == m) {
                answer[i] = nums2[p2++];
            } else if (p2 == n || nums1[p1] < nums2[p2]) {
                answer[i] = nums1[p1++];
            } else {
                answer[i] = nums2[p2++];
            }
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = answer[i];
        }
    }
}
