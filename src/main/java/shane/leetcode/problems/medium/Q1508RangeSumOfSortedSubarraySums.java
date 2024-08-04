package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime185msBeats16.21%
 */
public class Q1508RangeSumOfSortedSubarraySums {

    @Test
    public void test() {
        assertThat(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5)).isEqualTo(13);
        assertThat(rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4)).isEqualTo(6);
        assertThat(rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10)).isEqualTo(50);
    }

    final int MOD = (int) 1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long sum = 0;
        for (int i = left; i <= right; i++) {
            sum = (sum + list.get(i - 1)) % MOD;
        }
        return (int) sum;
    }

}
