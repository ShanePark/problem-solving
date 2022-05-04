package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1679MaxNumberOfKSumPairs {

    @Test
    public void test() {
        assertThat(maxOperations(new int[]{1, 2, 3, 4}, 5)).isEqualTo(2);
        assertThat(maxOperations(new int[]{3, 1, 3, 4, 3}, 6)).isEqualTo(1);
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (key * 2 == k) {
                count += entry.getValue() / 2;
                entry.setValue(entry.getValue() - entry.getValue() / 2);
            } else {
                Integer pairCount = map.get(k - key);
                if (pairCount == null) {
                    continue;
                }
                int min = Math.min(map.get(key), pairCount);
                map.put(key, map.get(key) - min);
                map.put(k - key, pairCount - min);
                count += min;
            }
        }
        return count;
    }
}
