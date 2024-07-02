package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime6msBeats10.21%
 */
public class Q350IntersectionOfTwoArraysII {

    @Test
    public void test() {
        assertThat(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})).containsExactly(2, 2);
        assertThat(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).containsExactly(4, 9);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt1 = count(nums1);
        Map<Integer, Integer> cnt2 = count(nums2);
        Map<Integer, Integer> merge = new HashMap<>();
        for (Integer i : cnt1.keySet()) {
            Integer count2 = cnt2.get(i);
            if (count2 == null)
                continue;
            merge.put(i, Math.min(cnt1.get(i), count2));
        }
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : merge.entrySet()) {
            int v = e.getValue();
            for (int i = 0; i < v; i++) {
                answer.add(e.getKey());
            }
        }
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }

    private Map<Integer, Integer> count(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.merge(i, 1, Integer::sum);
        }
        return map;
    }

}
