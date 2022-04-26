package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q31NextPermutation {

    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        assertThat(arr).containsExactly(1, 3, 2);

        int[] arr2 = new int[]{3, 2, 1};
        nextPermutation(arr2);
        assertThat(arr2).containsExactly(1, 2, 3);

        int[] arr3 = new int[]{1, 1, 5};
        nextPermutation(arr3);
        assertThat(arr3).containsExactly(1, 5, 1);

        int[] arr4 = new int[]{2, 3, 1};
        nextPermutation(arr4);
        assertThat(arr4).containsExactly(3, 1, 2);
    }

    public void nextPermutation(int[] nums) {
        nextPermutation(nums, 0, nums.length - 1);
    }

    private void nextPermutation(int[] nums, int from, int to) {
        if (isSortedReverse(nums, from, to)) {
            Arrays.sort(nums, from, to + 1);
            return;
        }

        if (from + 1 == to) {
            swap(nums, from, to);
            return;
        }

        if (isSortedReverse(nums, from + 1, to)) {
            // put next number on the from index
            int nextNumber = Integer.MAX_VALUE;
            int indexdNumber = nums[from];
            List<Integer> list = new ArrayList<>();
            list.add(indexdNumber);
            for (int i = from + 1; i <= to; i++) {
                if (nums[i] > indexdNumber) {
                    nextNumber = Math.min(nums[i], nextNumber);
                }
                list.add(nums[i]);
            }
            // then sort other numbers
            nums[from] = nextNumber;
            list.remove(Integer.valueOf(nextNumber));
            Collections.sort(list);
            for (int i = from + 1, j = 0; i <= to; i++, j++) {
                nums[i] = list.get(j);
            }

        } else {
            nextPermutation(nums, from + 1, to);
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private boolean isSortedReverse(int[] arr, int from, int to) {
        for (int i = from; i < to; i++) {
            if (arr[i] < arr[i + 1])
                return false;
        }
        return true;
    }
}
