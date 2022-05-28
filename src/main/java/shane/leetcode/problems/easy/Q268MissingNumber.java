package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q268MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += i - nums[i];
        }
        return sum;
    }

    @Test
    public void test() {
        assertThat(missingNumber(new int[]{3, 0, 1})).isEqualTo(2);
        assertThat(missingNumber(new int[]{0, 1})).isEqualTo(2);
        assertThat(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
    }
}
