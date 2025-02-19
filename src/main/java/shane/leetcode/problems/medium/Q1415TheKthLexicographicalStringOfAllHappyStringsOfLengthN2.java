package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats83.83%
 */
public class Q1415TheKthLexicographicalStringOfAllHappyStringsOfLengthN2 {

    @Test
    public void test() {
        assertThat(getHappyString(1, 3)).isEqualTo("c");
        assertThat(getHappyString(1, 4)).isEqualTo("");
        assertThat(getHappyString(3, 9)).isEqualTo("cab");
    }

    public String getHappyString(int n, int k) {
        int total = 3 * (int) Math.pow(2, n - 1);
        if (total < k)
            return "";
        List<String> answer = new ArrayList<>();
        dfs(n, answer, k, new StringBuilder());
        return answer.get(k - 1);
    }

    private void dfs(int n, List<String> answer, int k, StringBuilder cur) {
        if (cur.length() == n) {
            answer.add(cur.toString());
            return;
        }
        if (answer.size() >= k)
            return;
        char last = cur.length() == 0 ? ' ' : cur.charAt(cur.length() - 1);
        for (int i = 0; i < 3; i++) {
            char c = (char) ('a' + i);
            if (last == c)
                continue;
            cur.append(c);
            dfs(n, answer, k, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
