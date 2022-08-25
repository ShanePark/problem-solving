package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 99.48% of Java online submissions for Ransom Note.
 * Memory Usage: 42.3 MB, less than 97.49% of Java online submissions for Ransom Note.
 */
public class Q383RansomNote {

    @Test
    public void test() {
        assertThat(canConstruct("a", "b")).isEqualTo(false);
        assertThat(canConstruct("aa", "ab")).isEqualTo(false);
        assertThat(canConstruct("aa", "aab")).isEqualTo(true);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int mLength = magazine.length();
        int rLength = ransomNote.length();
        if (rLength > mLength) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < mLength; i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < rLength; i++) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}
