package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 47ms Beats54.00% 
 */
public class Q494TargetSum {

    @Test
    public void test() {
        assertThat(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3)).isEqualTo(5);
        assertThat(findTargetSumWays(new int[]{1}, 1)).isEqualTo(1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> cntBefore = new HashMap<>();
        cntBefore.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : cntBefore.entrySet()) {
                cnt.merge(e.getKey() + num, e.getValue(), Integer::sum);
                cnt.merge(e.getKey() - num, e.getValue(), Integer::sum);
            }
            cntBefore = cnt;
        }
        return cntBefore.getOrDefault(target, 0);
    }

}
