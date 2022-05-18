package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1192CriticalConnectionsInANetwork2 {

    @Test
    public void test() {
        assertThat(criticalConnections(6, STool.convertToIntList("[[0,1],[1,2],[2,0],[1,3],[3,4],[4,5],[5,3]]"))).isEqualTo(STool.convertToIntList("[[1,3]]"));
        assertThat(criticalConnections(5, STool.convertToIntList("[[1,0],[2,0],[3,2],[4,2],[4,3],[3,0],[4,0]]"))).isEqualTo(STool.convertToIntList("[[0,1]]"));
        assertThat(criticalConnections(4, STool.convertToIntList("[[0,1],[1,2],[2,0],[1,3]]"))).isEqualTo(STool.convertToIntList("[[1,3]]"));
        assertThat(criticalConnections(2, STool.convertToIntList("[[0,1]]"))).isEqualTo(STool.convertToIntList("[[0,1]]"));
    }

    int time;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        time = 1;

        // transform to parent-children shape
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (List<Integer> connection : connections) {
            list.get(connection.get(0)).add(connection.get(1));
            list.get(connection.get(1)).add(connection.get(0));
        }

        ArrayList<List<Integer>> answer = new ArrayList<>();
        dfs(list, new int[n], 0, -1, answer);
        return answer;
    }

    private int dfs(List<List<Integer>> connections, int[] times, int i, int parent, ArrayList<List<Integer>> answer) {
        if (times[i] != 0)
            return times[i];
        times[i] = time++;

        int min = Integer.MAX_VALUE;
        for (Integer next : connections.get(i)) {
            // skip current connection
            if (next == parent) continue;
            min = Math.min(min, dfs(connections, times, next, i, answer));
        }

        if (min >= times[i]) {
            if (parent >= 0)
                answer.add(List.of(parent, i));
            return times[i];
        }

        return min;
    }
}
