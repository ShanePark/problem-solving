package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 56ms Beats 13.67%of users with Java
 * Memory Details 81.99MB Beats 5.08%of users with Java
 */
public class Q1424DiagonalTraverseII2 {

    @Test
    public void test() {
        assertThat(findDiagonalOrder(Ps.intList("[[1,2,3],[4,5,6],[7,8,9]]"))).isEqualTo(new int[]{1, 4, 2, 7, 5, 3, 8, 6, 9});
        assertThat(findDiagonalOrder(Ps.intList("[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]"))).isEqualTo(new int[]{1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16});
    }

    @Test
    public void test2() {
        assertThat(findDiagonalOrder(Ps.intList("[[1],[2],[3],[4],[5],[6]]"))).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
        assertThat(findDiagonalOrder(Ps.intList("[[1,2,3,4,5,6]]"))).isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    public void tle() {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(List.of(1));
        }
        assertThat(findDiagonalOrder(list)).hasSize(100000);
    }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                Integer num = row.get(j);
                List<Integer> group = map.getOrDefault(i + j, new ArrayList<>());
                map.put(i + j, group);
                group.add(num);
            }
        }
        return map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .flatMap(e -> e.getValue().stream())
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
