package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 8
 * ms
 * Beats
 * 52.54%
 */
public class Q976LargestPerimeterTriangle2 {

    @Test
    public void test() {
        assertThat(largestPerimeter(new int[]{3, 2, 3, 4})).isEqualTo(10);
        assertThat(largestPerimeter(new int[]{2, 1, 2})).isEqualTo(5);
        assertThat(largestPerimeter(new int[]{1, 2, 1})).isEqualTo(0);
    }

    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            list.add(num);
            if (list.size() < 3)
                continue;
            int perimeter = formTriangle(list);
            if (perimeter > 0) {
                return perimeter;
            }
            list.remove(0);
        }
        return 0;
    }

    private int formTriangle(List<Integer> list) {
        if (list.get(0) >= list.get(1) + list.get(2)) {
            return 0;
        }
        return list.get(0) + list.get(1) + list.get(2);
    }

}
