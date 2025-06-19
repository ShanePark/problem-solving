package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
33ms
Beats74.47%
 */
public class Q2294PartitionArraySuchThatMaximumDifferenceIsK2 {

    @Test
    public void test() {
        assertThat(partitionArray(new int[]{3, 6, 1, 2, 5}, 2)).isEqualTo(2);
        assertThat(partitionArray(new int[]{1, 2, 3}, 1)).isEqualTo(2);
        assertThat(partitionArray(new int[]{2, 2, 4, 5}, 0)).isEqualTo(3);
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int min = -10_0001;
        int answer = 0;
        for (int num : nums) {
            if (num - min <= k)
                continue;
            answer++;
            min = num;
        }
        return answer;
    }

}
