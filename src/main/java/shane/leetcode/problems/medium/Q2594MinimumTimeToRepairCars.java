package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 19
 * ms
 * Beats
 * 85.75%
 */
public class Q2594MinimumTimeToRepairCars {

    @Test
    public void test() {
        assertThat(repairCars(new int[]{4, 2, 3, 1}, 10)).isEqualTo(16);
        assertThat(repairCars(new int[]{5, 1, 8}, 6)).isEqualTo(16);
    }

    @Test
    public void test2() {
        assertThat(repairCars(new int[]{100}, 1000000)).isEqualTo(100000000000000L);
    }

    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long) 1e14;
        while (left < right) {
            long mid = (left + right) / 2;
            if (possible(ranks, cars, mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return left;
    }

    private boolean possible(int[] ranks, long cars, long time) {
        for (int rank : ranks) {
            int work = (int) Math.sqrt((double) time / rank);
            cars -= work;
            if (cars <= 0)
                return true;
        }
        return false;
    }

}
