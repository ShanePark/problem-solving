package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 Runtime: 1641 ms, faster than 5.52% of Java online submissions for Short Encoding of Words.
 Memory Usage: 50 MB, less than 78.53% of Java online submissions for Short Encoding of Words.
 */
public class Q820ShortEncodingOfWords2 {

    @Test
    public void test() {
        assertThat(minimumLengthEncoding(new String[]{"time", "time", "time", "time"})).isEqualTo(5);
        assertThat(minimumLengthEncoding(new String[]{"time", "me", "bell"})).isEqualTo(10);
        assertThat(minimumLengthEncoding(new String[]{"abc", "bc", "c"})).isEqualTo(4);
        assertThat(minimumLengthEncoding(new String[]{"t"})).isEqualTo(2);
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            boolean add = true;
            for (String s : set) {
                if (s.endsWith(words[i])) {
                    add = false;
                    break;
                }
            }
            if (add) {
                set.add(words[i]);
            }
        }
        return set.stream().mapToInt(s -> s.length() + 1).sum();
    }
}
