package shane.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q567PermutationinString {

    @Test
    void test() {
        Assertions.assertThat(checkInclusion("ab", "eidbaooo")).isEqualTo(true);
        Assertions.assertThat(checkInclusion("ab", "eidboaoo")).isEqualTo(false);
        Assertions.assertThat(checkInclusion("adc", "dcda")).isEqualTo(true);
        Assertions.assertThat(checkInclusion("ab", "a")).isEqualTo(false);
        Assertions.assertThat(checkInclusion("rokx", "otrxvfszxroxrzdsltg")).isEqualTo(false);
    }

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] arr = new int['z' - 'a' + 1];
        int[] temp = new int['z' - 'a' + 1];
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            temp[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(arr, temp)) {
            return true;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            temp[s2.charAt(i) - 'a']--;
            temp[s2.charAt(i + s1.length()) - 'a']++;
            if (Arrays.equals(arr, temp)) {
                return true;
            }
        }
        return false;
    }
}
