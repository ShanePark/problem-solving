package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 30.40%
 * Memory 48 MB Beats 72.85%
 */
public class Q540SingleElementInASortedArray {
    
    @Test
    public void test() {
        assertThat(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})).isEqualTo(2);
        assertThat(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})).isEqualTo(10);
    }

    public int singleNonDuplicate(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n ^= num;
        }
        return n;
    }

}
