package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Runtime 7 ms Beats 65.80%
 * Memory 42.3 MB Beats 65.42%
 */
public class Q567PermutationInString3 {

    @Test
    void test() {
        Assertions.assertThat(checkInclusion("adc", "dcda")).isEqualTo(true);
        Assertions.assertThat(checkInclusion("ab", "eidbaooo")).isEqualTo(true);
        Assertions.assertThat(checkInclusion("ab", "eidboaoo")).isEqualTo(false);
        Assertions.assertThat(checkInclusion("ab", "a")).isEqualTo(false);
        Assertions.assertThat(checkInclusion("rokx", "otrxvfszxroxrzdsltg")).isEqualTo(false);
    }

    public boolean checkInclusion(String s1, String s2) {
        int length = s1.length();
        if (length > s2.length())
            return false;

        int[] arr = new int[26];
        for (int i = 0; i < length; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }

        long zeroCount = Arrays.stream(arr).filter(i -> i == 0).count();

        for (int i = length; i < s2.length() && zeroCount < 26; i++) {
            char c = s2.charAt(i);
            char before = s2.charAt(i - length);
            int beforeCharCount = ++arr[before - 'a'];
            if (beforeCharCount == 0) {
                zeroCount++;
            } else if (beforeCharCount == 1) {
                zeroCount--;
            }
            int curCharCount = --arr[c - 'a'];
            if (curCharCount == 0) {
                zeroCount++;
            } else if (curCharCount == -1) {
                zeroCount--;
            }
        }
        return zeroCount == 26;
    }

}
