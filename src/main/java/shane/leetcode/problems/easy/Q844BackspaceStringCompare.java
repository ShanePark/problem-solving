package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q844BackspaceStringCompare {

    @Test
    public void test() {
        assertThat(backspaceCompare("ab#c", "ad#c")).isTrue();
        assertThat(backspaceCompare("ab##", "c#d#")).isTrue();
        assertThat(backspaceCompare("a#c", "b")).isFalse();
        assertThat(backspaceCompare("a##c", "#a#c")).isTrue();
    }

    public boolean backspaceCompare(String s, String t) {
        return back(s).equals(back(t));
    }

    private String back(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0)
                    sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
