package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * it was out of intent of the problem
 */
public class Q443StringCompression {

    @Test
    public void test() {
        assertThat(compress(stringsToChars("\"a\""))).isEqualTo(1);
        char[] chars = stringsToChars("\"a\",\"a\",\"b\",\"b\",\"c\",\"c\",\"c\"");
        assertThat(compress(chars)).isEqualTo(6);
        assertThat(chars).containsExactly('a', '2', 'b', '2', 'c', '3', 'c');
        assertThat(compress(stringsToChars("\"a\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\",\"b\""))).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(compress(stringsToChars("\"a\",\"a\",\"a\",\"b\",\"b\",\"a\",\"a\""))).isEqualTo(6);
    }

    public char[] stringsToChars(String str) {
        String[] strArr = str.split(",");
        char[] chars = new char[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            chars[i] = strArr[i].charAt(1);
        }
        return chars;
    }

    public int compress(char[] chars) {
        int[] arr = new int[26];
        for (char c : chars) {
            arr[c - 'a']++;
        }
        int cnt = 0;
        for (int i : arr) {
            if (i == 1) {
                cnt++;
            } else if (i > 1) {
                cnt += (int) Math.log10(i) + 2;
            }
        }
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                chars[index++] = (char) ('a' + i);
                if (arr[i] > 1) {
                    for (char c : String.valueOf(arr[i]).toCharArray()) {
                        chars[index++] = c;
                    }
                }
            }
        }
        return cnt;
    }
}
