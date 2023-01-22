package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 8 ms Beats 99.21%
 * Memory 55.1 MB Beats 53.35%
 */
public class Q131PalindromePartitioning2 {

    @Test
    public void test() {
        assertThat(partition("efe")).containsExactlyInAnyOrder(
                List.of("e", "f", "e"),
                List.of("efe")
        );
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
        dfs(0, answer, new ArrayList<>(), s);
        return answer;
    }

    private void dfs(int i, List<List<String>> answer, ArrayList<String> list, String s) {
        if (i == s.length()) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                list.add(s.substring(i, j + 1));
                dfs(j + 1, answer, list, s);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}
