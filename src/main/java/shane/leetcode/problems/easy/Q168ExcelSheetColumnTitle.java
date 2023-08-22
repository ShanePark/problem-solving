package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 39.41MB Beats 85.26%of users with Java
 */
public class Q168ExcelSheetColumnTitle {

    @Test
    public void test() {
        assertThat(convertToTitle(701)).isEqualTo("ZY");
        assertThat(convertToTitle(52)).isEqualTo("AZ");
        assertThat(convertToTitle(28)).isEqualTo("AB");
        assertThat(convertToTitle(1)).isEqualTo("A");
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int mod = columnNumber % 26;
            sb.insert(0, (char) ('A' + mod));
            columnNumber /= 26;
        }
        return sb.toString();
    }

}
