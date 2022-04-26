package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1370IncreasingDecreasingString {

    @Test
    public void test() {
        assertThat(sortString("aaaabbbbcccc")).isEqualTo("abccbaabccba");
        assertThat(sortString("rat")).isEqualTo("art");
    }

    public String sortString(String s) {
        int[] arr = new int['z' - 'a' + 1];
        final int LENGTH = s.length();

        for (int i = 0; i < LENGTH; i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < LENGTH) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    sb.append((char) ('a' + i));
                    arr[i]--;
                }
            }
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] > 0) {
                    sb.append((char) ('a' + i));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }

}
