package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2416SumOfPrefixScoresOfStrings2 {

    @Test
    public void test() {
        assertThat(sumPrefixScores(new String[]{"abc", "ab", "bc", "b"})).isEqualTo(new int[]{5, 4, 3, 2});
        assertThat(sumPrefixScores(new String[]{"abcd"})).isEqualTo(new int[]{4});
    }

    @Test
    public void tle() {
        int MAX_LENGTH = 1000;
        String[] arr = new String[MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < MAX_LENGTH; j++) {
                char c = (char) (new Random().nextInt(26) + 'a');
                sb.append(c);
            }
            arr[i] = sb.toString();
        }

        assertThat(sumPrefixScores(arr)).hasSize(1000);
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.score++;
            }
        }

        int[] answer = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            TrieNode node = root;
            int score = 0;
            for (char c : words[i].toCharArray()) {
                node = node.children[c - 'a'];
                score += node.score;
            }
            answer[i] = score;
        }
        return answer;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int score = 0;
    }

}
