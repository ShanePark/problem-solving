package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q974SubarraySumsDivisibleByK5 {

    @Test
    public void test() {
        assertThat(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)).isEqualTo(7);
        assertThat(subarraysDivByK(new int[]{1, -10, 5}, 9)).isEqualTo(1);
        assertThat(subarraysDivByK(new int[]{5}, 9)).isEqualTo(0);
    }

    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(subarraysDivByK(arr, 1)).isEqualTo(450015000);
    }

    @Test
    public void tle2() {
        int[] arr = new int[10000];
        assertThat(subarraysDivByK(arr, 10000)).isEqualTo(50005000);
    }

    public int subarraysDivByK(int[] nums, int k) {
        int[] mod = new int[k];
        mod[0] = 1;
        int answer = 0;
        int delimiter = 0;
        for (int a : nums) {
            delimiter = (delimiter + a) % k;
            if (delimiter < 0) {
                delimiter += k;
            }
            answer += mod[delimiter];
            mod[delimiter]++;
        }
        return answer;
    }

}
