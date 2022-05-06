package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1209RemoveAllAdjacentDuplicatesInStringII {

    @Test
    public void test() {
        StringBuilder sb = new StringBuilder("aaac");
        assertThat(deleteDuplicates(sb, 3)).isTrue();
        assertThat(sb.toString()).isEqualTo("c");
        assertThat(removeDuplicates("abcd", 2)).isEqualTo("abcd");
        assertThat(removeDuplicates("deeedbbcccbdaa", 3)).isEqualTo("aa");
        assertThat(removeDuplicates("aaaa", 3)).isEqualTo("a");
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        while (deleteDuplicates(sb, k)) {
        }
        return sb.toString();
    }

    private boolean deleteDuplicates(StringBuilder sb, int k) {
        boolean result = false;
        int count = 1;
        char beforeChar = sb.charAt(0);
        for (int i = 1; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == beforeChar) {
                count++;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                    result = true;
                }
            } else {
                beforeChar = c;
                count = 1;
            }
        }
        return result;
    }

}
