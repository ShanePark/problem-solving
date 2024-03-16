package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime 27 ms Beats 9.86% of users with Java
 */
public class Q525ContiguousArray3 {

    @Test
    void test() {
        Assertions.assertThat(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1})).isEqualTo(6);
        Assertions.assertThat(findMaxLength(new int[]{1, 1, 1, 0, 0, 0})).isEqualTo(6);
        Assertions.assertThat(findMaxLength(new int[]{0, 1})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 0})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{1, 1, 1})).isEqualTo(0);
        Assertions.assertThat(findMaxLength(new int[]{1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1}))
                .isEqualTo(94);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            map.put(sum, i);
        }
        int max = 0;
        sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.getOrDefault(sum, i - 1);
            max = Math.max(max, index - i + 1);
            sum += nums[i] == 1 ? 1 : -1;
        }
        return max;
    }

}
