package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats93.48%
 */
public class Q2273FindResultantArrayAfterRemovingAnagrams {

    @Test
    public void test() {
        assertThat(removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"})).containsExactly("abba", "cd");
        assertThat(removeAnagrams(new String[]{"a", "b", "c", "d", "e"})).containsExactly("a", "b", "c", "d", "e");
    }

    public List<String> removeAnagrams(String[] words) {
        String last = "";
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);
            if (!last.equals(sorted)) {
                answer.add(word);
            }
            last = sorted;
        }
        return answer;
    }

}
