package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2089FindTargetIndicesAfterSortingArray {

    @Test
    public void test() {
        int[] arr = {1, 2, 5, 2, 3};
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        assertThat(targetIndices(arr, 2)).containsExactly(1, 2);
        assertThat(arr).containsExactly(copy);
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= target; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list;
    }
}
