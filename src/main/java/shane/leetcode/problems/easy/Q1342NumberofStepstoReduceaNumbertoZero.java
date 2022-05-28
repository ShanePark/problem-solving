package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1342NumberOfStepsToReduceANumberToZero {

    @Test
    public void test() {
        assertThat(numberOfSteps(14)).isEqualTo(6);
        assertThat(numberOfSteps(8)).isEqualTo(4);
        assertThat(numberOfSteps(123)).isEqualTo(12);
        assertThat(numberOfSteps(0)).isEqualTo(0);
        assertThat(numberOfSteps(1)).isEqualTo(1);
    }

    public int numberOfSteps(int num) {
        return (num == 0 ? 0 : (int) (Math.log10(num) / Math.log10(2))) + Integer.bitCount(num);
    }
}
