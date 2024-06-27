package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 0msBeats100.00%
 */
public class Q1791FindCenterOfStarGraph2 {

    @Test
    void test() {
        Assertions.assertThat(findCenter(Ps.intArray("[[1,2],[2,3],[4,2]]"))).isEqualTo(2);
        Assertions.assertThat(findCenter(Ps.intArray("[[1,2],[5,1],[1,3],[1,4]]"))).isEqualTo(1);
    }

    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        for (int[] edge : edges) {
            int edge1 = edge[0];
            if (!set.add(edge1)) {
                return edge1;
            }
            int edge2 = edge[1];
            if (!set.add(edge2)) {
                return edge2;
            }
        }
        return -1;
    }

}
