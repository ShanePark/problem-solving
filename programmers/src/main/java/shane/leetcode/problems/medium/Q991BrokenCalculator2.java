package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q991BrokenCalculator2 {

    @Test
    public void test() {
        assertThat(brokenCalc(2, 3)).isEqualTo(2); // 00010 00011
        assertThat(brokenCalc(5, 8)).isEqualTo(2); // 00101 01000
        assertThat(brokenCalc(3, 10)).isEqualTo(3);
        assertThat(brokenCalc(1, 1024)).isEqualTo(10);
        assertThat(brokenCalc(1024, 1)).isEqualTo(1023);
        assertThat(brokenCalc(1000000001, 1)).isEqualTo(1000000000);
        assertThat(brokenCalc(1, 1000000000)).isEqualTo(39);
    }

    public int brokenCalc(int startValue, int target) {
        int cnt = 0;
        while (target > startValue) {
            target = target % 2 == 0 ? target / 2 : target + 1;
            cnt++;
        }
        return cnt + (startValue - target);
    }

}
