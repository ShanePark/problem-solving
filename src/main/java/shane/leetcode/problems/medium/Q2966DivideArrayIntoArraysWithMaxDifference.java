package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 24 ms Beats 68.69% of users with Java
 */
public class Q2966DivideArrayIntoArraysWithMaxDifference {

    @Test
    public void test() {
        assertThat(divideArray(new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1}, 2)).isEqualTo(Ps.intArray("[[1,1,3],[3,4,5],[7,8,9]]"));
        assertThat(divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)).isEmpty();
    }

    final int[][] IMPOSSIBLE = new int[][]{};

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] answer = new int[nums.length / 3][3];

        int row = 0;
        int col = 0;
        int min = 0;

        for (int num : nums) {
            if (col == 3) {
                row++;
                col = 0;
            }
            if (col == 0) {
                answer[row][col++] = num;
                min = num;
                continue;
            }
            if (min + k < num)
                return IMPOSSIBLE;
            answer[row][col++] = num;
        }

        return answer;
    }

}
