package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2999CountTheNumberOfPowerfulIntegers {

    @Test
    public void test() {
        assertThat(numberOfPowerfulInt(1, 6000, 4, "124")).isEqualTo(5);
        assertThat(numberOfPowerfulInt(15, 215, 6, "10")).isEqualTo(2);
        assertThat(numberOfPowerfulInt(1000, 2000, 4, "3000")).isEqualTo(0);
    }

    /**
     * 989 ms
     */
    @Test
    public void tle() {
        assertThat(numberOfPowerfulInt(15398, 1424153842, 8, "220")).isEqualTo(783790L);
    }

    long answer = 0;

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        answer = 0;
        dfs(start, finish, limit, s);
        return answer;
    }

    private void dfs(long start, long finish, int limit, String s) {
        if (String.valueOf(finish).length() < s.length())
            return;
        if (s.charAt(0) != '0') {
            long cur = Long.parseLong(s);
            if (finish < cur)
                return;
            if (start <= cur) {
                answer++;
            }
        }
        for (int i = 0; i <= limit; i++) {
            dfs(start, finish, limit, i + s);
        }
    }

}
