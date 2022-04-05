package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q344ReverseString {

    @Test
    public void test() {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        assertThat(arr).containsExactly('o', 'l', 'l', 'e', 'h');
    }

    public void reverseString(char[] s) {
        char[] copy = Arrays.copyOf(s, s.length);
        for (int i = 0; i < s.length; i++) {
            s[i] = copy[s.length - 1 - i];
        }
    }

}
