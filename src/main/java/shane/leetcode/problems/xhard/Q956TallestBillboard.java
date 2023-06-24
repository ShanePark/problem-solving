package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q956TallestBillboard {

    @Test
    void test() {
        assertThat(tallestBillboard(new int[]{1, 2, 3, 6})).isEqualTo(6);
        assertThat(tallestBillboard(new int[]{1, 2, 3, 4, 5, 6})).isEqualTo(10);
        assertThat(tallestBillboard(new int[]{1, 2})).isEqualTo(0);
    }

    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for (int rod : rods) {
            Map<Integer, Integer> before = new HashMap<>(dp);
            for (int diff : before.keySet()) {
                int max = before.get(diff);
                dp.put(diff + rod, Math.max(max + rod, dp.getOrDefault(rod + diff, 0)));
                dp.put(diff - rod, Math.max(max, dp.getOrDefault(diff - rod, 0)));
            }
        }
        return dp.get(0);
    }

}
