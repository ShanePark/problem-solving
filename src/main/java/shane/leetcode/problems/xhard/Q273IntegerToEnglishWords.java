package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats100.00%
 */
public class Q273IntegerToEnglishWords {

    @Test
    public void test() {
        assertThat(numberToWords(110)).isEqualTo("One Hundred Ten");
        assertThat(numberToWords(10)).isEqualTo("Ten");
        assertThat(numberToWords(20)).isEqualTo("Twenty");
        assertThat(numberToWords(Integer.MAX_VALUE)).isEqualTo("Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven");
        assertThat(numberToWords(123)).isEqualTo("One Hundred Twenty Three");
        assertThat(numberToWords(12345)).isEqualTo("Twelve Thousand Three Hundred Forty Five");
        assertThat(numberToWords(1234567)).isEqualTo("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
        assertThat(numberToWords(0)).isEqualTo("Zero");
        assertThat(numberToWords(1)).isEqualTo("One");
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        int billion = num / 1_000_000_000;
        num -= billion * 1_000_000_000;
        int million = num / 1_000_000;
        num -= million * 1_000_000;
        int thousand = num / 1000;
        num -= thousand * 1000;
        StringBuilder sb = new StringBuilder();
        if (billion > 0) {
            sb.append(print(billion)).append(" Billion");
        }
        if (million > 0) {
            addSpace(sb);
            sb.append(print(million)).append(" Million");
        }
        if (thousand > 0) {
            addSpace(sb);
            sb.append(print(thousand)).append(" Thousand");
        }
        if (num > 0) {
            addSpace(sb);
            sb.append(print(num));
        }
        return sb.toString();
    }

    String[] NUMS = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] TENS = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] TEENS = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    private String print(int num) {
        if (num == 0)
            return "";
        int hundred = num / 100;
        num -= hundred * 100;
        int ten = num / 10;
        num -= ten * 10;
        StringBuilder sb = new StringBuilder();
        if (hundred > 0) {
            sb.append(NUMS[hundred]).append(" Hundred");
        }
        if (ten == 1) {
            addSpace(sb);
            sb.append(TEENS[num]);
            return sb.toString();
        }
        if (ten > 0) {
            addSpace(sb);
            sb.append(TENS[ten]);
        }
        if (num > 0) {
            addSpace(sb);
            sb.append(NUMS[num]);
        }
        return sb.toString();
    }

    private static void addSpace(StringBuilder sb) {
        if (sb.length() > 0) {
            sb.append(" ");
        }
    }

}
