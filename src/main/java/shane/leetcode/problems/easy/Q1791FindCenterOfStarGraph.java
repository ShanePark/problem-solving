package shane.leetcode.problems.easy;

import com.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q1791FindCenterOfStarGraph {

    @Test
    void test() {
        Assertions.assertThat(findCenter(Ps.intArray("[[1,2],[2,3],[4,2]]"))).isEqualTo(2);
        Assertions.assertThat(findCenter(Ps.intArray("[[1,2],[5,1],[1,3],[1,4]]"))).isEqualTo(1);
    }

    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        set.add(edges[0][0]);
        set.add(edges[0][1]);
        return set.add(edges[1][0]) ? edges[1][1] : edges[1][0];
    }

}
