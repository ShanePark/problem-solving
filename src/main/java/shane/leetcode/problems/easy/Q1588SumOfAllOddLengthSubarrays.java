package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1588SumOfAllOddLengthSubarrays {

    @Test
    void test() {
        Assertions.assertThat(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3})).isEqualTo(58);
        Assertions.assertThat(sumOddLengthSubarrays(new int[]{1, 2})).isEqualTo(3);
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j < arr.length - i + 1; j++) {
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }
}
