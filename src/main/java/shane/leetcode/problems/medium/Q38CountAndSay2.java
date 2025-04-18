package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats99.58%
 */
public class Q38CountAndSay2 {

    @Test
    public void test() {
        assertThat(countAndSay(4)).isEqualTo("1211");
        assertThat(countAndSay(1)).isEqualTo("1");
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        return rle(countAndSay(n - 1));
    }

    private String rle(String s) {
        StringBuilder sb = new StringBuilder();
        char before = ' ';
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == before) {
                cnt++;
                continue;
            }
            if (cnt > 0) {
                sb.append(cnt);
                sb.append(before);
            }
            before = c;
            cnt = 1;
        }
        sb.append(cnt);
        sb.append(before);
        return sb.toString();
    }

}
