package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
public class Q525ContiguousArray2 {

    @Test
    void test() {
        Assertions.assertThat(findMaxLength(new int[]{0, 1})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 0})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1})).isEqualTo(6);
        Assertions.assertThat(findMaxLength(new int[]{1, 1, 1})).isEqualTo(0);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 1})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0})).isEqualTo(4);
        Assertions.assertThat(findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 1, 0})).isEqualTo(2);
        Assertions.assertThat(findMaxLength(new int[]{0, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1})).isEqualTo(54);
    }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;

    }

}
