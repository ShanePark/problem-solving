package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1337TheKWeakestRowsInAMatrix {

    @Test
    public void test() {
        assertThat(kWeakestRows(Ps.intArray("[[1,1,0,0,0],\n" +
                " [1,1,1,1,0],\n" +
                " [1,0,0,0,0],\n" +
                " [1,1,0,0,0],\n" +
                " [1,1,1,1,1]]"), 3)).containsExactly(2, 0, 3);
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Row> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            list.add(new Row(i, Arrays.stream(mat[i]).sum()));
        }
        int[] answer = new int[k];
        Collections.sort(list);

        for (int i = 0; i < k; i++) {
            answer[i] = list.get(i).index;
        }
        return answer;
    }

    class Row implements Comparable {
        int index;
        int sum;

        public Row(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

        @Override
        public int compareTo(Object o) {
            Row r = (Row) o;
            if (r.sum == this.sum) {
                return Integer.compare(this.index, r.index);
            }
            return Integer.compare(this.sum, r.sum);
        }
    }
}
