package shane.leetcode.contest.weekly.w294;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(percentageLetter("foobar", 'o')).isEqualTo(33);
        assertThat(percentageLetter("jjjj", 'k')).isEqualTo(0);
    }

    public int percentageLetter(String s, char letter) {
        int length = s.length();
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == letter)
                cnt++;
        }
        return cnt * 100 / length;
    }
}
