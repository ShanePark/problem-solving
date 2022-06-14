package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q583DeleteOperationForTwoStrings2 {

    @Test
    public void test() {
        // 2min 46 sec
        assertThat(minDistance("pvhvykrvntdywrhylaprgqmbzqitrhdmxboyw", "oelftlrthdmlwznwuritwrvdciho")).isEqualTo(45);
        assertThat(include("altruism", "asm")).isTrue();
        assertThat(minDistance("plasma", "altruism")).isEqualTo(8);
        assertThat(minDistance("park", "spake")).isEqualTo(3);
        assertThat(minDistance("a", "b")).isEqualTo(2);
        assertThat(minDistance("sea", "ate")).isEqualTo(4);
        assertThat(minDistance("sea", "eat")).isEqualTo(2);
        assertThat(minDistance("leetcode", "etco")).isEqualTo(4);
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        // word1 is shorter

        int length = 0;
        for (int i = word1.length(); i > 0; i--) {
            System.out.println("i = " + i);
            if (check(word1, i, word2)) {
                length = i;
                break;
            }
        }

        return word1.length() + word2.length() - 2 * length;
    }

    private boolean check(String word1, int length, String word2) {
        Set<String> set = new HashSet<>();
        dfs(new StringBuilder(), word1, length, 0, set);
        for (String s : set) {
            if (include(word2, s))
                return true;
        }
        return false;
    }

    private boolean include(String word2, String s) {
        int pointer = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (word2.charAt(i) == s.charAt(pointer)) {
                pointer++;
                if (pointer == s.length())
                    return true;
            }
        }
        return false;
    }

    private void dfs(StringBuilder sb, String word1, int length, int i, Set<String> set) {
        if (sb.length() == length) {
            set.add(sb.toString());
            return;
        }
        if (i == word1.length())
            return;

        dfs(sb, word1, length, i + 1, set);

        sb.append(word1.charAt(i));
        dfs(sb, word1, length, i + 1, set);
        sb.deleteCharAt(sb.length() - 1);
    }

}
