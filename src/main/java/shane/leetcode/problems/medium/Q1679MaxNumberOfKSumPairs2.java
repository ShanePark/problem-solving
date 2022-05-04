package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1679MaxNumberOfKSumPairs2 {

    @Test
    public void test() {
        assertThat(maxOperations(new int[]{1, 2, 3, 4}, 5)).isEqualTo(2);
        assertThat(maxOperations(new int[]{3, 1, 3, 4, 3}, 6)).isEqualTo(1);
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(k - num) && map.get(k - num) > 0) {
                map.compute(k - num, (key, val) -> val - 1);
                count++;
            } else {
                map.merge(num, 1, Integer::sum);
            }
        }
        return count;
    }
}
