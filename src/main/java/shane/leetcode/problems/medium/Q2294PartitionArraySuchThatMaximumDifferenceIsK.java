package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2294PartitionArraySuchThatMaximumDifferenceIsK {

    @Test
    public void test() {
        assertThat(partitionArray(new int[]{3, 6, 1, 2, 5}, 2)).isEqualTo(2);
        assertThat(partitionArray(new int[]{1, 2, 3}, 1)).isEqualTo(2);
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (min + k < nums[i]) {
                min = nums[i];
                cnt++;
            }
        }
        return cnt;
    }
}
