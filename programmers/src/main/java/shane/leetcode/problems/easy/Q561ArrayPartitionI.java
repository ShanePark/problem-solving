package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q561ArrayPartitionI {
    @Test
    public void test() {
        assertThat(arrayPairSum(new int[]{1, 4, 3, 2})).isEqualTo(4);
        assertThat(arrayPairSum(new int[]{6, 2, 6, 5, 1, 2})).isEqualTo(9);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
