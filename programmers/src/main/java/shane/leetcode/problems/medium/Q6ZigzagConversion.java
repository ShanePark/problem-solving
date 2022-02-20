package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q6ZigzagConversion {

    @Test
    void test() {
        Assertions.assertThat(convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
        Assertions.assertThat(convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
        Assertions.assertThat(convert("A", 1)).isEqualTo("A");
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < s.length(); i++) {
            int left = i % ((numRows - 1) * 2);
            int val = numRows - 1 - Math.abs(numRows - 1 - left);
            list.get(val).add(s.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        for (List<Character> characters : list) {
            for (Character character : characters) {
                sb.append(character);
            }
        }


        return sb.toString();
    }
}
