package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q406QueueReconstructionByHeight {

    @Test
    public void test() {
        assertThat(reconstructQueue(STool.convertToIntArray("[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]")))
                .isDeepEqualTo(STool.convertToIntArray("[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]"));
        assertThat(reconstructQueue(STool.convertToIntArray("[[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]")))
                .isDeepEqualTo(STool.convertToIntArray("[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]"));
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });
        int[][] answer = new int[people.length][2];
        int[] memo = new int[1000000];

        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person);
        }

        for (int i = 0; i < list.size(); ) {
            int[] person = list.get(i);
            if (memo[person[0]] == person[1]) {
                answer[people.length - list.size()] = person;
                list.remove(i);
                i = 0;
                for (int j = 0; j <= person[0]; j++) {
                    memo[j]++;
                }
            } else {
                i++;
            }
        }
        return answer;
    }
}
