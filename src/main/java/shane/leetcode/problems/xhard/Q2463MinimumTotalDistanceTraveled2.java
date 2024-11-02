package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * NMS
 */
public class Q2463MinimumTotalDistanceTraveled2 {

    @Test
    public void test() {
        assertThat(minimumTotalDistance(new ArrayList<>(List.of(0, 4, 6)), Ps.intArray("[[2,2],[6,2]]"))).isEqualTo(4);
        assertThat(minimumTotalDistance(new ArrayList<>(List.of(1, -1)), Ps.intArray("[[-2,1],[2,1]]"))).isEqualTo(2);
        assertThat(minimumTotalDistance(new ArrayList<>(List.of(9, 11)), Ps.intArray("[[10,1],[7,1],[14,1]"))).isEqualTo(3);
    }

    @Test
    public void fail() {
        assertThat(minimumTotalDistance(new ArrayList<>(List.of(789300819, -600989788, 529140594, -592135328, -840831288, 209726656, -671200998)),
                Ps.intArray("[[-865262624,6],[-717666169,0],[725929046,2],[449443632,3],[-912630111,0],[270903707,3],[-769206598,2],[-299780916,4],[-159433745,5],[-467185764,3],[849991650,7],[-292158515,6],[940410553,6],[258278787,0],[83034539,2],[54441577,3],[-235385712,2],[75791769,3]]")))
                .isEqualTo(582755368L);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        return calculateMinDistance(robot, factory, new Long[robot.size() + 1][factory.length + 1][robot.size() + 1], 0, 0, 0);
    }

    final long UNREACHABLE = Long.MAX_VALUE;

    public Long calculateMinDistance(List<Integer> robots, int[][] factories, Long[][][] memo, int robot, int factory, int assignCnt) {
        if (robot == robots.size())
            return 0L;
        if (factory == factories.length)
            return UNREACHABLE;
        if (memo[robot][factory][assignCnt] != null)
            return memo[robot][factory][assignCnt];

        long answer = calculateMinDistance(robots, factories, memo, robot, factory + 1, 0);

        if (factories[factory][1] > assignCnt) {
            long nextDistance = calculateMinDistance(robots, factories, memo, robot + 1, factory, assignCnt + 1);
            if (nextDistance != UNREACHABLE) {
                answer = Math.min(answer, Math.abs(robots.get(robot) - factories[factory][0]) + nextDistance);
            }
        }
        return memo[robot][factory][assignCnt] = answer;
    }

}
