package shane.leetcode.contest.weekly.w309;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        assertThat(longestNiceSubarray(new int[]{744437702, 379056602, 145555074, 392756761, 560864007, 934981918, 113312475, 1090, 16384, 33, 217313281, 117883195, 978927664})).isEqualTo(3);
        assertThat(longestNiceSubarray(new int[]{1, 3, 8, 48, 10})).isEqualTo(3);
        assertThat(longestNiceSubarray(new int[]{3, 1, 5, 11, 13})).isEqualTo(1);
    }

    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 1;
            for (int j = i + 1; j < nums.length; j++) {
                boolean flag = true;
                for (int k = i; k < j; k++) {
                    if ((nums[k] & nums[j]) != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }

}
