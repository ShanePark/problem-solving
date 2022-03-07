package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2125NumberOfLaserBeamsInABank {

    @Test
    void test() {
        Assertions.assertThat(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"})).isEqualTo(8);
        Assertions.assertThat(numberOfBeams(new String[]{"000", "111", "000"})).isEqualTo(0);
    }

    public int numberOfBeams(String[] bank) {
        int devices = 0;
        int total = 0;
        for (int i = 0; i < bank.length; i++) {
            int cnt = countDevices(bank[i]);
            if (cnt > 0) {
                total += devices * cnt;
                devices = cnt;
            }
        }
        return total;
    }

    private int countDevices(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
