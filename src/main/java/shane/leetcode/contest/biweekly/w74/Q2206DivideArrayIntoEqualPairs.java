package shane.leetcode.contest.biweekly.w74;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2206DivideArrayIntoEqualPairs {

    @Test
    void test() {
        assertThat(divideArray(new int[]{3, 2, 3, 2, 2, 2})).isEqualTo(true);
        assertThat(divideArray(new int[]{1, 2, 3, 4})).isEqualTo(false);
    }


    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer cnt = map.get(num);
            if (cnt == null) {
                map.put(num, 1);
            } else if (cnt == 1) {
                map.remove(num);
            } else {
                map.put(num, cnt - 1);
            }
        }
        return map.isEmpty();
    }

}
