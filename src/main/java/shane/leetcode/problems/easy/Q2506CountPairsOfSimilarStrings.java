package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 92.77% Memory 42 MB Beats 91.99%
 */
public class Q2506CountPairsOfSimilarStrings {

    @Test
    public void test() {
        assertThat(similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"})).isEqualTo(2);
        assertThat(similarPairs(new String[]{"aabb", "ab", "ba"})).isEqualTo(3);
        assertThat(similarPairs(new String[]{"nba", "cba", "dba"})).isEqualTo(0);
        assertThat(similarPairs(new String[]{"a", "a", "a", "a"})).isEqualTo(6);

    }

    public int similarPairs(String[] words) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String word : words) {
            cnt.merge(toDict(word), 1, Integer::sum);
        }
        int sum = 0;
        for (Integer value : cnt.values()) {
            sum += (value) * (value - 1) / 2;
        }
        return sum;
    }

    private String toDict(String word) {
        int[] arr = new int[26];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
