package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q974SubarraySumsDivisibleByK {


    @Test
    public void test() {
        assertThat(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5)).isEqualTo(7);
        assertThat(subarraysDivByK(new int[]{5}, 9)).isEqualTo(0);
    }

    /**
     * 3sec 32ms
     */
    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(subarraysDivByK(arr, 1)).isEqualTo(450015000);
    }

    public int subarraysDivByK(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int num : nums) {
            for (int i = 0; i < list.size(); i++) {
                int next = list.get(i) + num;
                if (next % k == 0) {
                    sum++;
                }
                list.set(i, next);
            }
            if (num % k == 0) {
                sum++;
            }
            list.add(num);
        }
        return sum;
    }
}
