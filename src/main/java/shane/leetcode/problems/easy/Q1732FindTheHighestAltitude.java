package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1732FindTheHighestAltitude {

    @Test
    public void test() {
        assertThat(largestAltitude(new int[]{-5, 1, 5, 0, -7})).isEqualTo(1);
        assertThat(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2})).isEqualTo(0);
    }

    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int max = 0;
        for (int i : gain) {
            altitude += i;
            max = Math.max(max, altitude);
        }
        return max;
    }
}
