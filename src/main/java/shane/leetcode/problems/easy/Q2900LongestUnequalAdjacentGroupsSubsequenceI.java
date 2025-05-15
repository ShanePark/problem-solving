package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats96.15%
 */
public class Q2900LongestUnequalAdjacentGroupsSubsequenceI {

    @Test
    public void test() {
        assertThat(getLongestSubsequence(new String[]{"e", "a", "b"}, new int[]{0, 0, 1})).containsExactly("e", "b");
        assertThat(getLongestSubsequence(new String[]{"a", "b", "c", "d"}, new int[]{1, 0, 1, 1})).containsExactly("a", "b", "c");
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> answer = new ArrayList<>();
        int lastGroup = -1;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] == lastGroup)
                continue;
            lastGroup = groups[i];
            answer.add(words[i]);
        }
        return answer;
    }

}
