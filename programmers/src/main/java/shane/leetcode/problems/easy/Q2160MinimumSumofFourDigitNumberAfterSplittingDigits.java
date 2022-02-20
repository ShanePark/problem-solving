package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q2160MinimumSumofFourDigitNumberAfterSplittingDigits {

    @Test
    void test() {
        Assertions.assertThat(minimumSum(2932)).isEqualTo(52);
        Assertions.assertThat(minimumSum(4009)).isEqualTo(13);
        Assertions.assertThat(minimumSum(1000)).isEqualTo(1);
        Assertions.assertThat(minimumSum(9999)).isEqualTo(198);
    }

    public int minimumSum(int num) {
        int[] arr = new int[4];
        arr[0] = num / 1000;
        arr[1] = (num / 100) % 10;
        arr[2] = (num / 10) % 10;
        arr[3] = num % 10;
        Arrays.sort(arr);
        return (arr[0] + arr[1]) * 10 + arr[2] + arr[3];
    }
}
