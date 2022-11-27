package shane.leetcode.contest.weekly.w321;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(appendCharacters("coaching", "coding")).isEqualTo(4);
        assertThat(appendCharacters("abcde", "a")).isEqualTo(0);
        assertThat(appendCharacters("z", "abcde")).isEqualTo(5);
        assertThat(appendCharacters("abcdef", "abcde")).isEqualTo(0);
        assertThat(appendCharacters("abcde", "abcde")).isEqualTo(0);
        assertThat(appendCharacters("abcde", "abcdef")).isEqualTo(1);
    }

    public int appendCharacters(String s, String t) {
        int sLeft = 0;
        int tLeft = 0;
        int sLength = s.length();
        int tLength = t.length();
        while (sLeft < sLength && tLeft < tLength) {
            if (s.charAt(sLeft) == t.charAt(tLeft)) {
                tLeft++;
            }
            sLeft++;
        }

        return tLength - tLeft;
    }

}
