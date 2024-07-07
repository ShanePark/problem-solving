package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q1518WaterBottles {

    @Test
    public void test() {
        assertThat(numWaterBottles(9, 3)).isEqualTo(13);
        assertThat(numWaterBottles(15, 4)).isEqualTo(19);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = 0;
        int left = 0;
        while (numBottles > 0) {
            sum += numBottles;
            numBottles += left;
            left = numBottles % numExchange;
            numBottles /= numExchange;
        }
        return sum;
    }

}
