package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1342NumberofStepstoReduceaNumbertoZero {

    @Test
    void test() {
        Assertions.assertThat(numberOfSteps(14)).isEqualTo(6);
        Assertions.assertThat(numberOfSteps(8)).isEqualTo(4);
        Assertions.assertThat(numberOfSteps(123)).isEqualTo(12);
        Assertions.assertThat(numberOfSteps(0)).isEqualTo(0);
    }

    public int numberOfSteps(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 2 + 1;
            num /= 2;
        }

        return cnt == 0 ? cnt : cnt - 1;

    }
}
