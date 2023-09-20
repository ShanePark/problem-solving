package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Time Limit Exceeded
 * 85 / 94 testcases passed
 */
public class Q1658MinimumOperationsToReduceXToZero4 {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365)).isEqualTo(16);
        assertThat(minOperations(new int[]{1, 1, 4, 2, 3}, 5)).isEqualTo(2);
        assertThat(minOperations(new int[]{5, 6, 7, 8, 9}, 4)).isEqualTo(-1);
        assertThat(minOperations(new int[]{3, 2, 20, 1, 1, 3}, 10)).isEqualTo(5);
    }

    /**
     * 5 sec 800 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[100000];
        Arrays.fill(arr, 10000);
        assertThat(minOperations(arr, (int) 1e9)).isEqualTo(100000);
    }


    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        int[] fromLeft = new int[length + 1];
        int[] fromRight = new int[length + 1];

        for (int i = 0; i < length; i++) {
            fromLeft[i + 1] = fromLeft[i] + nums[i];
            fromRight[i + 1] = fromRight[i] + nums[length - 1 - i];
        }

        if (fromLeft[length] < x)
            return -1;

        int min = length + 1;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; i + j <= length; j++) {
                if (min <= i + j)
                    break;
                if (fromLeft[i] + fromRight[j] == x) {
                    min = i + j;
                }
                if (fromLeft[i] + fromRight[j] > x)
                    break;
            }
        }

        return min > length ? -1 : min;
    }

}
