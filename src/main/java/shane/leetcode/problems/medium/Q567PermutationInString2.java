package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 111 ms Beats 26.16%
 * Memory 42.8 MB Beats 38.9%
 */
public class Q567PermutationInString2 {

    @Test
    void test() {
        Assertions.assertThat(checkInclusion("adc", "dcda")).isEqualTo(true);
        Assertions.assertThat(checkInclusion("ab", "eidbaooo")).isEqualTo(true);
        Assertions.assertThat(checkInclusion("ab", "eidboaoo")).isEqualTo(false);
        Assertions.assertThat(checkInclusion("ab", "a")).isEqualTo(false);
        Assertions.assertThat(checkInclusion("rokx", "otrxvfszxroxrzdsltg")).isEqualTo(false);
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        loop:
        for (int i = 0; i + length <= s2.length(); i++) {
            int[] arr2 = new int[26];
            for (int j = 0; j < length; j++) {
                char c = s2.charAt(i + j);
                int index = c - 'a';
                arr2[index]++;
                if (arr2[index] > arr[index]) {
                    continue loop;
                }
            }
            return true;
        }
        return false;
    }

}
