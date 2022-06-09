package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q167TwoSumIIInputArrayIsSorted {

    @Test
    public void test() {
        assertThat(twoSum(new int[]{2, 7, 11, 15}, 9)).containsExactly(1, 2);
        assertThat(twoSum(new int[]{2, 3, 4}, 6)).containsExactly(1, 3);
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            Integer index = map.get(target - numbers[i]);
            if (index != null) {
                return new int[]{Math.min(i + 1, index + 1), Math.max(i + 1, index + 1)};
            }
        }
        return null;
    }
}
