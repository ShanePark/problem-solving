package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2325DecodeTheMessage {

    @Test
    public void test() {
        assertThat(decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv")).isEqualTo("this is a secret");
    }

    public String decodeMessage(String key, String message) {
        int[] decode = new int[26];
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c != ' ' && decode[c - 'a'] == 0) {
                decode[c - 'a'] = 'a' + index++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c != ' ') {
                c = (char) decode[c - 'a'];
            }
            sb.append(c);
        }
        return sb.toString();

    }
}
