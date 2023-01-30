package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 38.7 MB Beats 98.67%
 */
public class Q1137NthTribonacciNumber {


    @Test
    public void test() {
        assertThat(tribonacci(0)).isEqualTo(0);
        assertThat(tribonacci(1)).isEqualTo(1);
        assertThat(tribonacci(4)).isEqualTo(4);
        assertThat(tribonacci(25)).isEqualTo(1389537);
    }

    public int tribonacci(int n) {
        if (n < 4)
            return (n + 1) / 2;
        int[] tri = new int[n + 1];
        tri[0] = 0;
        tri[1] = 1;
        tri[2] = 1;
        tri[3] = 2;
        for (int i = 4; i <= n; i++) {
            tri[i] = tri[i - 1] * 2 - tri[i - 4];
        }
        return tri[n];
    }

}
