package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1979FindGreatestCommonDivisorOfArray {

    @Test
    public void test() {
        assertThat(findGCD(new int[]{2, 5, 6, 9, 10})).isEqualTo(2);
        assertThat(findGCD(new int[]{7, 5, 6, 8, 3})).isEqualTo(1);
    }

    public int findGCD(int[] nums) {
        int max = 0;
        int min = 1000;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (max % i == 0 && min % i == 0)
                gcd = i;
        }
        return gcd;
    }
}
