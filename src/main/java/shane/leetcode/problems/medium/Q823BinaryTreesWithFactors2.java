package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q823BinaryTreesWithFactors2 {

    @Test
    public void test() {
        assertThat(numFactoredBinaryTrees(new int[]{2, 4})).isEqualTo(3);
        assertThat(numFactoredBinaryTrees(new int[]{2, 4, 5, 10})).isEqualTo(7);
    }

    /**
     * 1sec 506 ms
     */
    @Test
    public void tle() {
        assertThat(numFactoredBinaryTrees(new int[]{775, 27, 8, 3, 22, 43, 34, 875, 1568, 7920, 42, 44, 1980, 476, 1360, 30, 23, 9, 1184, 45, 704, 602, 29, 21, 7, 352, 2, 32, 473760, 13, 26, 37, 1012, 38, 6, 180, 720, 102960, 15, 48, 2380, 220, 31, 14, 35360, 647360, 28, 40, 47, 33, 810, 396, 166320, 1760, 46, 1134, 25740, 1470, 369, 18, 12474, 6160, 10, 49, 1295, 16, 12, 77080, 17, 1880, 25, 252, 840, 260, 39, 792, 56448, 35, 41, 4, 1258, 320, 520, 175, 1487640, 19, 24, 18480, 924, 360, 972, 384, 36, 5, 82, 1540, 20, 11, 616}))
                .isEqualTo(1356668);
    }

    int MOD = (int) 1e9 + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, new HashSet<>());
        }

        for (int i : arr) {
            for (int j : arr) {
                if (map.containsKey(i * j)) {
                    map.get(i).add(j);
                    map.get(j).add(i);
                }
            }
        }
        int cnt = 0;
        for (int i : arr) {
            cnt += makeTree(map, arr, i);
            cnt %= MOD;
        }
        return cnt;
    }

    private int makeTree(Map<Integer, Set<Integer>> map, int[] arr, int head) {
        long cnt = 1;
        for (int left : arr) {
            for (Integer right : map.get(left)) {
                if (left * right != head)
                    continue;
                int leftCnt = makeTree(map, arr, left);
                int rightCnt = makeTree(map, arr, right);
                cnt += (long) leftCnt * rightCnt;
                cnt %= MOD;
            }
        }
        return (int) cnt;
    }

}
