package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q709ToLowerCase {

    @Test
    public void test() {
        assertThat(toLowerCase("Hello")).isEqualTo("hello");
    }

    public String toLowerCase(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[i] = ('A' <= c && c <= 'Z') ? (char) (c + 32) : c;
        }

        return String.valueOf(arr);
    }
}
