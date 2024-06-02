package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q344ReverseString2 {

    @Test
    public void test() {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        assertThat(arr).containsExactly('o', 'l', 'l', 'e', 'h');
    }

    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char tmp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = tmp;
        }
    }

}
