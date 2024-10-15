package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime18msBeats5.02%
 */
public class Q2938SeparateBlackAndWhiteBalls {

    @Test
    public void test() {
        assertThat(minimumSteps("101")).isEqualTo(1);
        assertThat(minimumSteps("100")).isEqualTo(2);
        assertThat(minimumSteps("0111")).isEqualTo(0);
        assertThat(minimumSteps("1100")).isEqualTo(4);
    }

    @Test
    public void longTest() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sb.append(i % 2);
        }
        assertThat(minimumSteps(sb.toString())).isEqualTo(1249975000L);
    }

    public long minimumSteps(String s) {
        Queue<Integer> zeroIndex = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeroIndex.offer(i);
            }
        }
        long answer = 0;
        for (int i = 0; i < s.length() && !zeroIndex.isEmpty(); i++) {
            answer += zeroIndex.poll() - i;
        }
        return answer;
    }

}
