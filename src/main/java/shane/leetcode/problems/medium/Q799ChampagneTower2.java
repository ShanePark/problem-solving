package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TLE
 */
public class Q799ChampagneTower2 {

    @Test
    void test() {
        Assertions.assertThat(champagneTower(1, 1, 1)).isEqualTo(0.00000);
        Assertions.assertThat(champagneTower(2, 1, 1)).isEqualTo(0.50000);
        Assertions.assertThat(champagneTower(100000009, 33, 17)).isEqualTo(1.00000);
        Assertions.assertThat(champagneTower(25, 6, 1)).isEqualTo(0.18750);
        Assertions.assertThat(champagneTower(6, 2, 0)).isEqualTo(0.75000);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] arr = new double[query_row + 2];
        arr[0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = i; j >= 0; j--) {
                arr[j + 1] += arr[j] = Math.max(0, (arr[j] - 1) / 2);
            }
        }
        return Math.min(arr[query_glass], 1);
    }


}
