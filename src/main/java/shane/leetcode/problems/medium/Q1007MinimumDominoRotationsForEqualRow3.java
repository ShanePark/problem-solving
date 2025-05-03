package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class Q1007MinimumDominoRotationsForEqualRow3 {

    @Test
    void test() {
        assertThat(minDominoRotations(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2})).isEqualTo(2);
        assertThat(minDominoRotations(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4})).isEqualTo(-1);
    }

    @Test
    public void test2() {
        assertThat(minDominoRotations(new int[]{1, 2, 1, 1, 1, 2, 2, 2}, new int[]{2, 1, 2, 2, 2, 2, 2, 2})).isEqualTo(1);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> topCnt = new HashMap<>();
        Map<Integer, Integer> bottomCnt = new HashMap<>();
        Map<Integer, Integer> sameCnt = new HashMap<>();
        for (int i = 0; i < tops.length; i++) {
            topCnt.merge(tops[i], 1, Integer::sum);
            bottomCnt.merge(bottoms[i], 1, Integer::sum);
            if (tops[i] == bottoms[i]) {
                sameCnt.merge(tops[i], 1, Integer::sum);
            }
        }
        if (topCnt.size() == 1 || bottomCnt.size() == 1)
            return 0;

        int min = tops.length;
        for (Map.Entry<Integer, Integer> e : topCnt.entrySet()) {
            int num = e.getKey();
            int cnt = e.getValue();
            if (cnt + bottomCnt.getOrDefault(num, 0) - sameCnt.getOrDefault(num, 0) < tops.length)
                continue;
            min = Math.min(min, Math.min(cnt, tops.length - cnt));
        }
        for (Map.Entry<Integer, Integer> e : bottomCnt.entrySet()) {
            int num = e.getKey();
            int cnt = e.getValue();
            if (cnt + topCnt.getOrDefault(num, 0) - sameCnt.getOrDefault(num, 0) < tops.length)
                continue;
            min = Math.min(min, Math.min(cnt, tops.length - cnt));
        }
        if (min == tops.length)
            return -1;
        return min;
    }

}
