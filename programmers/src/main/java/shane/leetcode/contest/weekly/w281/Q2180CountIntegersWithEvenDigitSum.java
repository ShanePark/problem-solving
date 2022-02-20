package shane.leetcode.contest.weekly.w281;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2180CountIntegersWithEvenDigitSum {

    @Test
    void test() {
        Assertions.assertThat(countEven(4)).isEqualTo(2);
        Assertions.assertThat(countEven(30)).isEqualTo(14);
    }

    public int countEven(int num) {
        int cnt = 0;
        for (int i = 2; i <= num; i++) {
            int tmp = i;
            int sum = 0;
            while (tmp > 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (sum % 2 == 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
