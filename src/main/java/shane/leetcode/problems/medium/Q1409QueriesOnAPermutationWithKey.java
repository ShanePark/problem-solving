package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class Q1409QueriesOnAPermutationWithKey {

    @Test
    void test() {
        Assertions.assertThat(processQueries(new int[]{3, 1, 2, 1}, 5)).containsExactly(2, 1, 2, 1);
        Assertions.assertThat(processQueries(new int[]{4, 1, 2, 2}, 4)).containsExactly(3, 1, 2, 0);
        Assertions.assertThat(processQueries(new int[]{7, 5, 5, 8, 3}, 8)).containsExactly(6, 5, 0, 7, 5);
    }

    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(i + 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int index = list.indexOf(query);
            list.remove(index);
            list.add(0, query);
            queries[i] = index;
        }
        return queries;
    }

}
