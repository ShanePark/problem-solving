package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1900TheEarliestAndLatestRoundsWherePlayersCompete {

    @Test
    public void test() {
        assertThat(earliestAndLatest(11, 2, 4)).isEqualTo(new int[]{3, 4});
        assertThat(earliestAndLatest(5, 1, 5)).isEqualTo(new int[]{1, 1});
    }

    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] answer = new int[]{n, 0};
        int first = Math.min(firstPlayer, secondPlayer) - 1;
        int second = Math.max(firstPlayer, secondPlayer) - 1;
        findRounds(n, (1 << n) - 1, 1, 0, n - 1, first, second, answer);
        return answer;
    }

    public void findRounds(int n, int mask, int round, int left, int right, int first, int second, int[] answer) {
        if (left >= right) {
            findRounds(n, mask, round + 1, 0, n - 1, first, second, answer);
            return;
        }
        if ((mask & (1 << left)) == 0) {
            findRounds(n, mask, round, left + 1, right, first, second, answer);
            return;
        }
        if ((mask & (1 << right)) == 0) {
            findRounds(n, mask, round, left, right - 1, first, second, answer);
            return;
        }
        if (left == first && right == second) {
            answer[0] = Math.min(answer[0], round);
            answer[1] = Math.max(answer[1], round);
            return;
        }
        if (left != first && left != second)
            findRounds(n, mask ^ (1 << left), round, left + 1, right - 1, first, second, answer);
        if (right != first && right != second)
            findRounds(n, mask ^ (1 << right), round, left + 1, right - 1, first, second, answer);
    }

}
