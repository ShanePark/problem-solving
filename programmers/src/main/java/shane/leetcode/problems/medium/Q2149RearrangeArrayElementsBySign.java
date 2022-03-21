package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2149RearrangeArrayElementsBySign {

    @Test
    void test() {
        Assertions.assertThat(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})).containsExactly(3, -2, 1, -5, 2, -4);
    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> minus = new ArrayList<>();
        List<Integer> plus = new ArrayList<>();
        for (int num : nums) {
            if (num < 0) {
                minus.add(num);
            } else {
                plus.add(num);
            }
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = plus.get(i);
            nums[2 * i + 1] = minus.get(i);
        }
        return nums;
    }
}
