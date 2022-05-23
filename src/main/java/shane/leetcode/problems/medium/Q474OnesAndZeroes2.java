package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * TLE 4 sec 367 ms
 */
@SuppressWarnings("ALL")
public class Q474OnesAndZeroes2 {

    @Test
    public void test() {
        assertThat(findMaxForm(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"},
                90, 66)).isEqualTo(29);
        assertThat(findMaxForm(new String[]{"111", "1000", "1000", "1000"}, 9, 3)).isEqualTo(3);
        assertThat(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)).isEqualTo(4);
        assertThat(findMaxForm(new String[]{"10", "0", "1"}, 1, 1)).isEqualTo(2);
    }

    int max = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        max = 0;
        dfs(strs, m, n, 0, 0);
        return max;
    }

    private void dfs(String[] strs, int m, int n, int index, int cnt) {
        if (strs.length == index || (m == 0 && n == 0)) {
            max = Math.max(max, cnt);
            return;
        }
        String str = strs[index];
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        if (m >= cnt0 && n >= cnt1) {
            dfs(strs, m - cnt0, n - cnt1, index + 1, cnt + 1);
        }
        dfs(strs, m, n, index + 1, cnt);
    }
}
