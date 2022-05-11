package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q784LetterCasePermutation2 {

    @Test
    public void test() {
        assertThat(letterCasePermutation("a1b2")).containsExactlyInAnyOrder("a1b2", "a1B2", "A1b2", "A1B2");
        assertThat(letterCasePermutation("3z4")).containsExactlyInAnyOrder("3z4", "3Z4");
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        bt(list, 0, s.toCharArray());
        return list;
    }

    private void bt(List<String> list, int i, char[] arr) {
        if (i == arr.length) {
            list.add(String.valueOf(arr));
            return;
        }

        if (Character.isAlphabetic(arr[i])) {
            arr[i] = Character.toUpperCase(arr[i]);
            bt(list, i + 1, arr);
            arr[i] = Character.toLowerCase(arr[i]);
        }

        bt(list, i + 1, arr);
    }
}
