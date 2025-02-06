package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 324ms
 * Beats21.79%
 */
public class Q1726TupleWithSameProduct {

    @Test
    public void test() {
        assertThat(tupleSameProduct(new int[]{1, 2, 4, 5, 10, 20})).isEqualTo(40);
        assertThat(tupleSameProduct(new int[]{2, 3, 4, 6})).isEqualTo(8);
        assertThat(tupleSameProduct(new int[]{1, 2, 4, 5, 10})).isEqualTo(16);
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, List<int[]>> products = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                List<int[]> list = products.getOrDefault(nums[i] * nums[j], new ArrayList<>());
                products.put(nums[i] * nums[j], list);
                list.add(new int[]{nums[i], nums[j]});
            }
        }
        int answer = 0;
        for (Map.Entry<Integer, List<int[]>> e : products.entrySet()) {
            int size = e.getValue().size();
            answer += size * (size - 1);
        }
        return answer * 4;
    }

}
