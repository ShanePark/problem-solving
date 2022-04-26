package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1551MinimumOperationsToMakeArrayEqual {

    @Test
    public void test() {
        assertThat(minOperations(1)).isEqualTo(0);
        assertThat(minOperations(2)).isEqualTo(1);
        assertThat(minOperations(3)).isEqualTo(2);
        assertThat(minOperations(4)).isEqualTo(4);
        assertThat(minOperations(5)).isEqualTo(6);
        assertThat(minOperations(6)).isEqualTo(9);
        assertThat(minOperations(7)).isEqualTo(12);
        assertThat(minOperations(8)).isEqualTo(16);
    }

    public int minOperations(int n) {
        return n * n / 4;
    }

//    public int minOperations(int n) {
//        int sum = 0;
//        for (int i = n % 2 + 1; i < n; i += 2) {
//            sum += i;
//        }
//        return sum;
//    }
}
