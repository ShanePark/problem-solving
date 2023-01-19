package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2406 ms Beats 5.36%
 * Memory 46.4 MB Beats 83.7%
 */
public class Q974SubarraySumsDivisibleByK2 {


    @Test
    public void test() {
        assertThat(subarraysDivByK(new int[]{1, -10, 5}, 9)).isEqualTo(1);
        assertThat(subarraysDivByK(new int[]{5}, 9)).isEqualTo(0);
        assertThat(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)).isEqualTo(7);
    }

    /**
     * 54 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(subarraysDivByK(arr, 1)).isEqualTo(450015000);
    }

    /**
     * 566 ms
     */
    @Test
    public void tle2() {
        int[] arr = new int[10000];
        assertThat(subarraysDivByK(arr, 10000)).isEqualTo(50005000);
    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] mod = new int[k];
        int answer = 0;
        for (int num : nums) {
            int[] next = new int[k];
            if (num < 0)
                num = num % k + k;
            for (int i = 0; i < k; i++) {
                int nextMod = (i + num) % k;
                next[nextMod] += mod[i];
                if (nextMod == 0)
                    answer += next[nextMod];
            }
            if (num % k == 0)
                answer++;
            mod = next;
            mod[num % k]++;
        }
        return answer;
    }

}
