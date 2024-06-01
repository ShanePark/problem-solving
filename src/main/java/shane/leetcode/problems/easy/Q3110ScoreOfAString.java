package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 99.87% of users with Java
 */
public class Q3110ScoreOfAString {

    @Test
    public void test() {
        assertThat(scoreOfString("hello")).isEqualTo(13);
        assertThat(scoreOfString("zaz")).isEqualTo(50);
    }

    public int scoreOfString(String s) {
        char before = s.charAt(0);
        int answer = 0;
        for (char c : s.toCharArray()) {
            answer += Math.abs(c - before);
            before = c;
        }
        return answer;
    }

}
