package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q496NextGreaterElementI {

    @Test
    public void test() {
        assertThat(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})).containsExactly(-1, 3, -1);
        assertThat(nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})).containsExactly(3, -1);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answer = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            int j = 0;
            while (nums2[j] != n) {
                j++;
            }
            while (j < nums2.length && nums2[j] <= n) {
                j++;
            }
            answer[i] = (j == nums2.length) ? -1 : nums2[j];
        }
        return answer;
    }
}
