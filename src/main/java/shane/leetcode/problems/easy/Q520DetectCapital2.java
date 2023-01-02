package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 100%
 * Memory 40.5 MB Beats 95.10%
 */
public class Q520DetectCapital2 {

    @Test
    public void test() {
        assertThat(detectCapitalUse("USA")).isTrue();
        assertThat(detectCapitalUse("FlaG")).isFalse();
        assertThat(detectCapitalUse("Google")).isTrue();
        assertThat(detectCapitalUse("leetcode")).isTrue();
    }

    public boolean detectCapitalUse(String word) {
        final int LENGTH = word.length();
        int capitalCnt = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (word.charAt(i) <= 'Z') {
                capitalCnt++;
            }
        }

        if (LENGTH == capitalCnt)
            return true;
        if (capitalCnt == 1 && word.charAt(0) <= 'Z')
            return true;
        if (capitalCnt == 0)
            return true;
        return false;
    }

}
