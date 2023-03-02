package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime 1 ms Beats 98.42%
 * Memory 42 MB Beats 47.21%
 */
public class Q443StringCompression3 {

    @Test
    public void test() {
        char[] arr = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        assertThat(compress(arr)).isEqualTo(6);
        assertThat(arr).containsExactly('a', '2', 'b', '2', 'c', '3', 'c');
        assertThat(compress(new char[]{'a'})).isEqualTo(1);
        assertThat(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'})).isEqualTo(4);
    }

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char before = chars[0];
        int cnt = 0;
        for (char c : chars) {
            if (c != before) {
                append(sb, before, cnt);
                cnt = 0;
            }
            before = c;
            cnt++;
        }
        append(sb, before, cnt);

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }

        return sb.length();
    }

    private static void append(StringBuilder sb, char before, int cnt) {
        sb.append(before);
        if (cnt > 1) {
            sb.append(cnt);
        }
    }

}
