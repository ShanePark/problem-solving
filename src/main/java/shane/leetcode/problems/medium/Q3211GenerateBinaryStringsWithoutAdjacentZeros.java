package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2
 * ms
 * Beats
 * 87.21%
 */
public class Q3211GenerateBinaryStringsWithoutAdjacentZeros {

    @Test
    public void test() {
        assertThat(validStrings(3)).containsExactlyInAnyOrder("111", "110", "101", "011", "010");
        assertThat(validStrings(1)).containsExactlyInAnyOrder("0", "1");
    }

    public List<String> validStrings(int n) {
        List<String> answer = new ArrayList<>();
        dfs(answer, n, new StringBuilder());
        return answer;
    }

    private void dfs(List<String> answer, int n, StringBuilder cur) {
        if (cur.length() == n) {
            answer.add(cur.toString());
            return;
        }
        char last = cur.length() == 0 ? ' ' : cur.charAt(cur.length() - 1);
        if (last != '0') {
            cur.append('0');
            dfs(answer, n, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        cur.append('1');
        dfs(answer, n, cur);
        cur.deleteCharAt(cur.length() - 1);
    }

}
