package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 39.10MB Beats 56.73%of users with Java
 */
public class Q779KthSymbolInGrammar {

    @Test
    public void test() {
        assertThat(kthGrammar(3, 2)).isEqualTo(1);
        assertThat(kthGrammar(2, 2)).isEqualTo(1);
        assertThat(kthGrammar(1, 1)).isEqualTo(0);
        assertThat(kthGrammar(2, 1)).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(kthGrammar(30, (int) 2e30 - 1)).isEqualTo(1);
    }

    /*
    0
    01
    0110
     */

    public int kthGrammar(int n, int k) {
        return kthGrammar(0, n - 1, k - 1);
    }

    private int kthGrammar(int binary, int n, int k) {
        if (n == 0)
            return binary;

        String cur = binary == 0 ? "01" : "10";
        int pow = (int) Math.pow(2, n);
        if (k >= pow / 2) {
            binary = cur.charAt(1) - '0';
            k -= pow / 2;
        } else {
            binary = cur.charAt(0) - '0';
        }
        return kthGrammar(binary, n - 1, k);
    }

}
