package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q1209RemoveAllAdjacentDuplicatesInStringII2 {

    @Test
    public void test() {
        assertThat(removeDuplicates("deeedbbcccbdaa", 3)).isEqualTo("aa");
        assertThat(removeDuplicates("abcd", 2)).isEqualTo("abcd");
        assertThat(removeDuplicates("aaaa", 3)).isEqualTo("a");
    }

    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder();
        add:
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (sb.length() >= k) {
                boolean delete = true;
                for (int j = 1; j < k; j++) {
                    if (sb.charAt(sb.length() - 1 - j) != c) {
                        delete = false;
                        break;
                    }
                }
                if (delete)
                    sb.delete(sb.length() - k, sb.length());
            }
        }
        return sb.toString();
    }

}
