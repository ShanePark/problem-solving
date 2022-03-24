package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1832CheckIfTheSentenceIsPangram {

    @Test
    public void test() {
        assertThat(checkIfPangram("thequickbrownfoxjumpsoverthelazydog")).isTrue();
        assertThat(checkIfPangram("leetcode")).isFalse();
    }

    public boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        int cnt = 0;
        for (int i = 0; i < sentence.length() && cnt < 26; i++) {
            if (set.add(sentence.charAt(i))) {
                cnt++;
            }
        }
        return cnt == 26;
    }
}
