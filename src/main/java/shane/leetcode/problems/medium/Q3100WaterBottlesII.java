package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats30.32%
 */
public class Q3100WaterBottlesII {

    @Test
    public void test() {
        assertThat(maxBottlesDrunk(13, 6)).isEqualTo(15);
        assertThat(maxBottlesDrunk(10, 3)).isEqualTo(13);
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int answer = numBottles;
        while (numBottles >= numExchange) {
            answer++;
            numBottles -= numExchange;
            numBottles++;
            numExchange++;
        }
        return answer;
    }

}
