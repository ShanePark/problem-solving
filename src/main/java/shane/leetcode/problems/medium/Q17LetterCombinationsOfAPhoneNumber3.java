package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 41.2 MB Beats 76.76%
 */
public class Q17LetterCombinationsOfAPhoneNumber3 {

    @Test
    public void test() {
        assertThat(letterCombinations("23")).containsExactlyInAnyOrder("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertThat(letterCombinations("")).isEmpty();
        assertThat(letterCombinations("2")).containsExactlyInAnyOrder("a", "b", "c");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return Collections.emptyList();
        char[][] arr = new char[][]{
                {}, {}, {'a', 'b', 'c'},
                {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'}, {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };

        List<String> answer = new ArrayList<>();
        dfs(answer, arr, digits, 0, new StringBuilder());
        return answer;
    }

    private void dfs(List<String> answer, char[][] arr, String digits, int i, StringBuilder sb) {
        if (digits.length() == i) {
            answer.add(sb.toString());
            return;
        }
        int num = digits.charAt(i) - '0';
        for (char c : arr[num]) {
            sb.append(c);
            dfs(answer, arr, digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
