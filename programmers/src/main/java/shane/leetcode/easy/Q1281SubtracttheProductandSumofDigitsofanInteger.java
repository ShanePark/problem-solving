package shane.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1281SubtracttheProductandSumofDigitsofanInteger {

    @Test
    void test() {
        Assertions.assertThat(subtractProductAndSum(234)).isEqualTo(15);
        Assertions.assertThat(subtractProductAndSum(4421)).isEqualTo(21);
        Assertions.assertThat(subtractProductAndSum(0)).isEqualTo(0);
        Assertions.assertThat(subtractProductAndSum(1)).isEqualTo(0);
        Assertions.assertThat(subtractProductAndSum(114)).isEqualTo(-2);
    }

    public int subtractProductAndSum(int n) {
        int sum = 0;
        int mul = 1;
        String str = String.valueOf(n);
        for (int i = 0; i < str.length(); i++) {
            int num = (str.charAt(i) - 48);
            sum += num;
            mul *= num;
        }

        return mul - sum;

    }
}
