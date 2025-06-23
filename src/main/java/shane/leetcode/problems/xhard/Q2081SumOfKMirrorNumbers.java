package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2081SumOfKMirrorNumbers {

    @Test
    public void test() {
        assertThat(kMirror(2, 5)).isEqualTo(25);
        assertThat(kMirror(3, 7)).isEqualTo(499);
        assertThat(kMirror(7, 17)).isEqualTo(20379000);
    }

    public long kMirror(int k, int n) {
        int left = 1;
        int count = 0;
        long answer = 0;
        while (count < n) {
            int right = left * 10;
            for (int op = 0; op < 2; op++) {
                for (int i = left; i < right && count < n; i++) {
                    long combined = i;
                    int x = (op == 0 ? i / 10 : i);
                    while (x > 0) {
                        combined = combined * 10 + (x % 10);
                        x /= 10;
                    }
                    if (isPalindrome(combined, k)) {
                        count++;
                        answer += combined;
                    }
                }
            }
            left = right;
        }
        return answer;
    }

    private boolean isPalindrome(long x, int k) {
        int[] digit = new int[100];

        int length = -1;
        while (x > 0) {
            digit[++length] = (int) (x % k);
            x /= k;
        }
        for (int i = 0, j = length; i < j; ++i, --j) {
            if (digit[i] != digit[j]) {
                return false;
            }
        }
        return true;
    }
}
