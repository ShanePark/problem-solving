package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1
 * ms
 * Beats
 * 93.67%
 */
public class Q2138DivideAStringIntoGroupsOfSizeK {

    @Test
    public void test() {
        assertThat(divideString("abcdefghi", 3, 'x')).containsExactly("abc", "def", "ghi");
        assertThat(divideString("abcdefghij", 3, 'x')).containsExactly("abc", "def", "ghi", "jxx");
    }

    public String[] divideString(String s, int k, char fill) {
        String[] answer = new String[(s.length() - 1) / k + 1];
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() == k) {
                answer[index++] = sb.toString();
                sb = new StringBuilder();
            }
        }
        if (sb.length() == 0)
            return answer;
        while (sb.length() < k) {
            sb.append(fill);
        }

        answer[index] = sb.toString();
        return answer;
    }

}
