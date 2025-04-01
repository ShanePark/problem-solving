package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2140SolvingQuestionsWithBrainpower2 {

    @Test
    public void test() {
        assertThat(mostPoints(Ps.intArray("[[3,2],[4,3],[4,4],[2,5]]"))).isEqualTo(5);
        assertThat(mostPoints(Ps.intArray("[[1,1],[2,2],[3,3],[4,4],[5,5]]"))).isEqualTo(7);
    }

    @Test
    public void fail() {
        assertThat(mostPoints(Ps.intArray("[[21,2],[1,2],[12,5],[7,2],[35,3],[32,2],[80,2],[91,5],[92,3],[27,3],[19,1],[37,3],[85,2],[33,4],[25,1],[91,4],[44,3],[93,3],[65,4],[82,3],[85,5],[81,3],[29,2],[25,1],[74,2],[58,1],[85,1],[84,2],[27,2],[47,5],[48,4],[3,2],[44,3],[60,5],[19,2],[9,4],[29,5],[15,3],[1,3],[60,2],[63,3],[79,3],[19,1],[7,1],[35,1],[55,4],[1,4],[41,1],[58,5]]")))
                .isEqualTo(781);
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        long answer = 0;
        for (int i = 0; i < questions.length; i++) {
            dp[i] = Math.max(dp[i], i == 0 ? 0 : dp[i - 1]);
            int score = questions[i][0];
            int brainPower = questions[i][1];
            answer = Math.max(answer, dp[i] + score);
            if (i + brainPower + 1 < dp.length) {
                dp[i + brainPower + 1] = Math.max(dp[i + brainPower + 1], dp[i] + score);
            }
        }
        return answer;
    }

}
