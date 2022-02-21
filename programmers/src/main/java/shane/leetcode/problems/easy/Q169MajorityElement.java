package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q169MajorityElement {

    @Test
    void test() {
        Assertions.assertThat(majorityElement(new int[]{3, 2, 3})).isEqualTo(3);
        Assertions.assertThat(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
    }

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0) + 1;
            if (cnt > length / 2) {
                return num;
            }
            map.put(num, cnt);
        }
        return -1;
    }
}
