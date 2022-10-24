package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 19 ms, faster than 78.24% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 * Memory Usage: 41.8 MB, less than 92.22% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 */
public class Q1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    @Test
    public void test() {
        assertThat(maxLength(List.of("jnfbyktlrqumowxd", "mvhgcpxnjzrdei"))).isEqualTo(16);
        assertThat(maxLength(List.of("aa", "bb"))).isEqualTo(0);
        assertThat(maxLength(List.of("un", "iq", "ue"))).isEqualTo(4);
        assertThat(maxLength(List.of("cha", "r", "act", "ers"))).isEqualTo(6);
        assertThat(maxLength(List.of("abcdefghijklmnopqrstuvwxyz"))).isEqualTo(26);
    }

    int max = 0;

    public int maxLength(List<String> arr) {
        max = 0;
        bt(arr, 0, new HashSet<>());
        return max;
    }

    private void bt(List<String> arr, int i, HashSet<Character> characters) {
        if (i == arr.size()) {
            max = Math.max(max, characters.size());
            return;
        }
        String s = arr.get(i);
        bt(arr, i + 1, characters);

        Set<Character> set = new HashSet<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (characters.contains(c) || set.contains(c)) {
                return;
            }
            set.add(c);
        }
        characters.addAll(set);
        bt(arr, i + 1, characters);
        characters.removeAll(set);
    }

}
