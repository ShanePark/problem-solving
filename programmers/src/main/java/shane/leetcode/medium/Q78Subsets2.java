package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("ALL")
public class Q78Subsets2 {

    @Test
    void test() {
        Assertions.assertThat(subsets(new int[]{1, 2, 3})).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{1, 2, 3}),
                Arrays.asList(new Integer[]{2, 3}),
                Arrays.asList(new Integer[]{1, 3}),
                Arrays.asList(new Integer[]{3}),
                Arrays.asList(new Integer[]{1, 2}),
                Arrays.asList(new Integer[]{2}),
                Arrays.asList(new Integer[]{1}),
                Arrays.asList(new Integer[]{})
        );

        Assertions.assertThat(subsets(new int[]{0})).containsExactlyInAnyOrder(
                Arrays.asList(new Integer[]{0}),
                Arrays.asList(new Integer[]{})
        );

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        process(list, new Stack<>(), nums, 0);
        return list;
    }

    private void process(List<List<Integer>> list, Stack<Integer> temp, int[] nums, int cur) {
        list.add(new ArrayList<>(temp));
        for (int i = cur; i < nums.length; i++) {
            temp.push(nums[i]);
            process(list, temp, nums, i + 1);
            temp.pop();
        }
    }

}
