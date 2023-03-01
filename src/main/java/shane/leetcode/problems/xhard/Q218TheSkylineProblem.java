package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q218TheSkylineProblem {

    @Test
    public void test() {
        assertThat(getSkyline(Ps.intArray("[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]")))
                .isEqualTo(Ps.intList("[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]"));
        assertThat(getSkyline(Ps.intArray("[[0,2,3],[2,5,3]]")))
                .isEqualTo(Ps.intList("[[0,3],[5,0]]"));
    }

    @Test
    public void tle() {
//        assertThat(getSkyline(Ps.intArray("[[0,2147483647,2147483647]]")));
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Integer, Integer> heightMap = new LinkedHashMap<>();
        int last = -1;
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            last = Math.max(last, right);
            int height = building[2];
            for (; left < right; left++) {
                Integer beforeMax = heightMap.getOrDefault(left, 0);
                heightMap.put(left, Math.max(beforeMax, height));
            }
        }

        int heightBefore = -1;
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = buildings[0][0]; i < last; i++) {
            Integer height = heightMap.getOrDefault(i, 0);
            if (heightBefore != height) {
                answer.add(List.of(i, height));
            }
            heightBefore = height;
        }

        answer.add(List.of(last, 0));

        return answer;
    }

}
