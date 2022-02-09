package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("DuplicatedCode")
public class Q532KdiffPairsinanArray2 {

    @Test
    void test() {
        Assertions.assertThat(findPairs(new int[]{3, 1, 4, 1, 5}, 2)).isEqualTo(2);
        Assertions.assertThat(findPairs(new int[]{1, 2, 3, 4, 5}, 1)).isEqualTo(4);
        Assertions.assertThat(findPairs(new int[]{1, 3, 1, 5, 4}, 0)).isEqualTo(1);
        Assertions.assertThat(findPairs(new int[]{1, 2, 4, 4, 3, 3, 0, 9, 2, 3}, 3)).isEqualTo(2);
    }

    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        if (k == 0) {
            for (Integer i : map.keySet()) {
                if (map.get(i) > 1)
                    cnt++;
            }
        } else {
            for (Integer i : map.keySet()) {
                if (map.containsKey(i + k)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
