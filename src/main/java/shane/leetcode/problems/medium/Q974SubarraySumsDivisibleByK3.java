package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q974SubarraySumsDivisibleByK3 {


    @Test
    public void test() {
        assertThat(subarraysDivByK(new int[]{1, -10, 5}, 9)).isEqualTo(1);
        assertThat(subarraysDivByK(new int[]{5}, 9)).isEqualTo(0);
        assertThat(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)).isEqualTo(7);
    }

    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(subarraysDivByK(arr, 1)).isEqualTo(450015000);
    }

    /**
     * 2 sec 778 ms
     */
    @Test
    public void tle2() {
        int[] arr = new int[10000];
        assertThat(subarraysDivByK(arr, 10000)).isEqualTo(50005000);
    }

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> mod = new HashMap<>();
        int answer = 0;
        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();
            if (num < 0)
                num = num % k + k;
            for (int i = 0; i < k; i++) {
                int nextMod = (i + num) % k;
                next.merge(nextMod, mod.getOrDefault(i, 0), Integer::sum);
                if (nextMod == 0)
                    answer += next.get(nextMod);
            }
            if (num % k == 0)
                answer++;
            mod = next;
            mod.merge(num % k, 1, Integer::sum);
        }
        return answer;
    }

}
