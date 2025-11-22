package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q3190FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    @Test
    public void test() {
        assertThat(minimumOperations(new int[]{1, 2, 3, 4})).isEqualTo(3);
        assertThat(minimumOperations(new int[]{3, 6, 9})).isEqualTo(0);
    }

    public int minimumOperations(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            if (num % 3 == 0)
                continue;
            answer++;
        }
        return answer;
    }

}
