package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 4 ms, faster than 85.69% of Java online submissions for Count and Say.
 * Memory Usage: 42.2 MB, less than 56.66% of Java online submissions for Count and Say.
 */
public class Q38CountAndSay {

    @Test
    public void test() {
        assertThat(countAndSay(1)).isEqualTo("1");
        assertThat(countAndSay(2)).isEqualTo("11");
        assertThat(countAndSay(3)).isEqualTo("21");
        assertThat(countAndSay(4)).isEqualTo("1211");
    }

    @Test
    public void testSay() {
        assertThat(say("1")).isEqualTo("11");
        assertThat(say("11")).isEqualTo("21");
    }

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 0; i < n - 1; i++) {
            str = say(str);
        }

        return str;
    }

    private String say(String str) {
        StringBuilder sb = new StringBuilder();
        char before = str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (before != c) {
                sb.append(cnt);
                sb.append(before);
                before = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }
        sb.append(cnt).append(before);
        return sb.toString();
    }
}
