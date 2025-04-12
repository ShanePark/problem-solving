package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3272FindTheCountOfGoodIntegers {

    @Test
    public void test() {
        assertThat(countGoodIntegers(1, 4)).isEqualTo(2);
        assertThat(countGoodIntegers(3, 5)).isEqualTo(27);
        assertThat(countGoodIntegers(5, 6)).isEqualTo(2468);
    }

    @Test
    public void tle() {
        assertThat(countGoodIntegers(8, 2)).isEqualTo(563392L);
    }

    public long countGoodIntegers(int n, int k) {
        long min = (long) Math.pow(10, n - 1);
        while (min % k > 0) {
            min++;
        }
        long max = (long) Math.pow(10, n) - 1;
        while (max % k > 0) {
            max--;
        }
        long answer = 0;
        Set<String> visit = new HashSet<>();
        for (; min <= max; min += k) {
            if (isPalindrome(min)) {
                String str = toString(min);
                if (visit.add(str)) {
                    answer += cases(n, str);
                }
            }
        }
        return answer;
    }

    private long cases(int n, String freqStr) {
        int[] freq = new int[10];
        for (int i = 0; i < 10; i++) {
            freq[i] = freqStr.charAt(i) - '0';
        }

        long[] fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        long total = fact[n];
        for (int d = 0; d < 10; d++) {
            total /= fact[freq[d]];
        }

        long bad = 0;
        if (freq[0] > 0) {
            bad = fact[n - 1];
            bad /= fact[freq[0] - 1];
            for (int d = 1; d < 10; d++) {
                bad /= fact[freq[d]];
            }
        }

        return total - bad;
    }

    private String toString(long min) {
        int[] cnt = new int[10];
        while (min > 0) {
            cnt[(int) (min % 10)]++;
            min /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(cnt[i]);
        }
        return sb.toString();
    }

    private boolean isPalindrome(long min) {
        String str = String.valueOf(min);
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
