package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime26msBeats47.08%
 */
public class Q1653MinimumDeletionsToMakeStringBalanced {

    @Test
    public void test() {
        assertThat(minimumDeletions("aababbab")).isEqualTo(2);
        assertThat(minimumDeletions("bbaaaaabb")).isEqualTo(2);
        assertThat(minimumDeletions("a")).isEqualTo(0);
        assertThat(minimumDeletions("bbbbbbbbbbbbbb")).isEqualTo(0);
        assertThat(minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"))
                .isEqualTo(60);
        assertThat(minimumDeletions("aabbbbaabababbbbaaaaaabbababaaabaabaabbbabbbbabbabbababaabaababbbbaaaaabbabbabaaaabbbabaaaabbaaabbbaabbaaaaabaa"))
                .isEqualTo(52);
    }

    public int minimumDeletions(String s) {
        final int LENGTH = s.length();

        int[] aCount = new int[LENGTH];
        if (s.charAt(0) == 'a') {
            aCount[0] = 1;
        }
        for (int i = 1; i < LENGTH; i++) {
            aCount[i] = aCount[i - 1];
            if (s.charAt(i) == 'a') {
                aCount[i]++;
            }
        }

        int totalA = aCount[LENGTH - 1];
        if (totalA == LENGTH || totalA == 0)
            return 0;

        int answer = totalA;
        for (int i = 1; i <= LENGTH; i++) {
            int leftB = i - aCount[i - 1];
            int rightA = totalA - aCount[i - 1];
            answer = Math.min(answer, leftB + rightA);
        }
        return answer;
    }

}

