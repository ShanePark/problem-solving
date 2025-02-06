package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 187ms
 * Beats81.41%
 */
public class Q1726TupleWithSameProduct2 {

    @Test
    public void test() {
        assertThat(tupleSameProduct(new int[]{1, 2, 4, 5, 10, 20})).isEqualTo(40);
        assertThat(tupleSameProduct(new int[]{2, 3, 4, 6})).isEqualTo(8);
        assertThat(tupleSameProduct(new int[]{1, 2, 4, 5, 10})).isEqualTo(16);
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productsCnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                productsCnt.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int answer = 0;
        for (int cnt : productsCnt.values()) {
            answer += cnt * (cnt - 1);
        }
        return answer * 4;
    }

}
