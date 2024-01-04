package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 23ms Beats 41.51%of users with Java
 * Memory Details 61.56MB Beats 21.89%of users with Java
 */
public class Q2870MinimumNumberOfOperationsToMakeArrayEmpty {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4})).isEqualTo(4);
        assertThat(minOperations(new int[]{2, 1, 2, 2, 3, 3})).isEqualTo(-1);
    }

    public int minOperations(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge(num, 1, Integer::sum);
        }
        int sum = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(2, 1);
        dp.put(4, 2);
        for (Integer i : cnt.values()) {
            if (i == 1)
                return -1;
            sum += calc(i, dp);
        }
        return sum;
    }

    private int calc(int i, Map<Integer, Integer> dp) {
        if (dp.containsKey(i))
            return dp.get(i);
        int answer = -1;
        if (i % 3 == 0) {
            answer = i / 3;
        } else if (i % 3 == 1) {
            answer = 1 + calc(i - 3, dp);
        } else if (i % 3 == 2) {
            answer = i / 3 + 1;
        }
        dp.put(i, answer);
        return answer;
    }

}
