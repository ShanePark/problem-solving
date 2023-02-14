package shane.leetcode.problems.medium;

import static com.github.shanepark.Ps.intArray;
import static org.assertj.core.api.Assertions.assertThat;

public class Q1828QueriesOnNumberOfPointsInsideACircle {

    public static void main(String[] args) {
        assertThat(countPoints(intArray("[[1,3],[3,3],[5,3],[2,2]]"), intArray("[[2,3,1],[4,3,1],[1,1,2]]"))).containsExactly(3, 2, 2);
        assertThat(countPoints(intArray("[[1,1],[2,2],[3,3],[4,4],[5,5]]"), intArray("[[1,2,2],[2,2,2],[4,3,2],[4,3,3]]"))).containsExactly(2, 3, 2, 4);
    }

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < points.length; j++) {
                boolean flag = Math.pow(points[j][0] - queries[i][0], 2) + Math.pow(points[j][1] - queries[i][1], 2) <= Math.pow(queries[i][2], 2);
                if (flag) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

}
