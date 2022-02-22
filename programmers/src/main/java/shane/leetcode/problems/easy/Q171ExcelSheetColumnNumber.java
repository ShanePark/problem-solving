package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q171ExcelSheetColumnNumber {

    @Test
    void test() {
        Assertions.assertThat(titleToNumber("A")).isEqualTo(1);
        Assertions.assertThat(titleToNumber("AB")).isEqualTo(28);
        Assertions.assertThat(titleToNumber("ZY")).isEqualTo(701);
        Assertions.assertThat(titleToNumber("AAA")).isEqualTo(703);
    }

    public int titleToNumber(String columnTitle) {
        int sum = 0;
        for (int i = columnTitle.length() - 1, digit = 1; i >= 0; i--, digit *= 26) {
            sum += (columnTitle.charAt(i) - 'A' + 1) * digit;
        }
        return sum;
    }

}
