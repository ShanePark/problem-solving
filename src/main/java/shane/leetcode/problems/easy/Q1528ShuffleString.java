package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1528ShuffleString {

    @Test
    void test() {
        Assertions.assertThat(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3})).isEqualTo("leetcode");
        Assertions.assertThat(restoreString("abc", new int[]{0, 1, 2})).isEqualTo("abc");
    }

    public String restoreString(String s, int[] indices) {
        char[] answer = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            answer[indices[i]] = s.charAt(i);
        }

        return String.copyValueOf(answer);

    }
}
