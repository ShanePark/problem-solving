package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 15.92% of users with Java
 */
public class Q131PalindromePartitioning3 {

    @Test
    public void test() {
        assertThat(partition("aab")).containsExactlyInAnyOrder(
                List.of("a", "a", "b"),
                List.of("aa", "b")
        );
        assertThat(partition("a")).containsExactlyInAnyOrder(
                List.of("a")
        );
    }

    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        dfs(s, answer, 0, new ArrayList<>(), new StringBuilder());
        return answer;
    }

    private void dfs(String s, List<List<String>> answer, int i, List<String> cur, StringBuilder sb) {
        int size = cur.size();
        if (i == s.length()) {
            if (isPalindrome(sb)) {
                cur.add(sb.toString());
                answer.add(new ArrayList<>(cur));
                cur.remove(size);
            }
            return;
        }
        char c = s.charAt(i);

        sb.append(c);
        dfs(s, answer, i + 1, cur, sb);
        if (isPalindrome(sb)) {
            cur.add(sb.toString());
            dfs(s, answer, i + 1, cur, new StringBuilder());
            cur.remove(size);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean isPalindrome(StringBuilder sb) {
        if (sb.length() == 0)
            return false;
        int length = sb.length();
        for (int i = 0; i < length / 2; i++) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(length - 1 - i);
            if (c1 != c2)
                return false;
        }
        return true;
    }

}
