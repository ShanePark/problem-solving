package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1732FindTheHighestAltitude2 {

    @Test
    public void test() {
        assertThat(largestAltitude(new int[]{-5, 1, 5, 0, -7})).isEqualTo(1);
        assertThat(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2})).isEqualTo(0);
    }

    public int largestAltitude(int[] gain) {
        int max = 0;
        int cur = 0;
        for (int i : gain) {
            cur += i;
            max = Math.max(max, cur);
        }
        return max;
    }

}
