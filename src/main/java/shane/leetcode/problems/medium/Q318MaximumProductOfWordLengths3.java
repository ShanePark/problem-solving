package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 Runtime: 56 ms, faster than 40.15% of Java online submissions for Maximum Product of Word Lengths.
 Memory Usage: 46.9 MB, less than 52.12% of Java online submissions for Maximum Product of Word Lengths.
 */
public class Q318MaximumProductOfWordLengths3 {

    @Test
    public void test() {
        assertThat(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})).isEqualTo(16);
        assertThat(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})).isEqualTo(4);
        assertThat(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})).isEqualTo(0);
    }


    public int maxProduct(String[] words) {
        boolean[][] arr = new boolean[words.length][26];
        for (int i = 0; i < words.length; i++) {
            int length = words[i].length();
            for (int j = 0; j < length; j++) {
                arr[i][words[i].charAt(j) - 'a'] = true;
            }
        }

        int max = 0;
        for (int i = 0; i < words.length; i++) {
            check:
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                int product = words[i].length() * words[j].length();
                if (product <= max)
                    continue;
                for (int k = 0; k < 26; k++) {
                    if (arr[i][k] && arr[j][k]) {
                        continue check;
                    }
                }
                max = product;
            }
        }
        return max;
    }
}
