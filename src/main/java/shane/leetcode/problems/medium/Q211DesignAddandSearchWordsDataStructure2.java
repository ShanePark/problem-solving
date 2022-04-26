package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("ALL")
public class Q211DesignAddandSearchWordsDataStructure2 {

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

        Map<Integer, List<String>> map;

        public WordDictionary() {
            this.map = new HashMap<>();
        }

        public void addWord(String word) {
            List<String> list = map.getOrDefault(word.length(), new ArrayList<>());
            list.add(word);
            map.putIfAbsent(word.length(), list);
        }

        public boolean search(String word) {
            List<String> list = map.get(word.length());
            if (list == null)
                return false;
            if (word.indexOf(".") < 0) {
                return list.contains(word);
            }
            loop:
            for (String s : list) {
                for (int i = 0; i < word.length(); i++) {
                    if (s.charAt(i) != word.charAt(i) && word.charAt(i) != '.')
                        continue loop;
                }
                return true;
            }
            return false;
        }
    }

}
