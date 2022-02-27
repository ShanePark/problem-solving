package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q2006CountNumberOfPairsWithAbsoluteDifferenceK {

    @Test
    void test() {
        Assertions.assertThat(countKDifference(new int[]{1, 2, 2, 1}, 1)).isEqualTo(4);
        Assertions.assertThat(countKDifference(new int[]{1, 3}, 3)).isEqualTo(0);
        Assertions.assertThat(countKDifference(new int[]{3, 2, 1, 5, 4}, 2)).isEqualTo(3);
    }

    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    cnt++;
                } else if (nums[j] - nums[i] > k) {
                    break;
                }
            }
        }
        return cnt;
    }


}
