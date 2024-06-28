package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime57msBeats21.62%
 */
public class Q2285MaximumTotalImportanceOfRoads {

    @Test
    public void test() {
        assertThat(maximumImportance(5, Ps.intArray("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]"))).isEqualTo(43);
        assertThat(maximumImportance(5, Ps.intArray("[[0,3],[2,4],[1,3]]"))).isEqualTo(20);
    }


    public long maximumImportance(int n, int[][] roads) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] road : roads) {
            cnt.merge(road[0], 1, Integer::sum);
            cnt.merge(road[1], 1, Integer::sum);
        }
        List<Integer> collect = cnt.values().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        long answer = 0;
        for (Integer i : collect) {
            answer += (long) i * n--;
        }
        return answer;
    }

}
