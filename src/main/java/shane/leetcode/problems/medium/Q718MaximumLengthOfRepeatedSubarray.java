package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q718MaximumLengthOfRepeatedSubarray {

    @Test
    public void test() {
        assertThat(findLength(new int[]{70, 39, 25, 40, 7}, new int[]{52, 20, 67, 5, 31})).isEqualTo(0);
        assertThat(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7})).isEqualTo(3);
        assertThat(findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0})).isEqualTo(5);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        for (int i = 0; i < length1; i++) {
            int start = nums1[i];
            for (int j = 0; j < length2; j++) {
                if (start == nums2[j]) {
                    int cnt = 1;
                    int i2 = i + 1;
                    int j2 = j + 1;
                    while (i2 < length1 && j2 < length2 && nums1[i2] == nums2[j2]) {
                        i2++;
                        j2++;
                        cnt++;
                    }
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }
}
