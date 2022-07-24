package shane.leetcode.contest.weekly.w303;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(repeatedCharacter("abccbaacz")).isEqualTo('c');
        assertThat(repeatedCharacter("abcdd")).isEqualTo('d');
    }

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                return c;
            }
        }
        return ' ';
    }

}
