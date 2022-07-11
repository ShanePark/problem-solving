package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1043PartitionArrayForMaximumSum {

    @Test
    public void test() {
        assertThat(maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)).isEqualTo(84);
        assertThat(maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4)).isEqualTo(83);
        assertThat(maxSumAfterPartitioning(new int[]{1}, 1)).isEqualTo(1);
    }

    // TODO
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return -1;
    }
}
