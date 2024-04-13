package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q85MaximalRectangle {

    @Test
    public void test() {
        assertThat(maximalRectangle(Ps.charArray("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]"))).isEqualTo(6);
        assertThat(maximalRectangle(Ps.charArray("[[\"0\"]]"))).isEqualTo(0);
        assertThat(maximalRectangle(Ps.charArray("[[\"1\"]]"))).isEqualTo(1);
    }

    public int maximalRectangle(char[][] matrix) {
        int WIDTH = matrix[0].length;
        int[] dp = new int[WIDTH + 1];
        int max = 0;

        for (char[] row : matrix) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= WIDTH; i++) {
                if (i < WIDTH) {
                    dp[i] = (row[i] == '1') ? dp[i] + 1 : 0;
                }

                while (!stack.isEmpty() && dp[i] < dp[stack.peek()]) {
                    int pop = stack.pop();
                    max = Math.max(max, dp[pop] * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                }
                stack.push(i);
            }
        }
        return max;
    }

}
