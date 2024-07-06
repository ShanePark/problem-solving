package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q2582PassThePillow {

    @Test
    public void test() {
        assertThat(passThePillow(141, 506)).isEqualTo(55);
        assertThat(passThePillow(2, 341)).isEqualTo(2);
        assertThat(passThePillow(4, 5)).isEqualTo(2);
        assertThat(passThePillow(3, 2)).isEqualTo(3);
        assertThat(passThePillow(4, 7)).isEqualTo(2);
    }

    public int passThePillow(int n, int time) {
        int length = (n - 1) * 2;
        int position = time % length + 1;
        return position <= n ? position : length - position + 2;
    }

}
