package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 92.38%
 */
public class Q1432MaxDifferenceYouCanGetFromChangingAnInteger {

    @Test
    public void test() {
        assertThat(maxDiff(555)).isEqualTo(888);
        assertThat(maxDiff(9)).isEqualTo(8);
        assertThat(maxDiff(123)).isEqualTo(820);
        assertThat(maxDiff(123456)).isEqualTo(820000);
        assertThat(maxDiff(912)).isEqualTo(880);
    }

    public int maxDiff(int num) {
        return findMax(num) - findMin(num);
    }

    private int findMin(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('1' < c) {
                return Integer.parseInt(str.replace(c, i == 0 ? '1' : '0'));
            }
        }
        return num;
    }

    private int findMax(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '9') {
                return Integer.parseInt(str.replace(c, '9'));
            }
        }
        return num;
    }

}
