package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2341MaximumNumberOfPairsInArray {

    @Test
    public void test() {
        assertThat(numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})).containsExactly(3, 1);
        assertThat(numberOfPairs(new int[]{1, 1})).containsExactly(1, 0);
        assertThat(numberOfPairs(new int[]{0})).containsExactly(0, 1);
    }

    public int[] numberOfPairs(int[] nums) {
        boolean[] memo = new boolean[101];
        int[] answer = new int[2];
        for (int num : nums) {
            if (memo[num]) {
                answer[0]++;
            }
            memo[num] = !memo[num];
        }
        for (boolean b : memo) {
            if (b)
                answer[1]++;
        }
        return answer;
    }
}
