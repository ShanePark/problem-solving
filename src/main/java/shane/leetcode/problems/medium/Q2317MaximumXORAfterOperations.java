package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2317MaximumXORAfterOperations {

    @Test
    public void test() {
        assertThat(maximumXOR(new int[]{3, 2, 4, 6})).isEqualTo(7);
        assertThat(maximumXOR(new int[]{1, 2, 3, 9, 2})).isEqualTo(11);
    }

    public int maximumXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result |= num;
        }
        return result;
    }
}
