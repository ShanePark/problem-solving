package shane.leetcode.contest.weekly.w282;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2185CountingWordsWithAGivenPrefix {

    @Test
    void test() {
        Assertions.assertThat(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at")).isEqualTo(2);
    }

    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                cnt++;
            }
        }
        return cnt;
    }

}
