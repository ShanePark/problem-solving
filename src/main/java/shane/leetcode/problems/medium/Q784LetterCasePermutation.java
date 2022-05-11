package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q784LetterCasePermutation {

    @Test
    public void test() {
        assertThat(letterCasePermutation("a1b2")).containsExactlyInAnyOrder("a1b2", "a1B2", "A1b2", "A1B2");
        assertThat(letterCasePermutation("3z4")).containsExactlyInAnyOrder("3z4", "3Z4");
    }

    public List<String> letterCasePermutation(String s) {
        List<String> list = new ArrayList<>();
        list.add(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                List<String> temp = new ArrayList<>();
                for (String str : list) {
                    temp.add(str.substring(0, i) + (Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c)) + str.substring(i + 1));
                }
                list.addAll(temp);
            }
        }
        return list;
    }
}
