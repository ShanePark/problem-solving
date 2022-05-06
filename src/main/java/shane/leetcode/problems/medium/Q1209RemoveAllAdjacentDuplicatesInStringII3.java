package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q1209RemoveAllAdjacentDuplicatesInStringII3 {

    @Test
    public void test() {
        assertThat(removeDuplicates("deeedbbcccbdaa", 3)).isEqualTo("aa");
        assertThat(removeDuplicates("abcd", 2)).isEqualTo("abcd");
        assertThat(removeDuplicates("aaaa", 3)).isEqualTo("a");
    }

    public String removeDuplicates(String s, int k) {
        int[] arr = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            arr[sb.length() - 1] = 1;
            if (sb.length() > 1 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
                arr[sb.length() - 1] = arr[sb.length() - 2] + 1;
            }
            if (arr[sb.length() - 1] >= k)
                sb.delete(sb.length() - k, sb.length());
        }
        return sb.toString();
    }

}
