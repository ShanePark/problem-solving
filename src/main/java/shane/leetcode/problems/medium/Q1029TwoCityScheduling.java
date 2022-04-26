package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1029TwoCityScheduling {

    @Test
    public void test() {
        assertThat(twoCitySchedCost(STool.convertToIntArray("[[10,20],[30,200],[400,50],[30,20]]"))).isEqualTo(110);
        assertThat(twoCitySchedCost(STool.convertToIntArray("[[259,770],[448,54],[926,667],[184,139],[840,118],[577,469]]"))).isEqualTo(1859);
        assertThat(twoCitySchedCost(STool.convertToIntArray("[[515,563],[451,713],[537,709],[343,819],[855,779],[457,60],[650,359],[631,42]]"))).isEqualTo(3086);
    }

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(Math.abs(o2[0] - o2[1]), Math.abs(o1[0] - o1[1])));
        int cost = 0;
        int cityA = 0;
        int cityB = 0;

        int i = 0;
        for (; cityA < costs.length / 2 && cityB < costs.length / 2; i++) {
            int[] person = costs[i];
            if (person[0] > person[1]) {
                cityB++;
                cost += person[1];
            } else {
                cityA++;
                cost += person[0];
            }
        }

        int j = (cityA == costs.length / 2 ? 1 : 0);
        for (; i < costs.length; i++) {
            cost += costs[i][j];
        }

        return cost;

    }
}
