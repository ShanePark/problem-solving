package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q258AddDigits {

    @Test
    void test() {
        Assertions.assertThat(addDigits(38)).isEqualTo(2);
        Assertions.assertThat(addDigits(100)).isEqualTo(1);
        Assertions.assertThat(addDigits(0)).isEqualTo(0);
        Assertions.assertThat(addDigits(10)).isEqualTo(1);
        Assertions.assertThat(addDigits(99)).isEqualTo(9);
    }

    public int addDigits(int num) {
        while (num >= 10) {
            int temp = num;
            num = 0;
            while (temp > 0) {
                num += temp % 10;
                temp /= 10;
            }

        }
        return num;
    }

}
