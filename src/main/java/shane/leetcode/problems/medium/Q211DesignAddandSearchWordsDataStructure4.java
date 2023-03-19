package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 419 ms Beats 88.9%
 * Memory 96.6 MB Beats 50.16%
 */
public class Q211DesignAddandSearchWordsDataStructure4 {

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
            head.add(word, 0);
        }

        public boolean search(String word) {
            return head.search(word, 0);
        }
    }

    class Node {
        char c;
        Node[] next = new Node[26];
        boolean isEnd;

        public Node(char c) {
            this.c = c;
        }

        public void add(String word, int i) {
            if (i == word.length()) {
                this.isEnd = true;
                return;
            }
            char first = word.charAt(i);
            Node nextNode = next[first - 'a'];
            if (nextNode == null) {
                nextNode = new Node(first);
                next[first - 'a'] = nextNode;
            }
            nextNode.add(word, i + 1);
        }

        public boolean search(String word, int i) {
            if (i == word.length())
                return this.isEnd;
            char first = word.charAt(i);
            if (first == '.') {
                for (Node nextNode : next) {
                    if (nextNode != null && nextNode.search(word, i + 1))
                        return true;
                }
                return false;
            }
            Node nextNode = next[first - 'a'];
            if (nextNode == null)
                return false;
            return nextNode.search(word, i + 1);
        }
    }

}
