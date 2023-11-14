package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Time Limit Exceeded
 * 44 / 70 testcases passed
 */
public class Q1930UniqueLength3PalindromicSubsequences {

    @Test
    public void test() {
        assertThat(countPalindromicSubsequence("aabca")).isEqualTo(3);
        assertThat(countPalindromicSubsequence("adc")).isEqualTo(0);
        assertThat(countPalindromicSubsequence("bbcbaba")).isEqualTo(4);
    }

    @Test
    public void tle() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            s.append("a");
        }
        assertThat(countPalindromicSubsequence(s.toString())).isEqualTo(1);
    }

    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (j - i >= 2 && arr[i] == arr[j]) {
                    for (int k = i + 1; k < j; k++) {
                        String str = String.valueOf(arr[i]) + arr[k] + arr[j];
                        set.add(str);
                    }
                }
            }
        }
        return set.size();
    }

}
