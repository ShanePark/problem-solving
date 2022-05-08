package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1217MinimumCostToMoveChipsToTheSamePosition {

    @Test
    public void test() {
        assertThat(minCostToMoveChips(new int[]{1, 2, 3})).isEqualTo(1);
        assertThat(minCostToMoveChips(new int[]{2, 2, 2, 3, 3})).isEqualTo(2);
        assertThat(minCostToMoveChips(new int[]{1, 1000000000})).isEqualTo(1);
    }

    public int minCostToMoveChips(int[] position) {
        int[] arr = new int[2];
        for (int i : position) {
            arr[i % 2]++;
        }
        return Math.min(arr[0], arr[1]);
    }
}
