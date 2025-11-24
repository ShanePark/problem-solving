package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1018BinaryPrefixDivisibleBy5 {

    @Test
    public void test() {
        assertThat(prefixesDivBy5(new int[]{0, 1, 1})).containsExactly(true, false, false);
        assertThat(prefixesDivBy5(new int[]{1, 1, 1})).containsExactly(false, false, false);
        assertThat(prefixesDivBy5(new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1})).containsExactly(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true, true, true, false);
        assertThat(prefixesDivBy5(new int[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0})).containsExactly(false, false, true, false, false, false, false, false, false, false, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, true, false, false, true, false, false, true, true, true, true, true, true, true, false, false, true, false, false, false, false, true, true);
    }

    @Test
    public void tle() {
        int SIZE = 100000;
        int[] arr = new int[SIZE];
        Arrays.fill(arr, 1);
        assertThat(prefixesDivBy5(arr)).hasSize(SIZE);
    }

    final BigDecimal TWO = BigDecimal.valueOf(2);

    public List<Boolean> prefixesDivBy5(int[] nums) {
        BigDecimal num = new BigDecimal(0);
        List<Boolean> list = new ArrayList<>();
        for (int i : nums) {
            num = num.multiply(TWO);
            if (i == 1) {
                num = num.add(BigDecimal.ONE);
            }
            list.add(num.divideAndRemainder(BigDecimal.valueOf(5))[1].equals(BigDecimal.ZERO));
        }
        return list;
    }

}
