package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 100.00%
 */
public class Q3477FruitsIntoBasketsII {

    @Test
    public void test() {
        assertThat(numOfUnplacedFruits(new int[]{6, 5}, new int[]{3, 5})).isEqualTo(1);
        assertThat(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4})).isEqualTo(1);
        assertThat(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7})).isEqualTo(0);
    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int answer = fruits.length;
        for (int fruit : fruits) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruit <= baskets[j]) {
                    baskets[j] = 0;
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

}
