package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q893GroupsOfSpecialEquivalentStrings {

    @Test
    public void test() {
        assertThat(numSpecialEquivGroups(new String[]{"abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx"})).isEqualTo(3);
        assertThat(numSpecialEquivGroups(new String[]{"abc", "acb", "bac", "bca", "cab", "cba"})).isEqualTo(3);
    }

    public int numSpecialEquivGroups(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            char[] even = new char[(word.length() + 1) / 2];
            char[] odd = new char[word.length() / 2];
            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0) {
                    even[i / 2] = word.charAt(i);
                } else {
                    odd[i / 2] = word.charAt(i);
                }
            }
            Arrays.sort(odd);
            Arrays.sort(even);

            StringBuilder sb = new StringBuilder();
            for (char c : odd) {
                sb.append(c);
            }
            for (char c : even) {
                sb.append(c);
            }
            map.merge(sb.toString(), 1, Integer::sum);
        }
        return map.size();
    }
}
