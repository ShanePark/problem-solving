package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q1518WaterBottles2 {

    @Test
    public void test() {
        assertThat(numWaterBottles(9, 3)).isEqualTo(13);
        assertThat(numWaterBottles(15, 4)).isEqualTo(19);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = numBottles;
        while (numBottles >= numExchange) {
            int exchange = numBottles / numExchange;
            answer += exchange;
            numBottles = numBottles - exchange * numExchange + exchange;
        }
        return answer;
    }

}
