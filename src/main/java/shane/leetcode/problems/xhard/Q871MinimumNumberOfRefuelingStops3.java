package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Greedy. from https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
 * Runtime: 5 ms, faster than 72.16% of Java online submissions for Minimum Number of Refueling Stops.
 * Memory Usage: 49.6 MB, less than 18.76% of Java online submissions for Minimum Number of Refueling Stops.
 */
@SuppressWarnings("ALL")
public class Q871MinimumNumberOfRefuelingStops3 {

    @Test
    public void test() {
        assertThat(minRefuelStops(1000, 83, Ps.intArray("[[25,27],[36,187],[140,186],[378,6],[492,202],[517,89],[579,234],[673,86],[808,53],[954,49]]"))).isEqualTo(-1);
        assertThat(minRefuelStops(100, 50, Ps.intArray("[[25,25],[50,50]]"))).isEqualTo(1);
        assertThat(minRefuelStops(100, 10, Ps.intArray("[[10,60],[20,30],[30,30],[60,40]]"))).isEqualTo(2);
        assertThat(minRefuelStops(100, 1, Ps.intArray("[[10,100]]"))).isEqualTo(-1);
        assertThat(minRefuelStops(1, 1, Ps.intArray("[]"))).isEqualTo(0);
    }

    @Test
    public void tle() {
        assertThat(minRefuelStops(1000, 1, Ps.intArray("[[1,186],[145,161],[183,43],[235,196],[255,169],[263,200],[353,161],[384,190],[474,44],[486,43],[567,48],[568,96],[592,36],[634,181],[645,167],[646,69],[690,52],[732,28],[800,42],[857,55],[922,63],[960,141],[973,13],[977,112],[997,162]]")))
                .isEqualTo(6);
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int cnt = 0;
        int farthest = startFuel;
        int maxStop = 0;
        while (farthest < target) {
            for (int i = maxStop; i < stations.length && stations[i][0] <= farthest; i++) {
                pq.offer(stations[i][1]);
                maxStop++;
            }
            if (pq.isEmpty())
                return -1;
            farthest += pq.poll();
            cnt++;
        }
        return cnt;
    }

}
