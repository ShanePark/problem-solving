package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime99msBeats33.15%
 */
public class Q2406DivideIntervalsIntoMinimumNumberOfGroups2 {

    @Test
    public void test() {
        assertThat(minGroups(Ps.intArray("[[5,10],[6,8],[1,5],[2,3],[1,10]]"))).isEqualTo(3);
        assertThat(minGroups(Ps.intArray("[[1,3],[5,6],[8,10],[11,13]]"))).isEqualTo(1);
    }

    public int minGroups(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] interval : intervals) {
            map.merge(interval[0], 1, Integer::sum);
            map.merge(interval[1] + 1, -1, Integer::sum);
        }

        int cur = 0;
        int max = 0;
        List<Integer> keys = map.keySet().stream().sorted().collect(Collectors.toList());
        for (Integer key : keys) {
            cur += map.get(key);
            max = Math.max(max, cur);
        }
        return max;
    }

}
