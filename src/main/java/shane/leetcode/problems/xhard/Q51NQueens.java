package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q51NQueens {

    @Test
    public void test() {
        assertThat(solveNQueens(4)).isEqualTo(Ps.strList("[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]"));
    }

    public List<List<String>> solveNQueens(int n) {
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(i == j ? "Q" : ".");
            }
            candidates.add(sb.toString());
        }

        List<List<String>> answer = new ArrayList<>();
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        dfs(candidates, n, arr, 0, answer);
        return answer;
    }

    private void dfs(List<String> candidates, int n, int[] arr, int index, List<List<String>> answer) {
        if (index == arr.length) {
            List<String> list = new ArrayList<>();
            for (int i : arr) {
                list.add(candidates.get(i));
            }
            answer.add(list);
            return;
        }

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = index - 1, k = 1; j >= 0; j--, k++) {
                if (arr[j] == i || arr[j] == i - k || arr[j] == i + k)
                    continue loop;
            }
            arr[index] = i;
            dfs(candidates, n, arr, index + 1, answer);
            arr[index] = -1;
        }
    }
}
