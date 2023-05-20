package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static io.github.shanepark.Ps.strList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 90.67%
 * Memory 41.4 MB Beats 44%
 */
public class Q399EvaluateDivision2 {

    @Test
    public void test() {
        assertThat(calcEquation(
                strList("[[\"a\",\"b\"],[\"b\",\"c\"]]"),
                new double[]{2.0, 3.0},
                strList("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]"))).containsExactly(6.00000, 0.50000, -1.00000, 1.00000, -1.00000);
        assertThat(calcEquation(
                strList("[[\"a\",\"b\"],[\"b\",\"c\"],[\"bc\",\"cd\"]]"),
                new double[]{1.5, 2.5, 5.0},
                strList("[[\"a\",\"c\"],[\"c\",\"b\"],[\"bc\",\"cd\"],[\"cd\",\"bc\"]]"))).containsExactly(3.75000, 0.40000, 5.00000, 0.20000);
        assertThat(calcEquation(
                strList("[[\"a\",\"b\"]]"),
                new double[]{0.5},
                strList("[[\"a\",\"b\"],[\"b\",\"a\"],[\"a\",\"c\"],[\"x\",\"y\"]]"))).containsExactly(0.50000, 2.00000, -1.00000, -1.00000);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = values.length;
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<String> equation = equations.get(i);
            double value = values[i];
            String first = equation.get(0);
            String second = equation.get(1);
            map.computeIfAbsent(first, s -> new HashMap<>());
            map.computeIfAbsent(second, s -> new HashMap<>());

            map.get(first).put(second, value);
            map.get(second).put(first, 1 / value);
        }

        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String first = query.get(0);
            String second = query.get(1);
            Double calc = calc(map, first, second, new HashSet<>());
            answer[i] = calc == null ? -1d : calc;
        }
        return answer;
    }

    private Double calc(Map<String, Map<String, Double>> map, String first, String second, Set<String> visited) {
        visited.add(first);
        Map<String, Double> firstMap = map.get(first);
        if (firstMap == null)
            return null;
        if (firstMap.containsKey(second))
            return firstMap.get(second);
        for (Map.Entry<String, Double> entry : firstMap.entrySet()) {
            String next = entry.getKey();
            if (visited.contains(next))
                continue;
            Double nextResult = calc(map, next, second, visited);
            if (nextResult != null) {
                return nextResult * entry.getValue();
            }
        }
        return null;
    }

}
