package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class Q443StringCompression2 {

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
        int index = 0;
        char before = chars[0];
        int cnt = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (before == c) {
                cnt++;
            } else {
                chars[index++] = before;
                if (cnt > 1) {
                    for (char n : String.valueOf(cnt).toCharArray()) {
                        chars[index++] = n;
                    }
                }
                before = c;
                cnt = 1;
            }
        }

        chars[index++] = before;
        if (cnt > 1) {
            for (char n : String.valueOf(cnt).toCharArray()) {
                chars[index++] = n;
            }
        }

        return index;
    }
}
