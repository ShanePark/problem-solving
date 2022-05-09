package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q17LetterCombinationsOfAPhoneNumber {

    @Test
    public void test() {
        assertThat(letterCombinations("23")).containsExactly("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        assertThat(letterCombinations("")).isEmpty();
        assertThat(letterCombinations("2")).containsExactly("a", "b", "c");
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[][] buttons = {{},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };
        for (int i = 0; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            if (result.isEmpty())
                result.add("");
            for (String s : result) {
                for (char c : buttons[digits.charAt(i) - '0']) {
                    temp.add(s + c);
                }
            }
            result = temp;
        }
        return result;
    }
}
