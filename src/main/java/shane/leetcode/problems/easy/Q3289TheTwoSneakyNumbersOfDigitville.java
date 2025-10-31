package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 100.00%
 */
public class Q3289TheTwoSneakyNumbersOfDigitville {

    @Test
    public void test() {
        assertThat(getSneakyNumbers(new int[]{0, 1, 1, 0})).containsExactlyInAnyOrder(0, 1);
        assertThat(getSneakyNumbers(new int[]{0, 3, 2, 1, 3, 2})).containsExactlyInAnyOrder(2, 3);
        assertThat(getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2})).containsExactlyInAnyOrder(4, 5);
    }

    public int[] getSneakyNumbers(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        int[] answer = new int[]{-1, -1};
        for (int num : nums) {
            if (visit[num]) {
                if (answer[0] == -1) {
                    answer[0] = num;
                    visit[num] = true;
                    continue;
                }
                answer[1] = num;
                return answer;
            }
            visit[num] = true;
        }
        return null;
    }

}
