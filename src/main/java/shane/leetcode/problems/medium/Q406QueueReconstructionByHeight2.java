package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q406QueueReconstructionByHeight2 {

    @Test
    public void test() {
        assertThat(reconstructQueue(Ps.intArray("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]")))
                .isDeepEqualTo(Ps.intArray("[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]"));
        assertThat(reconstructQueue(Ps.intArray("[[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]")))
                .isDeepEqualTo(Ps.intArray("[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]"));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o2[0], o1[0]);
        });
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }

        int length = people.length;

        int[][] answer = new int[length][];
        for (int i = 0; i < length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
