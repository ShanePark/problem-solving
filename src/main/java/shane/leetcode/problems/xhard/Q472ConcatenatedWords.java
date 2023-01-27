package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 174 ms Beats 13.95%
 * Memory 110.7 MB Beats 9.55%
 */
public class Q472ConcatenatedWords {

    @Test
    public void test() {
        assertThat(findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}))
                .containsExactlyInAnyOrder("catsdogcats", "dogcatsdog", "ratcatdogcat");
        assertThat(findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}))
                .containsExactlyInAnyOrder("catdog");
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (isConcatenated(word, set)) {
                answer.add(word);
            }
        }
        return answer;
    }

    private boolean isConcatenated(String word, Set<String> set) {
        for (int i = 1; i < word.length(); i++) {
            String first = word.substring(0, i);
            String second = word.substring(i, word.length());
            if (set.contains(first) && (isConcatenated(second, set) || set.contains(second)))
                return true;
        }
        return false;
    }

}
