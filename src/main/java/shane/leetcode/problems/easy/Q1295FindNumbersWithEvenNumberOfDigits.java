package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1295FindNumbersWithEvenNumberOfDigits {

    @Test
    public void test() {
        assertThat(findNumbers(new int[]{12, 345, 2, 6, 7896, 100})).isEqualTo(2);
    }

    public int findNumbers(int[] nums) {
        int cnt = 0;
        for (int num : nums) {
            if ((int) Math.log10(num) % 2 == 1)
                cnt++;
        }
        return cnt;
    }
}
