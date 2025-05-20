package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 127
 * ms
 * Beats
 * 5.24%
 */
public class Q3355ZeroArrayTransformationI {

    @Test
    public void test() {
        assertThat(isZeroArray(new int[]{1, 0, 1}, Ps.intArray("[[0,2]]"))).isTrue();
        assertThat(isZeroArray(new int[]{4, 3, 2, 1}, Ps.intArray("[[1,3],[0,2]]"))).isFalse();
        assertThat(isZeroArray(new int[]{2}, Ps.intArray("[[0,0],[0,0]]"))).isTrue();
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] query : queries) {
            map.merge(query[0], -1, Integer::sum);
            map.merge(query[1] + 1, 1, Integer::sum);
        }
        int curStatus = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!map.isEmpty() && map.firstKey() <= i) {
                Map.Entry<Integer, Integer> e = map.firstEntry();
                curStatus += e.getValue();
                map.remove(e.getKey());
            }
            if (0 < num + curStatus) {
                return false;
            }
        }
        return true;
    }

}
