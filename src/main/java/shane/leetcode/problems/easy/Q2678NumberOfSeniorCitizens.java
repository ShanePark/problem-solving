package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q2678NumberOfSeniorCitizens {

    @Test
    public void test() {
        assertThat(countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"})).isEqualTo(2);
        assertThat(countSeniors(new String[]{"1313579440F2036", "2921522980M5644"})).isEqualTo(0);
        assertThat(countSeniors(new String[]{"9751302862F0693", "3888560693F7262", "5485983835F0649", "2580974299F6042", "9976672161M6561", "0234451011F8013", "4294552179O6482"})).isEqualTo(4);
    }

    public int countSeniors(String[] details) {
        int answer = 0;
        for (String detail : details) {
            int age0 = detail.charAt(11) - '0';
            int age1 = detail.charAt(12) - '0';
            if (age0 * 10 + age1 > 60)
                answer++;
        }
        return answer;
    }

}
