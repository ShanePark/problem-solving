package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3577CountTheNumberOfComputerUnlockingPermutations {

    @Test
    public void test() {
        assertThat(countPermutations(new int[]{1, 2, 3})).isEqualTo(2);
        assertThat(countPermutations(new int[]{3, 3, 3, 4, 4, 4})).isEqualTo(0);
    }

    final int MOD = (int) 1e9 + 7;

    public int countPermutations(int[] complexity) {
        int start = complexity[0];
        long answer = 1;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= start)
                return 0;
            answer = (answer * i) % MOD;
        }
        return (int) answer;
    }

}
