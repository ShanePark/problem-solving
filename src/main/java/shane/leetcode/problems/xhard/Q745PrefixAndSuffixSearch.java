package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q745PrefixAndSuffixSearch {

    @Test
    public void test() {
        WordFilter filter = new WordFilter(new String[]{"apple"});
        int f = filter.f("a", "e");
        assertThat(f).isEqualTo(0);
    }

    @Test
    public void test2() {
        WordFilter filter = new WordFilter(new String[]{"apple", "ade"});
        int f = filter.f("a", "e");
        assertThat(f).isEqualTo(1);
    }

    class WordFilter {

        String[] words;

        public WordFilter(String[] words) {
            this.words = words;
        }

        public int f(String prefix, String suffix) {
            for (int i = words.length - 1; i >= 0; i--) {
                String str = words[i];
                if (str.startsWith(prefix) && str.endsWith(suffix)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
