package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1806MinimumNumberOfOperationsToReinitializeAPermutation4 {

    @Test
    public void test() {
        assertThat(reinitializePermutation(2)).isEqualTo(1);
        assertThat(reinitializePermutation(4)).isEqualTo(2);
        assertThat(reinitializePermutation(6)).isEqualTo(4);
        assertThat(reinitializePermutation(8)).isEqualTo(3);
    }

    public int reinitializePermutation(int n) {
        int cnt = 0;
        int i = 1;
        while (cnt == 0 || i != 1) {
            if (i < n / 2) {
                i *= 2;
            } else {
                i = 2 * i - n + 1;
            }
            cnt++;
        }
        return cnt;
    }

}
