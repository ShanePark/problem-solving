package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 113ms
 * Beats81.69%
 */
public class Q3484DesignSpreadsheet {

    @Test
    public void test() {
        Spreadsheet spreadsheet = new Spreadsheet(3);
        assertThat(spreadsheet.getValue("=5+7")).isEqualTo(12);
        spreadsheet.setCell("A1", 10);
        assertThat(spreadsheet.getValue("=A1+6")).isEqualTo(16);
        spreadsheet.setCell("B2", 15);
        assertThat(spreadsheet.getValue("=A1+B2")).isEqualTo(25);
        spreadsheet.resetCell("A1");
        assertThat(spreadsheet.getValue("=A1+B2")).isEqualTo(15);
    }

    class Spreadsheet {
        Map<String, Integer> map = new HashMap<>();

        public Spreadsheet(int rows) {

        }

        public void setCell(String cell, int value) {
            map.put(cell, value);
        }

        public void resetCell(String cell) {
            map.remove(cell);
        }

        public int getValue(String formula) {
            String[] split = formula.substring(1).split("\\+");
            int sum = 0;
            for (String s : split) {
                char first = s.charAt(0);
                if ('A' <= first && first <= 'Z') {
                    sum += map.getOrDefault(s, 0);
                    continue;
                }
                sum += Integer.parseInt(s);
            }
            return sum;
        }
    }

}
