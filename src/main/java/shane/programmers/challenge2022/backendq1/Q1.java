package shane.programmers.challenge2022.backendq1;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[0,5,2,4,1],[5,0,3,9,6],[2,3,0,6,3],[4,9,6,0,3],[1,6,3,3,0]]"))).isDeepEqualTo(Ps.intArray("[[1,2,0,4,3],[3,4,0,2,1]]"));
        assertThat(solution(Ps.intArray("[[0,2,3,1],[2,0,1,1],[3,1,0,2],[1,1,2,0]]"))).isDeepEqualTo(Ps.intArray("[[2,1,3,0],[0,3,1,2]]"));
    }

    public int[][] solution(int[][] dist) {
        int length = dist.length;

        List<int[]> list = new ArrayList<>();
        list.add(new int[length]);

        for (int i = 1; i < length; i++) {
            List<int[]> tmp = new ArrayList<>();
            for (int[] ints : list) {
                ints[i] = dist[0][i];
                tmp.add(Arrays.copyOf(ints, length));
                ints[i] = -dist[0][i];
                tmp.add(Arrays.copyOf(ints, length));
            }
            list = tmp;
        }

        for (int i = 1; i < length; i++) {
            validation(i, dist[i], list);
        }

        int[][] solution = new int[list.size()][length];
        int index = 0;
        for (int[] ints : list) {
            int[] rank = new int[length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (ints[i] < ints[j])
                        rank[i]++;
                }
            }
            int[] arr = new int[length];
            for(int i=0; i<length; i++) {
                arr[rank[i]] = i;
            }
            solution[index++] = arr;
        }

        return solution;

    }

    private void validation(int index, int[] ints, List<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!valid(index, list.get(i), ints)) {
                list.remove(i);
                i--;
            }
        }
    }

    private boolean valid(int index, int[] ints, int[] fact) {
        for (int i = 0; i < ints.length; i++) {
            if (Math.abs(ints[index] - ints[i]) != fact[i]) {
                return false;
            }
        }
        return true;
    }

}
