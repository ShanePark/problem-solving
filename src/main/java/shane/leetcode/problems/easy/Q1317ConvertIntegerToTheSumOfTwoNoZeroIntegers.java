package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    @Test
    public void test() {
        for (int i = 2; i <= 10000; i++) {
            test(i);
        }
    }

    void test(int n) {
        int[] a = getNoZeroIntegers(n);
        assertThat(Arrays.stream(a).sum()).isEqualTo(n);
        assertThat(a).hasSize(2);
        for (int i : a) {
            assertThat(String.valueOf(i).indexOf('0')).isEqualTo(-1);
        }
    }

    public int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - 1;
        while (String.valueOf(a).indexOf('0') >= 0 || String.valueOf(b).indexOf('0') >= 0) {
            a++;
            b--;
        }
        return new int[]{a, b};
    }

}
