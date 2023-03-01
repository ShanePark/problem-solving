package shane.programmers.pccp.mock01;

import io.github.shanepark.Ps;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2_2 {

    @org.junit.jupiter.api.Test
    public void test() {
        assertThat(solution(Ps.intArray("[[40, 10, 10], [20, 5, 0], [30, 30, 30], [70, 0, 70], [100, 100, 100]]"))).isEqualTo(210);
        assertThat(solution(Ps.intArray("[[20, 30], [30, 20], [20, 30]]"))).isEqualTo(60);
    }

    int max;

    public int solution(int[][] ability) {
        int people = ability.length;
        max = 0;
        boolean[] visited = new boolean[people];
        dfs(ability, 0, 0, visited);
        return max;
    }

    private void dfs(int[][] ability, int subject, int sum, boolean[] visited) {
        if (subject == ability[0].length) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!visited[i]) {
                int score = ability[i][subject];
                visited[i] = true;
                dfs(ability, subject + 1, sum + score, visited);
                visited[i] = false;
            }
        }
    }

}
