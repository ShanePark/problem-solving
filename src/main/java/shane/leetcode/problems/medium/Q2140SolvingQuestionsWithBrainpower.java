package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 9 ms Beats 55.56%
 * Memory 95.4 MB Beats 74.7%
 */
public class Q2140SolvingQuestionsWithBrainpower {

    @Test
    public void test() {
        assertThat(mostPoints(Ps.intArray("[[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]"))).isEqualTo(157);
        assertThat(mostPoints(Ps.intArray("[[3,2],[4,3],[4,4],[2,5]]"))).isEqualTo(5);
        assertThat(mostPoints(Ps.intArray("[[1,1],[2,2],[3,3],[4,4],[5,5]]"))).isEqualTo(7);
    }

    @Test
    void overflow() {
        int[][] arr = new int[100000][2];
        Arrays.fill(arr, new int[]{100000, 1});
        assertThat(mostPoints(arr)).isEqualTo(5000000000L);
    }

    public long mostPoints(int[][] questions) {

        long[] dp = new long[questions.length];
        long max = 0;
        for (int i = 0; i < questions.length; i++) {
            if (0 < i) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            long cur = dp[i];
            int[] question = questions[i];
            long nextScore = cur + question[0];
            max = Math.max(max, nextScore);
            if (i + question[1] + 1 < dp.length) {
                dp[i + question[1] + 1] = Math.max(dp[i + question[1] + 1], nextScore);
            }
        }
        return max;
    }

}
