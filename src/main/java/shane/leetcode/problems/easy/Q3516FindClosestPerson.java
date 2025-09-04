package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q3516FindClosestPerson {

    @Test
    public void test() {
        assertThat(findClosest(2, 7, 4)).isEqualTo(1);
        assertThat(findClosest(2, 5, 6)).isEqualTo(2);
        assertThat(findClosest(1, 5, 3)).isEqualTo(0);
    }

    public int findClosest(int x, int y, int z) {
        int diff1 = Math.abs(z - x);
        int diff2 = Math.abs(z - y);
        if (diff1 == diff2)
            return 0;
        if (diff1 < diff2)
            return 1;
        return 2;
    }

}
