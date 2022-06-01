package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2287RearrangeCharactersToMakeTargetString {

    @Test
    public void test() {
        assertThat(rearrangeCharacters("ilovecodingonleetcode", "code")).isEqualTo(2);
        assertThat(rearrangeCharacters("abcba", "abc")).isEqualTo(1);
        assertThat(rearrangeCharacters("abbaccaddaeea", "aaaa")).isEqualTo(1);
        assertThat(rearrangeCharacters("a", "a")).isEqualTo(1);
        assertThat(rearrangeCharacters("a", "b")).isEqualTo(0);
    }

    public int rearrangeCharacters(String s, String target) {
        int[] input = new int[26];
        int[] output = new int[26];
        for (int i = 0; i < s.length(); i++) {
            input[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < target.length(); i++) {
            output[target.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (output[i] != 0) {
                min = Math.min(min, input[i] / output[i]);
            }
        }
        return min;
    }
}
