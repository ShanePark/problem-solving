package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 13ms Beats 8.99%of users with Java
 * Memory Details 45.25MB Beats 13.24%of users with Java
 */
public class Q455AssignCookies {

    @Test
    public void test() {
        assertThat(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1})).isEqualTo(1);
        assertThat(findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3})).isEqualTo(2);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        int cnt = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                cnt++;
                gIndex++;
            }
            sIndex++;
        }
        return cnt;
    }

}
