package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reordered Power of 2.
 * Memory Usage: 41.7 MB, less than 22.00% of Java online submissions for Reordered Power of 2.
 */
public class Q869ReorderedPowerOf2 {

    @Test
    public void test() {
        assertThat(reorderedPowerOf2(218)).isEqualTo(true);
        assertThat(reorderedPowerOf2(46)).isEqualTo(true);
        assertThat(reorderedPowerOf2(1)).isEqualTo(true);
        assertThat(reorderedPowerOf2(10)).isEqualTo(false);
    }

    public boolean reorderedPowerOf2(int n) {
        int i = 1;
        while ((int) Math.log10(i) < (int) Math.log10(n)) {
            i *= 2;
        }

        while ((int) Math.log10(i) == (int) Math.log10(n)) {
            if (check(i, n)) {
                return true;
            }
            i *= 2;
        }
        return false;
    }

    private boolean check(int n1, int n2) {
        int[] arr = new int[10];
        while (n1 > 0) {
            arr[n1 % 10]++;
            arr[n2 % 10]--;
            n1 /= 10;
            n2 /= 10;
        }
        for (int i : arr) {
            if (i != 0)
                return false;
        }
        return true;
    }
}
