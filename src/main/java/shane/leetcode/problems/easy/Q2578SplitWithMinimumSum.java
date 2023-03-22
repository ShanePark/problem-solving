package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 92.37%
 * Memory 39.4 MB Beats 82.51%
 */
public class Q2578SplitWithMinimumSum {

    @Test
    void test() {
        assertThat(splitNum(4325)).isEqualTo(59);
        assertThat(splitNum(687)).isEqualTo(75);
    }

    public int splitNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        int sum = 0;
        int mul = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            sum += (chars[i--] - '0') * mul;
            if (0 <= i) {
                sum += (chars[i] - '0') * mul;
            }
            mul *= 10;
        }
        return sum;
    }

}
