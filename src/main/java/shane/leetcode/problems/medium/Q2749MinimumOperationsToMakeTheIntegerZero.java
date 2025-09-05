package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2749MinimumOperationsToMakeTheIntegerZero {

    @Test
    public void test() {
        assertThat(makeTheIntegerZero(3, -2)).isEqualTo(3);
        assertThat(makeTheIntegerZero(5, 7)).isEqualTo(-1);
    }

    @Test
    public void test2() {
        assertThat(makeTheIntegerZero(110, 55)).isEqualTo(-1);
    }

    public int makeTheIntegerZero(int num1, int num2) {
        long n = num1;
        for (int i = 1; i <= 60; i++) {
            n -= num2;
            int bitCnt = Long.bitCount(n);
            if (n < i)
                return -1;
            if (bitCnt <= i)
                return i;
        }
        return -1;
    }

}
