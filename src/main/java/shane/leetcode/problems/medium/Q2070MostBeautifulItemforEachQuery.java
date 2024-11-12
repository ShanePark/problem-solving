package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime42msBeats92.75%
 */
public class Q2070MostBeautifulItemforEachQuery {

    @Test
    public void test() {
        assertThat(maximumBeauty(Ps.intArray("[[10,1000]]"), new int[]{5})).containsExactly(0);
        assertThat(maximumBeauty(Ps.intArray("[[1,2],[3,2],[2,4],[5,6],[3,5]]"), new int[]{1, 2, 3, 4, 5, 6})).containsExactly(2, 4, 5, 5, 6, 6);
        assertThat(maximumBeauty(Ps.intArray("[[1,2],[1,2],[1,3],[1,4]]"), new int[]{1})).containsExactly(4);
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];
        Arrays.sort(items, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            if (!treeMap.isEmpty() && beauty < treeMap.lastEntry().getValue()) {
                continue;
            }
            treeMap.put(price, beauty);
        }

        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            Integer floor = treeMap.floorKey(q);
            if (floor != null) {
                answer[i] = treeMap.get(floor);
            }
        }
        return answer;
    }

}
