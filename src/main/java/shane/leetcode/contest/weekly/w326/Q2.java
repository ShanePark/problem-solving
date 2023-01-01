package shane.leetcode.contest.weekly.w326;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(distinctPrimeFactors(new int[]{2, 4, 3, 7, 10, 6})).isEqualTo(4);
        assertThat(distinctPrimeFactors(new int[]{2, 4, 8, 16})).isEqualTo(1);
        assertThat(distinctPrimeFactors(new int[]{1})).isEqualTo(0);
        assertThat(distinctPrimeFactors(new int[]{2})).isEqualTo(1);
        assertThat(distinctPrimeFactors(new int[]{6})).isEqualTo(2);
        assertThat(distinctPrimeFactors(new int[]{17, 2})).isEqualTo(2);

    }

    @Test
    public void test2() {
        int[] arr = new int[10000];
        Arrays.fill(arr, 1000);
        assertThat(distinctPrimeFactors(arr)).isEqualTo(2);
    }

    public int distinctPrimeFactors(int[] nums) {
        long mul = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            mul *= num;
            for (int i = 2; i <= mul; i++) {
                if (mul % i == 0) {
                    while (mul % i == 0) {
                        mul /= i;
                    }
                    set.add(i);
                }
            }
        }

        return set.size();
    }

}
