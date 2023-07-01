package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BackTracking idea from Editorial
 */
public class Q2305FairDistributionOfCookies {

    @Test
    void test() {
        assertThat(distributeCookies(new int[]{8, 15, 10, 20, 8}, 2)).isEqualTo(31);
        assertThat(distributeCookies(new int[]{6, 1, 3, 2, 2, 4, 1, 2}, 3)).isEqualTo(7);
    }

    public int distributeCookies(int[] cookies, int k) {
        int[] distribute = new int[k];

        return dfs(0, distribute, cookies, k);
    }

    private int dfs(int index, int[] distribute, int[] cookies, int emptyCnt) {
        if (cookies.length - index < emptyCnt) {
            return Integer.MAX_VALUE;
        }
        if (index == cookies.length) {
            int max = 0;
            for (int value : distribute) {
                max = Math.max(max, value);
            }
            return max;
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < distribute.length; j++) {
            boolean isEmpty = distribute[j] == 0;
            if (isEmpty) emptyCnt--;
            distribute[j] += cookies[index];

            int dfs = dfs(index + 1, distribute, cookies, emptyCnt);
            answer = Math.min(answer, dfs);

            distribute[j] -= cookies[index];
            if (isEmpty) emptyCnt++;

        }

        return answer;
    }

}
