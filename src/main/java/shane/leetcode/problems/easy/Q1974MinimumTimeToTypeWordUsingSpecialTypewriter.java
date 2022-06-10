package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1974MinimumTimeToTypeWordUsingSpecialTypewriter {

    @Test
    public void test() {
        assertThat(minTimeToType("bza")).isEqualTo(7);
        assertThat(minTimeToType("abc")).isEqualTo(5);
        assertThat(minTimeToType("zjpc")).isEqualTo(34);
    }

    public int minTimeToType(String word) {
        char cur = 'a';
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            int move = Math.abs(cur - word.charAt(i));
            move = move > 13 ? 26 - move : move;
            cur = word.charAt(i);
            answer = answer + move + 1;
        }
        return answer;
    }
}
