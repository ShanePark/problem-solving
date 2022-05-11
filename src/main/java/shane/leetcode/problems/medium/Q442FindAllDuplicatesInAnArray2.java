package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q442FindAllDuplicatesInAnArray2 {

    @Test
    public void test() {
        assertThat(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})).containsExactly(2, 3);
        assertThat(findDuplicates(new int[]{1, 1, 2})).containsExactly(1);
        assertThat(findDuplicates(new int[]{1})).containsExactly();
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                list.add(index + 1);
            }
            nums[index] *= -1;
        }
        return list;
    }
}
