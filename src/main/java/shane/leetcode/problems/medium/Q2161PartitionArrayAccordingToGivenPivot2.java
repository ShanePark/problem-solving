package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime
 * 16
 * ms
 * Beats
 * 14.35%
 */
public class Q2161PartitionArrayAccordingToGivenPivot2 {

    @Test
    void test() {
        Assertions.assertThat(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)).containsExactly(9, 5, 3, 10, 10, 12, 14);
        Assertions.assertThat(pivotArray(new int[]{-3, 4, 3, 2}, 2)).containsExactly(-3, 2, 4, 3);
    }

    public int[] pivotArray(int[] nums, int pivot) {
        Queue<Integer> smaller = new LinkedList<>();
        Queue<Integer> larger = new LinkedList<>();
        int equal = 0;
        for (int num : nums) {
            if (num == pivot) {
                equal++;
                continue;
            }
            if (num < pivot) {
                smaller.add(num);
                continue;
            }
            larger.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!smaller.isEmpty()) {
                nums[i] = smaller.poll();
                continue;
            }
            if (equal > 0) {
                nums[i] = pivot;
                equal--;
                continue;
            }
            nums[i] = larger.poll();
        }
        return nums;
    }

}
