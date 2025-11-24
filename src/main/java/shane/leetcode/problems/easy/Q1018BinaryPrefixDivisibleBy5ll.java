package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1018BinaryPrefixDivisibleBy5ll {

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

    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int num = 0;
        for (int i : nums) {
            num <<= 1;
            num += i;
            num %= 5;
            list.add(num == 0);
        }
        return list;
    }

}
