package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not mine
 */
public class Q3272FindTheCountOfGoodIntegers2 {

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
        Set<String> visit = new HashSet<>();
        long answer = 0;

        int halfLen = (n + 1) / 2;
        int start = (int) Math.pow(10, halfLen - 1);
        int end = (int) Math.pow(10, halfLen) - 1;

        for (int num = start; num <= end; num++) {
            String halfStr = String.valueOf(num);
            String fullStr = buildPalindrome(halfStr, n % 2 != 0);
            long palindrome = Long.parseLong(fullStr);
            if (palindrome % k == 0) {
                int[] cnt = countDigits(palindrome);
                String freq = toFreqString(cnt);
                if (visit.add(freq)) {
                    answer += cases(n, cnt);
                }
            }
        }
        return answer;
    }

    private long cases(int n, int[] freq) {
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

    private int[] countDigits(long num) {
        int[] cnt = new int[10];
        while (num > 0) {
            cnt[(int) (num % 10)]++;
            num /= 10;
        }
        return cnt;
    }

    private String toFreqString(int[] cnt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(cnt[i]);
        }
        return sb.toString();
    }

    private String buildPalindrome(String half, boolean isOdd) {
        StringBuilder sb = new StringBuilder(half);
        int startIndex = isOdd ? half.length() - 2 : half.length() - 1;
        for (int i = startIndex; i >= 0; i--) {
            sb.append(half.charAt(i));
        }
        return sb.toString();
    }

}
