package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 22ms
 * Beats94.76%
 */
public class Q2966DivideArrayIntoArraysWithMaxDifference2 {

    @Test
    public void test() {
        assertThat(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)).isEqualTo(Ps.intArray("[[1,1,3],[3,4,5],[7,8,9]]"));
        assertThat(divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)).isEmpty();
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] answer = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int[] arr = answer[i / 3];
            int second = nums[++i];
            int third = nums[++i];
            if (k < third - first)
                return new int[][]{};
            arr[0] = first;
            arr[1] = second;
            arr[2] = third;
        }
        return answer;
    }

}
