package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static shane.leetcode.problems.xhard.Q336PalindromePairs_TESTCASE1.testCase1;
import static shane.leetcode.problems.xhard.Q336PalindromePairs_TESTCASE2.testCase2;

/**
 * still TLE, same code passed in Kotlin
 */
@SuppressWarnings("ALL")
public class Q336PalindromePairs4 {

    @Test
    public void test() {
        assertThat(palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"})).isEqualTo(Ps.intList("[[0,1],[1,0],[2,4],[3,2]]"));
        assertThat(palindromePairs(new String[]{"bat", "tab", "cat"})).isEqualTo(Ps.intList("[[0,1],[1,0]]"));
        assertThat(palindromePairs(new String[]{"a", ""})).isEqualTo(Ps.intList("[[0,1],[1,0]]"));
    }

    @Test
    public void tle() {
        assertThat(palindromePairs(testCase1)).hasSize(4869);
    }

    /**
     * 163 ms
     */
    @Test
    public void tle2() {
        assertThat(palindromePairs(testCase2)).hasSize(56);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> answer = new ArrayList<>();
        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            search(words, i, root, answer);
        }

        return answer;
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i);

            if (root.next[j - 'a'] == null) {
                root.next[j - 'a'] = new TrieNode();
            }

            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j - 'a'];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> answer) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                answer.add(List.of(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null)
                return;
        }

        for (int j : root.list) {
            if (i == j)
                continue;
            answer.add(List.of(i, j));
        }
    }

    private boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) return false;
        }
        return true;
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int index = -1;
        List<Integer> list = new ArrayList<>();
    }

}
