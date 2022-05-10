package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2124CheckIfAllAsAppearsBeforeAllBs {

    @Test
    public void test() {
        assertThat(checkString("aaabbb")).isTrue();
        assertThat(checkString("abab")).isFalse();
        assertThat(checkString("bbb")).isTrue();
        assertThat(checkString("aaa")).isTrue();
    }

    public boolean checkString(String s) {
        return s.indexOf('b') < 0 || s.indexOf('b') > s.lastIndexOf('a');
    }

}
