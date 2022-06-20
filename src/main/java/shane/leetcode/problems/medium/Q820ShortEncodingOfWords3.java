package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 24 ms, faster than 79.14% of Java online submissions for Short Encoding of Words.
 * Memory Usage: 54.8 MB, less than 55.21% of Java online submissions for Short Encoding of Words.
 */
public class Q820ShortEncodingOfWords3 {

    @Test
    public void test() {
        assertThat(minimumLengthEncoding(new String[]{"time", "time", "time", "time"})).isEqualTo(5);
        assertThat(minimumLengthEncoding(new String[]{"time", "me", "bell"})).isEqualTo(10);
        assertThat(minimumLengthEncoding(new String[]{"abc", "bc", "c"})).isEqualTo(4);
        assertThat(minimumLengthEncoding(new String[]{"t"})).isEqualTo(2);
    }

    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            for(int i=1; i<word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        return set.stream().mapToInt(s -> s.length() + 1).sum();
    }

}
