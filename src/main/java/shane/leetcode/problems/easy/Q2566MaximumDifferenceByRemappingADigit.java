package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4
 * ms
 * Beats
 * 18.18%
 */
public class Q2566MaximumDifferenceByRemappingADigit {

    @Test
    public void test() {
        assertThat(minMaxDifference(11891)).isEqualTo(99009);
        assertThat(minMaxDifference(90)).isEqualTo(99);
        assertThat(minMaxDifference(0)).isEqualTo(9);
    }

    public int minMaxDifference(int num) {
        return findMax(num) - findMin(num);
    }

    private int findMin(int num) {
        String str = String.valueOf(num);
        return Integer.parseInt(str.replace(str.charAt(0), '0'));
    }

    private int findMax(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '9') {
                String first = String.valueOf(str.charAt(i));
                return Integer.parseInt(str.replaceAll(first, "9"));
            }
        }
        return num;
    }

}
