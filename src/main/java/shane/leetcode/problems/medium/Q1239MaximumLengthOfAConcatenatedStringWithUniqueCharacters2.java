package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 22 ms Beats 47.08% of users with Java
 */
public class Q1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters2 {

    @Test
    public void test() {
        assertThat(maxLength(List.of("jnfbyktlrqumowxd", "mvhgcpxnjzrdei"))).isEqualTo(16);
        assertThat(maxLength(List.of("un", "iq", "ue"))).isEqualTo(4);
        assertThat(maxLength(List.of("cha", "r", "act", "ers"))).isEqualTo(6);
        assertThat(maxLength(List.of("abcdefghijklmnopqrstuvwxyz"))).isEqualTo(26);
        assertThat(maxLength(List.of("aa", "bb"))).isEqualTo(0);
    }

    int max = 0;

    public int maxLength(List<String> arr) {
        max = 0;
        bt(arr, 0, new HashSet<>());
        return max;
    }

    private void bt(List<String> arr, int i, Set<Character> characters) {
        if (arr.size() == i)
            return;
        bt(arr, i + 1, characters);
        String str = arr.get(i);
        Set<Character> curChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            curChars.add(c);
        }
        if (curChars.size() < str.length()) {
            return;
        }
        for (char c : curChars) {
            if (characters.contains(c)) {
                return;
            }
        }
        characters.addAll(curChars);
        max = Math.max(max, characters.size());
        bt(arr, i + 1, characters);
        characters.removeAll(curChars);
    }

}
