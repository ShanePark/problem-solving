package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2542MaximumSubsequenceScore {

    @Test
    public void test() {
        assertThat(maxScore(new int[]{1, 3, 3, 2}, new int[]{2, 1, 3, 4}, 3)).isEqualTo(12);
        assertThat(maxScore(new int[]{4, 2, 3, 1, 1}, new int[]{7, 5, 10, 9, 6}, 1)).isEqualTo(30);
    }

    /**
     * never ends
     */
    @Test
    public void tle() {
        assertThat(maxScore(
                new int[]{93, 463, 179, 2488, 619, 2006, 1561, 137, 53, 1765, 2304, 1459, 1768, 450, 1938, 2054, 466, 331, 670, 1830, 1550, 1534, 2164, 1280, 2277, 2312, 1509, 867, 2223, 1482, 2379, 1032, 359, 1746, 966, 232, 67, 1203, 2474, 944, 1740, 1775, 1799, 1156, 1982, 1416, 511, 1167, 1334, 2344}
                , new int[]{345, 229, 976, 2086, 567, 726, 1640, 2451, 1829, 77, 1631, 306, 2032, 2497, 551, 2005, 2009, 1855, 1685, 729, 2498, 2204, 588, 474, 693, 30, 2051, 1126, 1293, 1378, 1693, 1995, 2188, 1284, 1414, 1618, 2005, 1005, 1890, 30, 895, 155, 526, 682, 2454, 278, 999, 1417, 1682, 995},
                42));
    }

    int max = 0;

    public long maxScore(int[] nums1, int[] nums2, int k) {
        dfs(nums1, nums2, k, 0, Integer.MAX_VALUE, 0);
        return max;
    }

    private void dfs(int[] nums1, int[] nums2, int k, int sum, int min, int index) {
        if (k == 0) {
            max = Math.max(max, sum * min);
            return;
        }

        if (index == nums1.length)
            return;

        dfs(nums1, nums2, k, sum, min, index + 1);
        dfs(nums1, nums2, k - 1, sum + nums1[index], Math.min(min, nums2[index]), index + 1);
    }

}
