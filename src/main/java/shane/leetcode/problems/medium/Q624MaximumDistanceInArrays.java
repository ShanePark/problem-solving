package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime6msBeats94.09%
 */
public class Q624MaximumDistanceInArrays {

    @Test
    public void test() {
        assertThat(maxDistance(Ps.intList("[[1,2,3,5],[2,3]]"))).isEqualTo(3);
        assertThat(maxDistance(Ps.intList("[[1,2,3],[4,5],[1,2,3]]"))).isEqualTo(4);
        assertThat(maxDistance(Ps.intList("[[1],[1]]"))).isEqualTo(0);
    }

    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> firstList = arrays.remove(0);
        int min = firstList.get(0);
        int max = firstList.get(firstList.size() - 1);
        int maxDistance = 0;
        for (List<Integer> array : arrays) {
            int curMin = array.get(0);
            int curMax = array.get(array.size() - 1);
            maxDistance = Math.max(maxDistance, curMax - min);
            maxDistance = Math.max(maxDistance, max - curMin);
            min = Math.min(min, curMin);
            max = Math.max(max, curMax);
        }
        return maxDistance;
    }

}
