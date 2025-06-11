package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my
 */
public class Q3445MaximumDifferenceBetweenEvenAndOddFrequencyII {

    @Test
    public void test() {
        assertThat(maxDifference("12233", 4)).isEqualTo(-1);
        assertThat(maxDifference("1122211", 3)).isEqualTo(1);
        assertThat(maxDifference("110", 3)).isEqualTo(-1);
        assertThat(maxDifference("44114402", 7)).isEqualTo(1);
    }

    public int maxDifference(String s, int k) {
        int answer = Integer.MIN_VALUE;
        char[] chars = new char[]{'0', '1', '2', '3', '4'};
        for (char a : chars) {
            for (char b : chars) {
                if (a == b) continue;
                int[] best = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
                int cntA = 0, cntB = 0;
                int prevA = 0, prevB = 0;
                int left = -1;
                for (int right = 0; right < s.length(); right++) {
                    cntA += (s.charAt(right) == a) ? 1 : 0;
                    cntB += (s.charAt(right) == b) ? 1 : 0;

                    while (right - left >= k && cntB - prevB >= 2) {
                        int lStatus = ((prevA & 1) << 1) | (prevB & 1);
                        best[lStatus] = Math.min(best[lStatus], prevA - prevB);
                        left++;
                        prevA += (s.charAt(left) == a) ? 1 : 0;
                        prevB += (s.charAt(left) == b) ? 1 : 0;
                    }

                    int rStatus = ((cntA & 1) << 1) | (cntB & 1);
                    if (best[rStatus ^ 2] != Integer.MAX_VALUE) {
                        answer = Math.max(answer, cntA - cntB - best[rStatus ^ 2]);
                    }
                }
            }
        }
        return answer;
    }

}
