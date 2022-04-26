package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Limit Exceeded
 */
public class Q211DesignAddandSearchWordsDataStructure {

    @Test
    void test() {
        WordDictionary obj = new WordDictionary();
        obj.addWord("bad");
        obj.addWord("dad");
        obj.addWord("mad");
        Assertions.assertThat(obj.search("pad")).isFalse();
        Assertions.assertThat(obj.search("bad")).isTrue();
        Assertions.assertThat(obj.search(".ad")).isTrue();
        Assertions.assertThat(obj.search("b..")).isTrue();
    }

    class WordDictionary {

        Set<String> set;

        public WordDictionary() {
            this.set = new HashSet<>();
        }

        public void addWord(String word) {
            set.add(word);
            dfs(set, word, "", 0);
        }

        private void dfs(Set<String> set, String word, String temp, int n) {
            if (n > word.length() - 1) {
                set.add(temp);
                return;
            }
            dfs(set, word, temp + word.charAt(n), n + 1);
            dfs(set, word, temp + ".", n + 1);
        }

        public boolean search(String word) {
            return set.contains(word);
        }
    }

}
