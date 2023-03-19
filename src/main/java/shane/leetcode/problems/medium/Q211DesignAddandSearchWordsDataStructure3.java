package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 868 ms Beats 42.19%
 * Memory 86.1 MB Beats 87.85%
 */
public class Q211DesignAddandSearchWordsDataStructure3 {

    @Test
    void test() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        assertThat(dictionary.search("pad")).isFalse();
        assertThat(dictionary.search("bad")).isTrue();
        assertThat(dictionary.search(".ad")).isTrue();
        assertThat(dictionary.search("b..")).isTrue();
    }

    @Test
    void test2() {
        WordDictionary dictionary = new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        assertThat(dictionary.search("a")).isFalse();
        assertThat(dictionary.search(".at")).isFalse();
        dictionary.addWord("bat");
        assertThat(dictionary.search(".at")).isTrue();
        assertThat(dictionary.search("an.")).isTrue();
        assertThat(dictionary.search("a.d.")).isFalse();
        assertThat(dictionary.search("b.")).isFalse();
        assertThat(dictionary.search("a.d")).isTrue();
        assertThat(dictionary.search(".")).isFalse();
    }

    class WordDictionary {

        final Node head;

        public WordDictionary() {
            this.head = new Node(' ');
        }

        public void addWord(String word) {
            head.add(word);
        }

        public boolean search(String word) {
            return head.search(word);
        }
    }

    class Node {
        char c;
        Node[] next = new Node[26];
        boolean isEnd;

        public Node(char c) {
            this.c = c;
        }

        public void add(String word) {
            char first = word.charAt(0);
            Node nextNode = next[first - 'a'];
            if (nextNode == null) {
                nextNode = new Node(first);
                next[first - 'a'] = nextNode;
            }
            if (word.length() == 1)
                nextNode.isEnd = true;
            if (1 < word.length()) {
                nextNode.add(word.substring(1));
            }
        }

        public boolean search(String word) {
            if (word.length() == 0)
                return this.isEnd;
            char first = word.charAt(0);
            if (first == '.') {
                for (Node nextNode : next) {
                    if (nextNode != null && nextNode.search(word.substring(1)))
                        return true;
                }
                return false;
            }
            Node nextNode = next[first - 'a'];
            if (nextNode == null)
                return false;
            return nextNode.search(word.substring(1));
        }
    }

}
