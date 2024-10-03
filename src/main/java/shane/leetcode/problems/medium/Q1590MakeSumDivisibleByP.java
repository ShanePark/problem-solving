package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1590MakeSumDivisibleByP {

    @Test
    public void test() {
        assertThat(minSubarray(new int[]{3, 1, 4, 2}, 6)).isEqualTo(1);
        assertThat(minSubarray(new int[]{6, 3, 5, 2}, 9)).isEqualTo(2);
        assertThat(minSubarray(new int[]{1, 2, 3}, 3)).isEqualTo(0);
        assertThat(minSubarray(new int[]{3}, 4)).isEqualTo(-1);
    }

    public int minSubarray(int[] nums, int p) {
        int mod = 0;
        for (int num : nums) {
            mod = (mod + num) % p;
        }
        if (mod == 0)
            return 0;

        Map<Integer, Integer> modIndexMap = new HashMap<>();
        modIndexMap.put(0, -1);
        int min = nums.length;
        int sumMod = 0;

        for (int i = 0; i < nums.length; i++) {
            sumMod = (sumMod + nums[i]) % p;
            int need = (sumMod + p - mod) % p;
            if (modIndexMap.containsKey(need)) {
                min = Math.min(min, i - modIndexMap.get(need));
            }
            modIndexMap.put(sumMod, i);
        }

        return min < nums.length ? min : -1;
    }

}
