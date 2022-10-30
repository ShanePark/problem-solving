package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 50.00% of Java online submissions for Minimum Addition to Make Integer Beautiful.
 * Memory Usage: 41.2 MB, less than 25.00% of Java online submissions for Minimum Addition to Make Integer Beautiful.
 */
public class Q2457MinimumAdditionToMakeIntegerBeautiful {

    @Test
    public void test() {
        assertThat(makeIntegerBeautiful(615024862295L, 7)).isEqualTo(84975137705L);
        assertThat(makeIntegerBeautiful(6068060761L, 3)).isEqualTo(3931939239L);
        assertThat(makeIntegerBeautiful(94598, 6)).isEqualTo(5402L);
        assertThat(makeIntegerBeautiful(590, 1)).isEqualTo(410);
        assertThat(makeIntegerBeautiful(467, 6)).isEqualTo(33);
        assertThat(makeIntegerBeautiful(16, 6)).isEqualTo(4);
        assertThat(makeIntegerBeautiful(1, 1)).isEqualTo(0);
    }

    public long makeIntegerBeautiful(long n, int target) {
        long answer = 0;
        long mul = 1;

        while (count(n) > target) {
            int mod = (int) (n % 10);
            if (mod > 0) {
                n += 10;
                answer += (long) (10 - mod) * mul;
            }
            mul *= 10;
            n /= 10;
        }

        return answer;
    }

    private int count(long n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n % 10;
            n /= 10;
        }
        return cnt;
    }

}
