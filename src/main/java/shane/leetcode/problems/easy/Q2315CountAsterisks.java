package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2315CountAsterisks {

    @Test
    public void test() {
        assertThat(countAsterisks("l|*e*et|c**o|*de|")).isEqualTo(2);
        assertThat(countAsterisks("iamprogrammer")).isEqualTo(0);
        assertThat(countAsterisks("yo|uar|e**|b|e***au|tifu|l")).isEqualTo(5);
    }

    public int countAsterisks(String s) {
        boolean ex = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                ex = !ex;
            } else if (c == '*' && !ex) {
                count++;
            }
        }
        return count;
    }
}
