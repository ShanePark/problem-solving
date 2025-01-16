package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Referenced XOR properties (commutativity, associativity, x⊕x=0x⊕x=0) to solve
 */
public class Q2425BitwiseXOROfAllPairings {

    @Test
    public void test() {
        assertThat(xorAllNums(new int[]{2, 1, 3}, new int[]{10, 2, 5, 0})).isEqualTo(13);
        assertThat(xorAllNums(new int[]{1, 2}, new int[]{3, 4})).isEqualTo(0);
        assertThat(xorAllNums(new int[]{0, 1}, new int[]{2, 3})).isEqualTo(0);
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        int answer = 0;
        if (nums1.length % 2 == 1) {
            for (int i : nums2) {
                answer ^= i;
            }
        }
        if (nums2.length % 2 == 1) {
            for (int i : nums1) {
                answer ^= i;
            }
        }
        return answer;
    }

}
