package shane.programmers.lv2c;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 비밀_코드_해독 {

    @Test
    public void test() {
        assertThat(solution(10, Ps.intArray("[[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [3, 7, 8, 9, 10], [2, 5, 7, 9, 10], [3, 4, 5, 6, 7]]"), new int[]{2, 3, 4, 3, 3})).isEqualTo(3);
        assertThat(solution(15, Ps.intArray("[[2, 3, 9, 12, 13], [1, 4, 6, 7, 9], [1, 2, 8, 10, 12], [6, 7, 11, 13, 15], [1, 4, 10, 11, 14]]"), new int[]{2, 1, 3, 0, 1})).isEqualTo(5);
    }

    public int solution(int n, int[][] q, int[] ans) {
        return dfs(new boolean[n + 1], q, ans, q[0].length, 1);
    }

    private int dfs(boolean[] include, int[][] q, int[] ans, int length, int start) {
        if (length == 0) {
            for (int i = 0; i < q.length; i++) {
                int sum = ans[i];
                for (int j : q[i]) {
                    if (include[j])
                        sum--;
                }
                if (sum != 0)
                    return 0;
            }
            return 1;
        }
        int answer = 0;
        for (int i = start; i < include.length; i++) {
            include[i] = true;
            answer += dfs(include, q, ans, length - 1, i + 1);
            include[i] = false;
        }
        return answer;
    }

}
