package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 621 ms Beats 40.43% of users with Java
 */
public class Q2597TheNumberOfBeautifulSubsets {

    @Test
    public void test() {
        assertThat(beautifulSubsets(new int[]{2, 4, 6}, 2)).isEqualTo(4);
        assertThat(beautifulSubsets(new int[]{1}, 1)).isEqualTo(1);
    }

    int answer;

    public int beautifulSubsets(int[] nums, int k) {
        answer = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        dfs(cntMap, nums, k, 0);
        return answer;
    }

    private void dfs(Map<Integer, Integer> cntMap, int[] nums, int k, int i) {
        if (nums.length == i) {
            if (!cntMap.isEmpty()) {
                answer++;
            }
            return;
        }
        // skip
        dfs(cntMap, nums, k, i + 1);

        int cur = nums[i];
        // include
        if (!cntMap.containsKey(cur + k) && !cntMap.containsKey(cur - k)) {
            cntMap.merge(cur, 1, Integer::sum);
            dfs(cntMap, nums, k, i + 1);
            if (cntMap.merge(cur, -1, Integer::sum) == 0) {
                cntMap.remove(cur);
            }
        }
    }

}
