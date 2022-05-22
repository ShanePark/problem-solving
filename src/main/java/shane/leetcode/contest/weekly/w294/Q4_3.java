package shane.leetcode.contest.weekly.w294;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("DuplicatedCode")
public class Q4_3 {

    @Test
    public void test() {
        assertThat(totalStrength(new int[]{1, 3, 1, 2})).isEqualTo(44);
        assertThat(totalStrength(new int[]{5, 4, 6})).isEqualTo(213);
        assertThat(totalStrength(new int[]{747, 812, 112, 1230, 1426, 1477, 1388, 976, 849, 1431, 1885, 1845, 1070, 1980, 280, 1075, 232, 1330, 1868, 1696, 1361, 1822, 524, 1899, 1904, 538, 731, 985, 279, 1608, 1558, 930, 1232, 1497, 875, 1850, 1173, 805, 1720, 33, 233, 330, 1429, 1688, 281, 362, 1963, 927, 1688, 256, 1594, 1823, 743, 553, 1633, 1898, 1101, 1278, 717, 522, 1926, 1451, 119, 1283, 1016, 194, 780, 1436, 1233, 710, 1608, 523, 874, 1779, 1822, 134, 1984}))
                .isEqualTo(471441678);
    }

    public int totalStrength(int[] strength) {
        long answer = 0;
        for (int i = 0; i < strength.length; i++) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = i; j < strength.length; j++) {
                min = Math.min(min, strength[j]);
                sum += strength[j];
                answer += min * sum;
            }
        }
        return (int) (answer % (1000000007));
    }

}
