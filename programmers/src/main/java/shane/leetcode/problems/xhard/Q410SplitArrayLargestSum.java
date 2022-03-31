package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q410SplitArrayLargestSum {

    @Test
    public void test() {
        assertThat(splitArray(new int[]{7, 2, 5, 10, 8}, 2)).isEqualTo(18);
        assertThat(splitArray(new int[]{1, 2, 3, 4, 5}, 2)).isEqualTo(9);
        assertThat(splitArray(new int[]{1, 4, 4}, 3)).isEqualTo(4);
    }

    int largestSum = Integer.MAX_VALUE;

    public int splitArray(int[] nums, int m) {
        dfs(nums, new ArrayList<>(), m, 1);
        return largestSum;
    }

    private void dfs(int[] nums, List<Integer> list, int m, int index) {
        if (index > nums.length)
            return;

        if (list.size() == m - 1) {
            int maxSum = 0;
            int beforeIndex = 0;
            for (Integer i : list) {
                int sum = 0;
                for (int j = beforeIndex; j < i; j++) {
                    sum += nums[j];
                }
                maxSum = Math.max(maxSum, sum);
                beforeIndex = i;
            }
            int sum = 0;
            for(int i=beforeIndex; i<nums.length; i++) {
                sum += nums[i];
            }
            maxSum = Math.max(maxSum, sum);
            largestSum = Math.min(largestSum, maxSum);
            return;
        }

        // split
        list.add(index);
        dfs(nums, list, m, index + 1);
        list.remove((Integer) index);


        // skip
        dfs(nums, list, m, index + 1);

    }
}
