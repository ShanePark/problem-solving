package shane.leetcode.contest.weekly.w326;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(countDigits(7)).isEqualTo(1);
        assertThat(countDigits(10)).isEqualTo(1);
        assertThat(countDigits(121)).isEqualTo(2);
        assertThat(countDigits(1248)).isEqualTo(4);
    }

    public int countDigits(int num) {
        int cnt = 0;
        int data = num;
        while (num > 0) {
            int mod = num % 10;
            if (mod != 0 && data % mod == 0) {
                cnt++;
            }
            num /= 10;
        }
        return cnt;
    }

}
