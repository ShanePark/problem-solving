package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats100.00%
 */
public class Q3042CountPrefixAndSuffixPairsI {

    @Test
    public void test() {
        assertThat(countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aabaa"})).isEqualTo(4);
        assertThat(countPrefixSuffixPairs(new String[]{"pa", "papa", "ma", "mama"})).isEqualTo(2);
        assertThat(countPrefixSuffixPairs(new String[]{"abab", "ab"})).isEqualTo(0);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
