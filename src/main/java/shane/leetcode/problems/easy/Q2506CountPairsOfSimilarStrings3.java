package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 99.27% Memory 41.7 MB Beats 97.62%
 */
public class Q2506CountPairsOfSimilarStrings3 {

    @Test
    public void test() {
        assertThat(similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"})).isEqualTo(2);
        assertThat(similarPairs(new String[]{"aabb", "ab", "ba"})).isEqualTo(3);
        assertThat(similarPairs(new String[]{"nba", "cba", "dba"})).isEqualTo(0);
        assertThat(similarPairs(new String[]{"a", "a", "a", "a"})).isEqualTo(6);

    }

    public int similarPairs(String[] words) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int sum = 0;
        for (String word : words) {
            int bit = 0;
            for (int i = 0; i < word.length(); i++) {
                bit |= 1 << word.charAt(i) - 'a';
            }
            sum += cnt.merge(bit, 1, Integer::sum) - 1;
        }
        return sum;
    }

}
