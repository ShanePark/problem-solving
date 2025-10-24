package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 356ms
 * Beats17.69%
 */
public class Q2048NextGreaterNumericallyBalancedNumber {

    @Test
    public void test() {
        assertThat(nextBeautifulNumber(1)).isEqualTo(22);
        assertThat(nextBeautifulNumber(1000)).isEqualTo(1333);
        assertThat(nextBeautifulNumber(3000)).isEqualTo(3133);
    }

    public int nextBeautifulNumber(int n) {
        n++;
        for (; ; n++) {
            if (isBeautiful(n)) {
                return n;
            }
        }
    }

    private boolean isBeautiful(int n) {
        String s = String.valueOf(n);
        Map<Integer, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            int i = c - '0';
            Integer v = cnt.merge(i, 1, Integer::sum);
            if (v > i)
                return false;
        }
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getKey() != (int) e.getValue())
                return false;
        }
        return true;
    }

}
