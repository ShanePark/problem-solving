package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 23ms Beats 45.48%of users with Java
 * Memory Details 44.08MB Beats 40.48%of users with Java
 */
public class Q646MaximumLengthOfPairChain {

    @Test
    public void test() {
        assertThat(findLongestChain(Ps.intArray("[[-10,-8],[8,9],[-5,0],[6,10],[-6,-4],[1,7],[9,10],[-4,7]]"))).isEqualTo(4);
        assertThat(findLongestChain(Ps.intArray("[[1,10],[2,3],[4,5]]"))).isEqualTo(2);
        assertThat(findLongestChain(Ps.intArray("[[1,2],[1,3],[3,4]]"))).isEqualTo(2);
        assertThat(findLongestChain(Ps.intArray("[[1,2],[7,8],[4,5]]"))).isEqualTo(3);
        assertThat(findLongestChain(Ps.intArray("[[1,2],[2,3],[3,4]]"))).isEqualTo(2);
    }

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int max = 0;
        map.put(0, Integer.MIN_VALUE);
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            for (int i = 0; i <= max; i++) {
                Integer endBefore = map.get(i);
                if (endBefore < start) {
                    Integer nextBefore = map.getOrDefault(i + 1, Integer.MAX_VALUE);
                    if (end < nextBefore) {
                        map.put(i + 1, end);
                        max = Math.max(max, i + 1);
                    }
                }
            }
        }
        return max;
    }

}
