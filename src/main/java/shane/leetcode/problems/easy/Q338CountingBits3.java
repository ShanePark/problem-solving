package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime Details 2ms Beats 73.73%of users with Java
 * Memory Details 46.46MB Beats 51.44%of users with Java
 */
public class Q338CountingBits3 {

    @Test
    void test() {
        Assertions.assertThat(countBits(0)).containsExactly(0);
        Assertions.assertThat(countBits(2)).containsExactly(0, 1, 1);
        Assertions.assertThat(countBits(5)).containsExactly(0, 1, 1, 2, 1, 2);
    }

    public int[] countBits(int n) {
        if (n == 0)
            return new int[]{0};
        int[] answer = new int[n + 1];

        answer[1] = 1;
        for (int i = 1; Math.pow(2, i) <= n; i++) {
            int pow = (int) Math.pow(2, i);
            int next = (int) Math.pow(2, i + 1);
            for (int j = pow; j < Math.min(next, n + 1); j++) {
                answer[j] = answer[j - pow] + 1;
            }
        }

        return answer;
    }

}
