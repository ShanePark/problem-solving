package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6
 * ms
 * Beats
 * 7.94%
 */
public class Q2169CountOperationsToObtainZero {

    @Test
    public void test() {
        assertThat(countOperations(2, 3)).isEqualTo(3);
        assertThat(countOperations(10, 10)).isEqualTo(1);
    }

    public int countOperations(int num1, int num2) {
        if (num1 == 0 || num2 == 0)
            return 0;
        return 1 + countOperations(num1 >= num2 ? num1 - num2 : num1, num2 > num1 ? num2 - num1 : num2);
    }

}
