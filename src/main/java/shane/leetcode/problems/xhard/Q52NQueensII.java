package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q52NQueensII {

    @Test
    public void test() {
        assertThat(totalNQueens(4)).isEqualTo(2);
        assertThat(totalNQueens(1)).isEqualTo(1);
    }

    int result;

    public int totalNQueens(int n) {
        result = 0;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        dfs(n, arr, 0);
        return result;
    }

    private void dfs(int n, int[] arr, int index) {
        if (index == arr.length) {
            result++;
            return;
        }

        loop:
        for (int i = 0; i < n; i++) {
            for (int j = index - 1, k = 1; j >= 0; j--, k++) {
                if (arr[j] == i || arr[j] == i - k || arr[j] == i + k)
                    continue loop;
            }
            arr[index] = i;
            dfs(n, arr, index + 1);
            arr[index] = -1;
        }
    }
}
