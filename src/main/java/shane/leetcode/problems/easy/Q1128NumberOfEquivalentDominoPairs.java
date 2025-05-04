package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 22
 * ms
 * Beats
 * 30.79%
 */
public class Q1128NumberOfEquivalentDominoPairs {

    @Test
    public void test() {
        assertThat(numEquivDominoPairs(Ps.intArray("[[1,2],[2,1],[3,4],[5,6]]"))).isEqualTo(1);
        assertThat(numEquivDominoPairs(Ps.intArray("[[1,2],[1,2],[1,1],[1,2],[2,2]]"))).isEqualTo(3);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int[] d : dominoes) {
            cnt.merge(Math.min(d[0], d[1]) + " " + Math.max(d[0], d[1]), 1, Integer::sum);
        }
        return cnt.values()
                .stream()
                .mapToInt(i -> i * (i - 1) / 2)
                .sum();
    }

}
