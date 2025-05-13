package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * must be TLE
 */
public class Q3335TotalCharactersInStringAfterTransformationsI {

    @Test
    public void test() {
        assertThat(lengthAfterTransformations("abcyy", 2)).isEqualTo(7);
        assertThat(lengthAfterTransformations("azbk", 1)).isEqualTo(5);
    }

    @Test
    public void edgeCase() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append('a' + (i % 26));
        }
        assertThat(lengthAfterTransformations(sb.toString(), 100_000)).isEqualTo(5);
    }

    final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int length = getLength(c, t);
            sum = (sum + length) % MOD;

        }
        return sum;
    }

    private int getLength(char c, int t) {
        int split = 'z' - c;
        if (t < split)
            return 1;
        t -= split;
        return (getLength('a', t) + getLength('b', t)) % MOD;
    }

}
