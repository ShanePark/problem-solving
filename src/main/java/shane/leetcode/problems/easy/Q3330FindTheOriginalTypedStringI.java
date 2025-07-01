package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats87.19%
 */
public class Q3330FindTheOriginalTypedStringI {

    @Test
    public void test() {
        assertThat(possibleStringCount("abbcccc")).isEqualTo(5);
        assertThat(possibleStringCount("abcd")).isEqualTo(1);
        assertThat(possibleStringCount("aaaa")).isEqualTo(4);
    }

    public int possibleStringCount(String word) {
        int answer = 1;
        char before = ' ';
        int curLength = 1;
        for (char c : word.toCharArray()) {
            if (before == c) {
                curLength++;
                continue;
            }
            answer += curLength - 1;
            curLength = 1;
            before = c;
        }
        return answer + curLength - 1;
    }

}
