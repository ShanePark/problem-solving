package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1967NumberOfStringsThatAppearAsSubstringsInWord {

    @Test
    public void test() {
        assertThat(numOfStrings(new String[]{"a", "abc", "bc", "d"}, "abc")).isEqualTo(3);
        assertThat(numOfStrings(new String[]{"a", "b", "c"}, "aaaaabbbbb")).isEqualTo(2);
    }

    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for (String pattern : patterns) {
            if(word.contains(pattern))
                cnt++;
        }
        return cnt;
    }
}
