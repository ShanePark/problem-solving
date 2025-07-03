package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
3ms
Beats74.89%

 */
public class Q3304FindTheKthCharacterInStringGameI {

    @Test
    public void test() {
        assertThat(kthCharacter(5)).isEqualTo('b');
        assertThat(kthCharacter(10)).isEqualTo('c');
    }

    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            String next = next(sb);
            sb.append(next);
        }
        return sb.charAt(k - 1);
    }

    private String next(StringBuilder sb) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            answer.append((char) ((sb.charAt(i) - 'a' + 1) % 26 + 'a'));
        }
        return answer.toString();
    }

}
