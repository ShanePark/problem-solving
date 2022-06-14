package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q583DeleteOperationForTwoStrings {

    @Test
    public void test() {
        assertThat(minDistance("a", "b")).isEqualTo(2);
        assertThat(minDistance("sea", "ate")).isEqualTo(4);
        assertThat(minDistance("sea", "eat")).isEqualTo(2);
        assertThat(minDistance("leetcode", "etco")).isEqualTo(4);

        // FAILED
        assertThat(minDistance("park", "spake")).isEqualTo(3);
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() > word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        // word1 is shorter

        int length = 0;
        loop:
        for (int i = word1.length(); i > 0; i--) {
            for (int j = 0; j + i <= word1.length(); j++) {
                String substring = word1.substring(j, j + i);
                if (word2.contains(substring)) {
                    length = i;
                    break loop;
                }
            }
        }

        return word1.length() + word2.length() - 2 * length;
    }

}
