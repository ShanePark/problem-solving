package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 245ms Beats 32.56%of users with Java
 * Memory Details 202.01MB Beats 5.81%of users with Java
 */
public class Q446ArithmeticSlicesIISubsequence3 {

    @Test
    public void test() {
        assertThat(numberOfArithmeticSlices(new int[]{0, 2000000000, -294967296})).isEqualTo(0);
        assertThat(numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10})).isEqualTo(7);
        assertThat(numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7})).isEqualTo(16);
    }

    @Test
    public void tle() {
        int[] arr = new int[30];
        Arrays.fill(arr, 1);
        assertThat(numberOfArithmeticSlices(arr)).isEqualTo(1_073_741_358);
    }

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Map<Integer, Integer>>[] dp = new HashMap[nums.length];

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) cur - nums[j];
                Map<Integer, Integer> curLengths = dp[i].get(diff);
                if (curLengths == null) {
                    curLengths = new HashMap<>();
                    dp[i].put(diff, curLengths);
                }
                curLengths.merge(2, 1, Integer::sum);
                Map<Integer, Integer> beforeLengths = dp[j].get(diff);
                if (beforeLengths == null)
                    continue;
                for (Map.Entry<Integer, Integer> e : beforeLengths.entrySet()) {
                    int length = e.getKey() + 1;
                    int cnt = e.getValue();
                    curLengths.merge(length, cnt, Integer::sum);
                    if (length >= 3) {
                        answer += cnt;
                    }
                }
            }
        }

        return answer;
    }

}
