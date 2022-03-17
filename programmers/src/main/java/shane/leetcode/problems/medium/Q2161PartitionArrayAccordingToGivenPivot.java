package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2161PartitionArrayAccordingToGivenPivot {

    @Test
    void test() {
        Assertions.assertThat(pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10)).containsExactly(9, 5, 3, 10, 10, 12, 14);
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        int index = 0;
        int pivotCount = 0;
        List<Integer> bigger = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                answer[index++] = num;
            } else if (num == pivot) {
                pivotCount++;
            } else {
                bigger.add(num);
            }
        }
        for (int i = 0; i < pivotCount; i++) {
            answer[index++] = pivot;
        }

        for (Integer integer : bigger) {
            answer[index++] = integer;
        }

        return answer;
    }

}
