package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 14 ms Beats 52.2% Memory 43 MB Beats 61.93%
 */
public class Q6ZigzagConversion2 {

    @Test
    public void test() {
        assertThat(convert("PAYPALISHIRING", 4)).isEqualTo("PINALSIGYAHRPI");
        assertThat(convert("PAYPALISHIRING", 3)).isEqualTo("PAHNAPLSIIGYIR");
        assertThat(convert("A", 1)).isEqualTo("A");
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }
        int cycle = numRows * 2 - 2;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = i % cycle;
            int rowNum;
            if (index < numRows) {
                rowNum = index;
            } else {
                rowNum = 2 * numRows - index - 2;
            }
            rows.get(rowNum).add(c);
        }
        StringBuilder sb = new StringBuilder();
        rows.stream().forEach(r -> r.stream().forEach(c -> sb.append(c)));
        return sb.toString();
    }

}
