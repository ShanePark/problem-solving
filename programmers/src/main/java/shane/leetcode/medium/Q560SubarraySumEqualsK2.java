package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q560SubarraySumEqualsK2 {

    @Test
    void test() {
        Assertions.assertThat(subarraySum(new int[]{1, 1, 1,}, 2)).isEqualTo(2);
        Assertions.assertThat(subarraySum(new int[]{1, 2, 3,}, 3)).isEqualTo(2);
        Assertions.assertThat(subarraySum(new int[]{-1, -1, 1}, 0)).isEqualTo(1);
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            cnt += map.getOrDefault(sum - k, 0);
            map.merge(sum, 1, (i, j) -> i + j);
        }
        return cnt;
    }

}
