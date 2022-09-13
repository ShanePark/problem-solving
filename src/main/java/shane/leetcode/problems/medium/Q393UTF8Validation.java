package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 877 ms, faster than 5.18% of Java online submissions for UTF-8 Validation.
 * Memory Usage: 70.9 MB, less than 5.18% of Java online submissions for UTF-8 Validation.
 */
public class Q393UTF8Validation {

    @Test
    public void test() {
        assertThat(validUtf8(new int[]{250, 145, 145, 145, 145})).isEqualTo(false);
        assertThat(validUtf8(new int[]{255})).isEqualTo(false);
        assertThat(validUtf8(new int[]{197, 130, 1})).isEqualTo(true);
        assertThat(validUtf8(new int[]{235, 140, 4})).isEqualTo(false);
    }

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; ) {
            String first = toBinary(data[i]);
            int bytes = 0;
            for (int j = 0; j < first.length(); j++, bytes++) {
                if (first.charAt(j) != '1') {
                    break;
                }
            }
            bytes = bytes == 0 ? 1 : bytes;
            if (bytes > 4 || data.length < i + bytes || !check(data, i, bytes))
                return false;
            i += bytes;
        }
        return true;
    }

    private boolean check(int[] data, int start, int bytes) {
        if (bytes == 1) {
            return !toBinary(data[start]).startsWith("1");
        }

        for (int i = 1; i < bytes; i++) {
            if (!toBinary(data[start + i]).startsWith("10")) {
                return false;
            }
        }
        return true;
    }

    private static String toBinary(int n) {
        return String.format("%8s", Integer.toBinaryString(n));
    }
}
