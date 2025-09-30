package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 327ms
 * Beats5.03%
 */
public class Q2221FindTriangularSumOfAnArray2 {

    @Test
    public void test() {
        assertThat(triangularSum(new int[]{1, 2, 3, 4, 5})).isEqualTo(8);
        assertThat(triangularSum(new int[]{5})).isEqualTo(5);
    }

    public int triangularSum(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        while (list.size() > 1) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < list.size() - 1; i++) {
                next.add((list.get(i) + list.get(i + 1)) % 10);
            }
            list = next;
        }
        return list.get(0);
    }

}
