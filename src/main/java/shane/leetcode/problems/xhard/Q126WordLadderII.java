package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q126WordLadderII {

    @Test
    public void test() {
        assertThat(findLadders("hot", "dog", List.of("hot","cog","dog","tot","hog","hop","pot","dot"))).containsExactlyInAnyOrderElementsOf(Ps.strList("[[\"hot\",\"dot\",\"dog\"],[\"hot\",\"hog\",\"dog\"]]"));
        assertThat(findLadders("a", "c", List.of("a", "b", "c"))).isEqualTo(Ps.strList("[[\"a\",\"c\"]]"));
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"))).isEqualTo(Ps.strList("[[\"hit\",\"hot\",\"dot\",\"dog\",\"cog\"],[\"hit\",\"hot\",\"lot\",\"log\",\"cog\"]]"));
        assertThat(findLadders("hit", "cog", List.of("hot", "dot", "dog", "lot", "log"))).isEqualTo(Ps.strList("[]"));
    }

    /**
     * it takes ages and even not finished
     */
    @Test
    public void tleTest() {
        assertThat(findLadders("qa", "sq", List.of("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")))
                .isEqualTo(Ps.strList("[]"));
    }


    int minSize;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        minSize = 501;
        if (!wordList.contains(endWord)) {
            return Collections.emptyList();
        }
        List<List<String>> answer = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        cur.add(beginWord);
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        find(beginWord, endWord, cur, set, wordList, answer);

        return answer;
    }

    private void find(String beginWord, String endWord, List<String> cur, Set<String> set, List<String> wordList, List<List<String>> answer) {
        if (beginWord.equals(endWord)) {
            if (cur.size() < minSize) {
                answer.clear();
                minSize = cur.size();
            }
            if (cur.size() == minSize) {
                answer.add(new ArrayList<>(cur));
            }
            return;
        }
        for (String word : wordList) {
            if (diffOne(beginWord, word) && set.add(word)) {
                cur.add(word);
                find(word, endWord, cur, set, wordList, answer);
                cur.remove(cur.size() - 1);
                set.remove(word);
            }
        }
    }

    private boolean diffOne(String beginWord, String word) {
        int length = word.length();
        int totalDiff = 0;
        for (int i = 0; i < length; i++) {
            if (beginWord.charAt(i) != word.charAt(i)) {
                totalDiff++;
            }
            if (totalDiff > 1)
                return false;
        }
        return totalDiff == 1;
    }
}
