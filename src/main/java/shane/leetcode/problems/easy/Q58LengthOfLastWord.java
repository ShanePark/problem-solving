package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q58LengthOfLastWord {

    @Test
    public void test() {
        assertThat(lengthOfLastWord("Hello World")).isEqualTo(5);
        assertThat(lengthOfLastWord("   fly me   to   the moon  ")).isEqualTo(4);
        assertThat(lengthOfLastWord("luffy is still joyboy")).isEqualTo(6);
        assertThat(lengthOfLastWord(" ")).isEqualTo(0);
    }

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if (split.length == 0)
            return 0;
        return split[split.length - 1].length();
    }

}
