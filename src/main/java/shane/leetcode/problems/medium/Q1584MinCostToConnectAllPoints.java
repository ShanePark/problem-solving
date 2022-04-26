package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1584MinCostToConnectAllPoints {

    @Test
    public void test() {
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]"))).isEqualTo(20);
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[3,12],[-2,5],[-4,1]]"))).isEqualTo(18);
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[-14,-14],[-18,5],[18,-10],[18,18],[10,-2]]"))).isEqualTo(102);
        assertThat(minCostConnectPoints(STool.convertToIntArray("[[11,-6],[9,-19],[16,-13],[4,-9],[20,4],[20,7],[-9,18],[10,-15],[-15,3],[6,6]]"))).isEqualTo(113);
    }

    public int minCostConnectPoints(int[][] points) {
        Pair<Integer,Integer> d;
        int "d;";
        return 0;

    }

}
