package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.8 MB Beats 85.41%
 */
public class Q953VerifyingAnAlienDictionary {

    @Test
    public void test() {
        assertThat(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz")).isTrue();
        assertThat(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz")).isFalse();
        assertThat(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz")).isFalse();
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArr = new int[26];
        for (int i = 0; i < 26; i++) {
            char c = order.charAt(i);
            orderArr[c - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            boolean aIsBigger = aIsBiggerThanB(cur, next, orderArr);
            if (aIsBigger)
                return false;
        }
        return true;
    }

    private boolean aIsBiggerThanB(String a, String b, int[] orderArr) {
        int length = Math.min(a.length(), b.length());
        for (int i = 0; i < length; i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (orderArr[c1 - 'a'] > orderArr[c2 - 'a']) {
                return true;
            } else if (orderArr[c1 - 'a'] != orderArr[c2 - 'a']) {
                return false;
            }
        }
        return a.length() > b.length();
    }

}
