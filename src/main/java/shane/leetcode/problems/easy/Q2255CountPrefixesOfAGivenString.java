package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2255CountPrefixesOfAGivenString {

    @Test
    public void test() {
        assertThat(countPrefixes(new String[]{"a","b","c","ab","bc","abc"}, "abc")).isEqualTo(3);
    }

    public int countPrefixes(String[] words, String s) {
        int cnt = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                cnt++;
            }
        }
        return cnt;
    }
}
