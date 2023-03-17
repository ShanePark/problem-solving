package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 42 ms Beats 47.68%
 * Memory 50.6 MB Beats 96.20%
 */
public class Q208ImplementTriePrefixTree {

    @Test
    public void test() {
        Trie trie = new Trie();
        assertThat(trie.startsWith("app")).isFalse();
        trie.insert("apple");
        assertThat(trie.search("apple")).isTrue();
        assertThat(trie.search("app")).isFalse();
        assertThat(trie.startsWith("app")).isTrue();
        trie.insert("app");
        assertThat(trie.search("app")).isTrue();
    }

    class Trie {

        TreeSet<String> treeSet = new TreeSet<>();

        public Trie() {

        }

        public void insert(String word) {
            treeSet.add(word);
        }

        public boolean search(String word) {
            return treeSet.contains(word);
        }

        public boolean startsWith(String prefix) {
            String ceiling = treeSet.ceiling(prefix);
            return ceiling != null && ceiling.startsWith(prefix);
        }
    }

}
