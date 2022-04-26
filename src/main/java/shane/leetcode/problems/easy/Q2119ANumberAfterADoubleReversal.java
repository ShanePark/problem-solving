package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2119ANumberAfterADoubleReversal {

    @Test
    public void test() {
        assertThat(isSameAfterReversals(526)).isTrue();
        assertThat(isSameAfterReversals(1800)).isFalse();
        assertThat(isSameAfterReversals(0)).isTrue();
    }

    public boolean isSameAfterReversals(int num) {
        return num == getReverse(getReverse(num));
    }

    private int getReverse(int num) {
        return Integer.parseInt(new StringBuffer(num + "").reverse().toString());
    }
}
