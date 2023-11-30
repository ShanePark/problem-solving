package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1611MinimumOneBitOperationsToMakeIntegersZero {

    @Test
    public void test() {
        assertThat(minimumOneBitOperations(3)).isEqualTo(2);
        assertThat(minimumOneBitOperations(6)).isEqualTo(4);
    }

    public int minimumOneBitOperations(int n) {
        if (n == 0)
            return 0;
        int left = Integer.highestOneBit(n);
        return left * 2 - 1 - minimumOneBitOperations(n ^ left);
    }

}
