package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3623CountNumberOfTrapezoidsI {

    @Test
    public void test() {
        assertThat(countTrapezoids(Ps.intArray("[[1,0],[2,0],[3,0],[2,2],[3,2]]"))).isEqualTo(3);
        assertThat(countTrapezoids(Ps.intArray("[[0,0],[1,0],[0,1],[2,1]]"))).isEqualTo(1);
    }


    final int MOD = (int) 1e9 + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> yCount = new HashMap<>();
        for (int[] p : points) {
            yCount.merge(p[1], 1, Integer::sum);
        }

        List<Long> choose2List = new ArrayList<>();
        yCount.values().stream()
                .filter(i -> i > 1)
                .forEach(i -> choose2List.add((long) i * (i - 1) / 2));

        long answer = 0;
        long prefix = 0;
        for (long val : choose2List) {
            answer = (answer + prefix % MOD * (val % MOD)) % MOD;
            prefix = (prefix + val) % MOD;
        }

        return (int) answer;
    }


}
