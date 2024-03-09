package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 81.56% of users with Java
 */
public class Q2540MinimumCommonValue {

    @Test
    public void test() {
        assertThat(getCommon(new int[]{1, 2, 3}, new int[]{2, 4})).isEqualTo(2);
        assertThat(getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5})).isEqualTo(2);
        assertThat(getCommon(new int[]{1, 2, 3, 6}, new int[]{4, 5})).isEqualTo(-1);
    }

    public int getCommon(int[] nums1, int[] nums2) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            int n1 = nums1[i1];
            int n2 = nums2[i2];
            if (n1 == n2) {
                return n1;
            }
            if (n1 < n2) {
                i1++;
                continue;
            }
            i2++;
        }
        return -1;
    }

}
