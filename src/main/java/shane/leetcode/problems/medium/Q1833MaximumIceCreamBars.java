package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 47 ms Beats 48.58%
 * Memory 79.6 MB Beats 13.51%
 */
public class Q1833MaximumIceCreamBars {

    @Test
    public void test() {
        assertThat(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7)).isEqualTo(4);
        assertThat(maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5)).isEqualTo(0);
        assertThat(maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20)).isEqualTo(6);
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int cnt = 0;
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins < 0)
                break;
            cnt++;
        }
        return cnt;
    }

}
