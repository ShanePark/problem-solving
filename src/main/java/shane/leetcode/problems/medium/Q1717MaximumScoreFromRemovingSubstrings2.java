package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime237msBeats29.29%
 */
public class Q1717MaximumScoreFromRemovingSubstrings2 {

    @Test
    public void test() {
        assertThat(maximumGain("cdbcbbaaabab", 4, 5)).isEqualTo(19);
        assertThat(maximumGain("aabbaaxybbaabb", 4, 5)).isEqualTo(20);
        assertThat(maximumGain("aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha",
                8484, 4096)).isEqualTo(198644);
    }

    @Test
    public void tle() {
        String str = "ab".repeat(100000);
        assertThat(maximumGain(str, 2890, 1643)).isEqualTo(289000000);
    }

    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        int score = 0;
        if (y > x) {
            score += replaceAll(sb, 'b', 'a') * y;
            score += replaceAll(sb, 'a', 'b') * x;
        } else {
            score += replaceAll(sb, 'a', 'b') * x;
            score += replaceAll(sb, 'b', 'a') * y;
        }

        s = sb.toString();
        if (s.contains("ab") || s.contains("ba")) {
            return score + maximumGain(s, x, y);
        }
        return score;
    }

    private int replaceAll(StringBuilder sb, char c1, char c2) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c1 && c == c2) {
                stack.pop();
                count++;
                continue;
            }
            stack.push(c);
        }
        sb.delete(0, sb.length());
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        return count;
    }

}
