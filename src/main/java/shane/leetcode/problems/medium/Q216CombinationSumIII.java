package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q216CombinationSumIII {

    @Test
    public void test() {
        assertThat(combinationSum3(9, 45)).isEqualTo(Ps.intList("[[1,2,3,4,5,6,7,8,9]]"));
        assertThat(combinationSum3(3, 7)).isEqualTo(Ps.intList(" [[1,2,4]]"));
        assertThat(combinationSum3(3, 9)).isEqualTo(Ps.intList(" [[1,2,6],[1,3,5],[2,3,4]]"));
        assertThat(combinationSum3(4, 1)).isEmpty();
    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        boolean[] visited = new boolean[10];
        bt(visited, k, n, 1);
        return result;
    }

    private void bt(boolean[] visited, int left, int target, int i) {
        if (i > 9 || target <= 0 || left <= 0) {
            if (left == 0 && target == 0) {
                List<Integer> list = new ArrayList<>();
                for (int j = 1; j < 10; j++) {
                    if (visited[j])
                        list.add(j);
                }
                result.add(list);
            }
            return;
        }

        visited[i] = true;
        bt(visited, left - 1, target - i, i + 1);
        visited[i] = false;
        bt(visited, left, target, i + 1);
    }
}
