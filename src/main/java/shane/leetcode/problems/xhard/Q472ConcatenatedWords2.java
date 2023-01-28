package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 79 ms Beats 53.74%
 * Memory 48.2 MB Beats 65.64%
 */
public class Q472ConcatenatedWords2 {

    @Test
    public void test() {
        assertThat(findAllConcatenatedWordsInADict(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}))
                .containsExactlyInAnyOrder("catsdogcats", "dogcatsdog", "ratcatdogcat");
        assertThat(findAllConcatenatedWordsInADict(new String[]{"cat", "dog", "catdog"}))
                .containsExactlyInAnyOrder("catdog");
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = Arrays.stream(words).collect(Collectors.toSet());
        Set<String> concatenated = new HashSet<>();
        return Arrays.stream(words)
                .filter(s -> isConcatenated(s, set, concatenated))
                .collect(Collectors.toList());
    }

    private boolean isConcatenated(String word, Set<String> set, Set<String> concatenated) {
        if (concatenated.contains(word))
            return true;
        for (int i = 1; i < word.length(); i++) {
            String first = word.substring(0, i);
            String second = word.substring(i, word.length());
            if (set.contains(first) && (isConcatenated(second, set, concatenated) || set.contains(second))) {
                concatenated.add(word);
                return true;
            }
        }
        return false;
    }

}
