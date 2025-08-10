package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 85.79%
 */
public class Q869ReorderedPowerOf22 {

    @Test
    public void test() {
        assertThat(reorderedPowerOf2(218)).isEqualTo(true);
        assertThat(reorderedPowerOf2(1)).isEqualTo(true);
        assertThat(reorderedPowerOf2(10)).isEqualTo(false);
        assertThat(reorderedPowerOf2(46)).isEqualTo(true);
    }

    @Test
    public void tle() {
        assertThat(reorderedPowerOf2(1000000000)).isEqualTo(false);
    }

    public boolean reorderedPowerOf2(int n) {
        long pow = 1;
        int[] cnt = count(n);
        int len = (int) Math.log10(n) + 1;
        while ((int) Math.log10(pow) + 1 <= len) {
            if (Arrays.equals(cnt, count(pow)))
                return true;
            pow *= 2;
        }
        return false;
    }

    private int[] count(long n) {
        int[] cnt = new int[10];
        while (n > 0) {
            cnt[(int) (n % 10)]++;
            n /= 10;
        }
        return cnt;
    }

}
