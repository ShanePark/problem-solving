package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime3msBeats93.06%
 */
public class Q1701AverageWaitingTime {

    @Test
    public void test() {
        assertThat(averageWaitingTime(Ps.intArray("[[1,2],[2,5],[4,3]]"))).isEqualTo(5.0000);
        assertThat(averageWaitingTime(Ps.intArray("[[5,2],[5,4],[10,3],[20,1]]"))).isEqualTo(3.2500);
    }

    public double averageWaitingTime(int[][] customers) {
        int time = 0;
        long sum = 0;
        for (int[] customer : customers) {
            time = Math.max(time, customer[0]) + customer[1];
            sum += (time - customer[0]);
        }
        return (double) sum / customers.length;
    }

}
