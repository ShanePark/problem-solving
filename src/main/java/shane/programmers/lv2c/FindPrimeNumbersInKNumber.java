package shane.programmers.lv2c;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindPrimeNumbersInKNumber {

    @Test
    void test() {
        Assertions.assertThat(solution(437674, 3)).isEqualTo(3);
        Assertions.assertThat(solution(110011, 10)).isEqualTo(2);
        Assertions.assertThat(solution(0, 2)).isEqualTo(0);
        Assertions.assertThat(solution(10, 5)).isEqualTo(1);
        Assertions.assertThat(solution(3, 3)).isEqualTo(0);
        Assertions.assertThat(solution(1000000, 3)).isEqualTo(2);
    }

    public int solution(int n, int k) {
        int cnt = 0;
        for (String s : toBinary(n, k).split("0")) {
            if (isPrime(s)) {
                cnt++;
            }
        }
        return cnt;
    }

    private String toBinary(int n, int k) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    private boolean isPrime(String str) {
        try {
            long n = Long.parseLong(str);
            if (n < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
