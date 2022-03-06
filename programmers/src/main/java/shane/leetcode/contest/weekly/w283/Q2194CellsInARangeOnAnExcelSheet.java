package shane.leetcode.contest.weekly.w283;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2194CellsInARangeOnAnExcelSheet {

    @Test
    void test() {
        Assertions.assertThat(cellsInRange("K1:L2")).containsExactly("K1", "K2", "L1", "L2");
    }

    public List<String> cellsInRange(String s) {
        char col1 = s.charAt(0);
        int num1 = s.charAt(1) - '0';
        char col2 = s.charAt(3);
        int num2 = s.charAt(4) - '0';
        List<String> answer = new ArrayList<>();
        for (char c = col1; c <= col2; c++) {
            for (int i = num1; i <= num2; i++) {
                answer.add(c + String.valueOf(i));
            }
        }
        return answer;
    }
}
