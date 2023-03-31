package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 131 ms Beats 5.63%
 * Memory 44 MB Beats 6.29%
 */
public class Q1444NumberOfWaysOfCuttingAPizza {

    @Test
    public void test() {
        String[] arr = {"A..", "AAA", "..."};
        assertThat(countApple(arr, 0, 1)).isEqualTo(2);
        assertThat(ways(arr, 3)).isEqualTo(3);
        assertThat(ways(new String[]{"A..", "AA.", "..."}, 3)).isEqualTo(1);
        assertThat(ways(new String[]{"A..", "A..", "..."}, 1)).isEqualTo(1);
    }

    @Test
    public void tle() {
        assertThat(ways(new String[]{"..A.A.AAA...AAAAAA.AA..A..A.A......A.AAA.AAAAAA.AA", "A.AA.A.....AA..AA.AA.A....AAA.A........AAAAA.A.AA.", "A..AA.AAA..AAAAAAAA..AA...A..A...A..AAA...AAAA..AA", "....A.A.AA.AA.AA...A.AA.AAA...A....AA.......A..AA.", "AAA....AA.A.A.AAA...A..A....A..AAAA...A.A.A.AAAA..", "....AA..A.AA..A.A...A.A..AAAA..AAAA.A.AA..AAA...AA", "A..A.AA.AA.A.A.AA..A.A..A.A.AAA....AAAAA.A.AA..A.A", ".AA.A...AAAAA.A..A....A...A.AAAA.AA..A.AA.AAAA.AA.", "A.AA.AAAA.....AA..AAA..AAAAAAA...AA.A..A.AAAAA.A..", "A.A...A.A...A..A...A.AAAA.A..A....A..AA.AAA.AA.AA.", ".A.A.A....AAA..AAA...A.AA..AAAAAAA.....AA....A....", "..AAAAAA..A..A...AA.A..A.AA......A.AA....A.A.AAAA.", "...A.AA.AAA.AA....A..AAAA...A..AAA.AAAA.A.....AA.A", "A.AAAAA..A...AAAAAAAA.AAA.....A.AAA.AA.A..A.A.A...", "A.A.AA...A.A.AA...A.AA.AA....AA...AA.A..A.AA....AA", "AA.A..A.AA..AAAAA...A..AAAAA.AA..AA.AA.A..AAAAA..A", "...AA....AAAA.A...AA....AAAAA.A.AAAA.A.AA..AA..AAA", "..AAAA..AA..A.AA.A.A.AA...A...AAAAAAA..A.AAA..AA.A", "AA....AA....AA.A......AAA...A...A.AA.A.AA.A.A.AA.A", "A.AAAA..AA..A..AAA.AAA.A....AAA.....A..A.AA.A.A...", "..AA...AAAAA.A.A......AA...A..AAA.AA..A.A.A.AA..A.", ".......AA..AA.AAA.A....A...A.AA..A.A..AAAAAAA.AA.A", ".A.AAA.AA..A.A.A.A.A.AA...AAAA.A.A.AA..A...A.AAA..", "A..AAAAA.A..A..A.A..AA..A...AAA.AA.A.A.AAA..A.AA..", "A.AAA.A.AAAAA....AA..A.AAA.A..AA...AA..A.A.A.AA.AA", ".A..AAAA.A.A.A.A.......AAAA.AA...AA..AAA..A...A.AA", "A.A.A.A..A...AA..A.AAA..AAAAA.AA.A.A.A..AA.A.A....", "A..A..A.A.AA.A....A...A......A.AA.AAA..A.AA...AA..", ".....A..A...A.A...A..A.AA.A...AA..AAA...AA..A.AAA.", "A...AA..A..AA.A.A.AAA..AA..AAA...AAA..AAA.AAAAA...", "AA...AAA.AAA...AAAA..A...A..A...AA...A..AA.A...A..", "A.AA..AAAA.AA.AAA.A.AA.A..AAAAA.A...A.A...A.AA....", "A.......AA....AA..AAA.AAAAAAA.A.AA..A.A.AA....AA..", ".A.A...AA..AA...AA.AAAA.....A..A..A.AA.A.AA...A.AA", "..AA.AA.AA..A...AA.AA.AAAAAA.....A.AA..AA......A..", "AAA..AA...A....A....AA.AA.AA.A.A.A..AA.AA..AAA.AAA", "..AAA.AAA.A.AA.....AAA.A.AA.AAAAA..AA..AA.........", ".AA..A......A.A.AAA.AAAA...A.AAAA...AAA.AAAA.....A", "AAAAAAA.AA..A....AAAA.A..AA.A....AA.A...A.A....A..", ".A.A.AA..A.AA.....A.A...A.A..A...AAA..A..AA..A.AAA", "AAAA....A...A.AA..AAA..A.AAA..AA.........AA.AAA.A.", "......AAAA..A.AAA.A..AAA...AAAAA...A.AA..A.A.AA.A.", "AA......A.AAAAAAAA..A.AAA...A.A....A.AAA.AA.A.AAA.", ".A.A....A.AAA..A..AA........A.AAAA.AAA.AA....A..AA", ".AA.A...AA.AAA.A....A.A...A........A.AAA......A...", "..AAA....A.A...A.AA..AAA.AAAAA....AAAAA..AA.AAAA..", "..A.AAA.AA..A.AA.A...A.AA....AAA.A.....AAA...A...A", ".AA.AA...A....A.AA.A..A..AAA.A.A.AA.......A.A...A.", "...A...A.AA.A..AAAAA...AA..A.A..AAA.AA...AA...A.A.", "..AAA..A.A..A..A..AA..AA...A..AA.AAAAA.A....A..A.A"}
                , 8)).isEqualTo(641829390);
    }

    Map<String, Integer> countAppleMap = new HashMap<>();
    Integer[][][] dp;
    final int MOD = (int) 1e9 + 7;

    public int ways(String[] pizza, int k) {
        int totalAppleCount = countApple(pizza, 0, 0);
        countAppleMap = new HashMap<>();
        dp = new Integer[pizza.length][pizza[0].length()][k + 1];
        return dfs(pizza, 0, 0, totalAppleCount, k, dp);
    }

    private int dfs(String[] pizza, int yStart, int xStart, int totalAppleCount, int k, Integer[][][] dp) {
        if (dp[yStart][xStart][k] != null)
            return dp[yStart][xStart][k];
        if (k == 1) {
            return 1;
        }
        long cnt = 0;
        for (int i = yStart + 1; i < pizza.length; i++) {
            int leftApple = countApple(pizza, i, xStart);
            if (totalAppleCount != leftApple && 0 < leftApple) {
                cnt += dfs(pizza, i, xStart, leftApple, k - 1, dp);
            }
        }
        for (int j = xStart + 1; j < pizza[0].length(); j++) {
            int leftApple = countApple(pizza, yStart, j);
            if (totalAppleCount != leftApple && 0 < leftApple) {
                cnt += dfs(pizza, yStart, j, leftApple, k - 1, dp);
            }
        }
        dp[yStart][xStart][k] = (int) (cnt % MOD);
        return dp[yStart][xStart][k];
    }

    private int countApple(String[] pizza, int startY, int startX) {
        String key = startY + " " + startX;
        if (countAppleMap.containsKey(key)) {
            return countAppleMap.get(key);
        }
        int cnt = 0;
        for (int i = startY; i < pizza.length; i++) {
            for (int j = startX; j < pizza[0].length(); j++) {
                if (pizza[i].charAt(j) == 'A') {
                    cnt++;
                }
            }
        }
        countAppleMap.put(key, cnt);
        return cnt;
    }

}
