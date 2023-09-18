package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 6ms Beats 8.03%of users with Java
 * Memory Details 44.70MB Beats 28.19%of users with Java
 */
public class Q1337TheKWeakestRowsInAMatrix2 {

    @Test
    public void test() {
        assertThat(kWeakestRows(Ps.intArray("[[1,1,0,0,0],\n" +
                " [1,1,1,1,0],\n" +
                " [1,0,0,0,0],\n" +
                " [1,1,0,0,0],\n" +
                " [1,1,1,1,1]]"), 3)).containsExactly(2, 0, 3);
        assertThat(kWeakestRows(Ps.intArray("[[1,0,0,0],\n" +
                " [1,1,1,1],\n" +
                " [1,0,0,0],\n" +
                " [1,0,0,0]]"), 2)).containsExactly(0, 2);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Row> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(new Row(i, mat[i]));
        }
        return list.stream()
                .sorted()
                .limit(k)
                .mapToInt(r -> r.index)
                .toArray();
    }

    class Row implements Comparable {
        final int index;
        final int soldiers;

        public Row(int i, int[] ints) {
            this.index = i;
            this.soldiers = Arrays.stream(ints).sum();
        }

        public int compareTo(Object o) {
            Row r = (Row) o;
            if (this.soldiers == r.soldiers)
                return Integer.compare(this.index, r.index);
            return Integer.compare(this.soldiers, r.soldiers);
        }
    }

}
