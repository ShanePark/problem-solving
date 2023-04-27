package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Must be TLE
 */
public class Q319BulbSwitcher {

    @Test
    public void test() {
        assertThat(bulbSwitch(4)).isEqualTo(2);
        assertThat(bulbSwitch(6)).isEqualTo(2);
        assertThat(bulbSwitch(3)).isEqualTo(1);
        assertThat(bulbSwitch(0)).isEqualTo(0);
        assertThat(bulbSwitch(1)).isEqualTo(1);
    }

    @Test
    public void tle() {
        assertThat(bulbSwitch(99999)).isEqualTo(316);
    }

    public int bulbSwitch(int n) {
        if (n < 2)
            return n;
        boolean[] arr = new boolean[n + 1];
        for (int i = 1; i <= n; i += 2) {
            arr[i] = true;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    arr[j] = !arr[j];
                }
            }
        }

        int cnt = 0;
        for (boolean b : arr) {
            if (b)
                cnt++;
        }
        return cnt;
    }

}
