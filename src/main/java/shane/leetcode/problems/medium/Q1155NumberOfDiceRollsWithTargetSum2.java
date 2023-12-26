package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime Details 74ms Beats 7.47%of users with Java
 * Memory Details 44.66MB Beats 8.54%of users with Java
 */
public class Q1155NumberOfDiceRollsWithTargetSum2 {

    @Test
    public void test() {
        assertThat(numRollsToTarget(1, 6, 3)).isEqualTo(1);
        assertThat(numRollsToTarget(2, 6, 7)).isEqualTo(6);
        assertThat(numRollsToTarget(30, 30, 500)).isEqualTo(222616187);
    }

    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = (int) 1e9 + 7;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (int j = 1; j <= k; j++) {
                for (Map.Entry<Integer, Integer> e : dp.entrySet()) {
                    Integer num = e.getKey();
                    Integer count = e.getValue();
                    nextDp.merge(num + j, count, (a, b) -> (a + b) % MOD);
                }
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }

}
