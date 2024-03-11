package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q791CustomSortString {

    @Test
    public void test() {
        assertThat(customSortString("cba", "abcd")).isEqualTo("cbad");
        assertThat(customSortString("bcafg", "abcd")).isEqualTo("bcad");
    }

    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : order.toCharArray()) {
            int count = counts[c - 'a'];
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
            counts[c - 'a'] = 0;
        }
        for (int i = 0; i < 26; i++) {
            int count = counts[i];
            char c = (char) ('a' + i);
            for (int j = 0; j < count; j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
