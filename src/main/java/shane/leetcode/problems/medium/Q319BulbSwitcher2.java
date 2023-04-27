package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q319BulbSwitcher2 {

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

    /**
     * Each number is affected by its divisors, if numbers of divisors is odd the bulb is on. Therefore, only square
     */
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

}
