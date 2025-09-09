package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2327NumberOfPeopleAwareOfASecret {

    @Test
    public void test() {
        assertThat(peopleAwareOfSecret(6, 2, 4)).isEqualTo(5);
        assertThat(peopleAwareOfSecret(4, 1, 3)).isEqualTo(6);
    }

    final int MOD = (int) 1e9 + 7;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        long peopleKnowSecret = 0;
        dp[1] = 1;

        for (int day = 2; day <= n; day++) {
            long newSharers = dp[Math.max(day - delay, 0)];
            long expiredSharers = dp[Math.max(day - forget, 0)];
            peopleKnowSecret = (peopleKnowSecret + newSharers - expiredSharers + MOD) % MOD;
            dp[day] = peopleKnowSecret;
        }

        int answer = 0;
        for (int day = n - forget + 1; day <= n; day++) {
            answer = (answer + (int) dp[day]) % MOD;
        }
        return answer;
    }

}
