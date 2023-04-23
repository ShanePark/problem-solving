package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 58 ms Beats 73.56% Memory 43.2 MB Beats 82.76%
 */
public class Q1416RestoreTheArray {

    @Test
    void test() {
        assertThat(numberOfArrays("1000", 10000)).isEqualTo(1);
        assertThat(numberOfArrays("1000", 10)).isEqualTo(0);
        assertThat(numberOfArrays("1317", 2000)).isEqualTo(8);
        assertThat(numberOfArrays("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415",
                823924906)).isEqualTo(427125123);
    }

    final int MOD = (int) 1e9 + 7;

    public int numberOfArrays(String s, int k) {
        long[] dp = new long[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                continue;
            long num = 0;
            for (int j = i; j < s.length(); j++) {
                num = num + (s.charAt(j) - '0');
                if (k < num)
                    break;
                dp[i] = (dp[i] + dp[j + 1]) % MOD;
                num *= 10;
            }
        }
        return (int) (dp[0] % MOD);
    }

}
