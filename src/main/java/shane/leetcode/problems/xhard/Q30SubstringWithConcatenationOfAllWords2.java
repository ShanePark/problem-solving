package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 116 ms, faster than 74.66% of Java online submissions for Substring with Concatenation of All Words.
 * Memory Usage: 72.9 MB, less than 44.45% of Java online submissions for Substring with Concatenation of All Words.
 */
@SuppressWarnings("ALL")
public class Q30SubstringWithConcatenationOfAllWords2 {

    @Test
    public void test() {
        assertThat(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"})).containsExactlyInAnyOrder(8);
        assertThat(findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})).containsExactlyInAnyOrder(0, 9);
        assertThat(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"})).isEmpty();
        assertThat(findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})).containsExactlyInAnyOrder(6, 9, 12);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.merge(word, 1, Integer::sum);
        }
        List<Integer> answer = new ArrayList<>();

        int length = words[0].length() * words.length;

        for (int i = 0; i <= s.length() - length; i++) {
            if (valid(s, i, i + length, words[0].length(), countMap)) {
                answer.add(i);
            }
        }

        return answer;
    }

    private boolean valid(String s, int start, int end, int length, Map<String, Integer> countMap) {
        HashMap<String, Integer> clone = new HashMap<>();
        for (; start < end; start += length) {
            String sub = s.substring(start, start + length);
            int before = clone.getOrDefault(sub, 0);
            if (before >= countMap.getOrDefault(sub, 0)) {
                return false;
            }
            clone.put(sub, before + 1);
        }
        return true;
    }

}
