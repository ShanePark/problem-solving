package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q2006CountNumberOfPairsWithAbsoluteDifferenceK2 {

    @Test
    void test() {
        Assertions.assertThat(countKDifference(new int[]{1, 2, 2, 1}, 1)).isEqualTo(4);
        Assertions.assertThat(countKDifference(new int[]{1, 3}, 3)).isEqualTo(0);
        Assertions.assertThat(countKDifference(new int[]{3, 2, 1, 5, 4}, 2)).isEqualTo(3);
    }

    public int countKDifference(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            cnt = cnt + map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0);
        }
        return cnt;
    }


}
