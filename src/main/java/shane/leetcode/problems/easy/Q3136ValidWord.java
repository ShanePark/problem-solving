package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats99.12%
 */
public class Q3136ValidWord {

    @Test
    public void test() {
        assertThat(isValid("234Adas")).isTrue();
        assertThat(isValid("b32")).isFalse();
        assertThat(isValid("a3")).isFalse();
    }

    public boolean isValid(String word) {
        if (word.length() < 3)
            return false;
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for (char c : word.toLowerCase().toCharArray()) {
            if ('0' <= c && c <= '9')
                continue;
            if ('a' <= c && c <= 'z') {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        hasVowel = true;
                        break;
                    default:
                        hasConsonant = true;
                }
                continue;
            }
            return false;
        }
        return hasVowel && hasConsonant;
    }

}
