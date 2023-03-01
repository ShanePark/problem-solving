package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static io.github.shanepark.Ps.strList;
import static org.assertj.core.api.Assertions.assertThat;

public class Q399EvaluateDivision {

    @Test
    public void test() {
        assertThat(calcEquation(
                strList("[[\"a\",\"b\"],[\"b\",\"c\"]]"),
                new double[]{2.0, 3.0},
                strList("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]"))).containsExactly(6.00000, 0.50000, -1.00000, 1.00000, -1.00000);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        final int LENGTH = equations.size();

        for (int i = 0; i < LENGTH; i++) {
            String str1 = equations.get(i).get(0);
            String str2 = equations.get(i).get(1);
            map.putIfAbsent(str1, new HashMap<>());
            map.putIfAbsent(str2, new HashMap<>());

            map.get(str1).put(str2, values[i]);
            map.get(str2).put(str1, 1 / values[i]);
        }

        final int SIZE = queries.size();
        double[] answer = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            answer[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), map);
        }
        return answer;
    }

    private double dfs(String str1, String str2, Set<String> visited, Map<String, Map<String, Double>> map) {
        if (!map.containsKey(str1)) {
            return -1;
        }

        if (map.get(str1).containsKey(str2)) {
            return map.get(str1).get(str2);
        }

        visited.add(str1);
        for (Map.Entry<String, Double> entry : map.get(str1).entrySet()) {
            if (visited.contains(entry.getKey()))
                continue;
            double dfs = dfs(entry.getKey(), str2, visited, map);
            if (dfs != -1)
                return entry.getValue() * dfs;
        }
        return -1;
    }

}
