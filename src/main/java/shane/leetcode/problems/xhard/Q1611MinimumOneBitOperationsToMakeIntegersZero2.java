package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1611MinimumOneBitOperationsToMakeIntegersZero2 {

    @Test
    public void test() {
        assertThat(minimumOneBitOperations(3)).isEqualTo(2);
        assertThat(minimumOneBitOperations(6)).isEqualTo(4);
    }

    public int minimumOneBitOperations(int n) {
        n ^= n >> 16;
        n ^= n >> 8;
        n ^= n >> 4;
        n ^= n >> 2;
        n ^= n >> 1;
        return n;
    }

}
