package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * can't pass first test
 */
public class Q820ShortEncodingOfWords {

    @Test
    public void test() {
        assertThat(minimumLengthEncoding(new String[]{"time", "time", "time", "time"})).isEqualTo(5);
    }
    @Test
    public void test2() {
        assertThat(minimumLengthEncoding(new String[]{"time", "me", "bell"})).isEqualTo(10);
    }
    @Test
    public void test3() {
        assertThat(minimumLengthEncoding(new String[]{"abc", "bc", "c"})).isEqualTo(4);
    }
    @Test
    public void test4() {
        assertThat(minimumLengthEncoding(new String[]{"t"})).isEqualTo(2);
    }

    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Set<String> exceptions = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (i == j)
                    continue;
                if (words[i].endsWith(words[j])) {
                    exceptions.add(words[j]);
                }
            }
        }
        return Arrays.stream(words).filter(s -> !exceptions.contains(s)).mapToInt(s -> s.length() + 1).sum();
    }
}
