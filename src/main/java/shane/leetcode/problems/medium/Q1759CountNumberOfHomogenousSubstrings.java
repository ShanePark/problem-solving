package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 5ms Beats 100.00%of users with Java
 * Memory Details 43.70MB Beats 93.60%of users with Java
 */
public class Q1759CountNumberOfHomogenousSubstrings {

    @Test
    public void test() {
        assertThat(countHomogenous("abbcccaa")).isEqualTo(13);
        assertThat(countHomogenous("xy")).isEqualTo(2);
        assertThat(countHomogenous("zzzzz")).isEqualTo(15);
    }


    public int countHomogenous(String s) {
        final int MOD = (int) 1e9 + 7;
        long sum = 0;
        char before = ' ';
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == before) {
                sum += ++cnt;
                continue;
            }
            before = c;
            cnt = 1;
            sum++;
        }
        return (int) (sum % MOD);
    }

}
