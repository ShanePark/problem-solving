package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1140StoneGameII {

    @Test
    public void test() {
        assertThat(stoneGameII(new int[]{77, 12, 64, 35, 28, 4, 87, 21, 20})).isEqualTo(217);
        assertThat(stoneGameII(new int[]{2, 7, 9, 4, 4})).isEqualTo(10);
        assertThat(stoneGameII(new int[]{1, 2, 3, 4, 5, 100})).isEqualTo(104);
    }

    /**
     * 56 sec 644 ms
     */
    @Test
    public void tle() {
        assertThat(stoneGameII(new int[]{7468, 6245, 9261, 3958, 1986, 1074, 5677, 9386, 1408, 1384, 8811, 3885, 9678, 8470, 8893, 7514, 4941, 2148, 5217, 5425, 5307, 747, 1253, 3518, 5238, 5834, 9133, 8391, 6100, 3362, 7807, 2581, 6121, 7684, 8744, 9584, 4068, 7204, 4285, 8635}))
                .isEqualTo(115357);
    }

    public int stoneGameII(int[] piles) {
        return game(piles, 0, 1);
    }

    private int game(int[] piles, int index, int m) {
        int sum = 0;
        for (int i = index; i < piles.length; i++) {
            sum += piles[i];
        }
        if (piles.length < index + 2 * m) {
            return sum;
        }
        int min = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++) {
            min = Math.min(min, game(piles, index + x, Math.max(m, x)));
        }
        return sum - min;
    }

}
