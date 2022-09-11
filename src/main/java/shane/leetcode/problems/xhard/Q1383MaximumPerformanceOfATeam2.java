package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * got Priority queue idea from discuss
 * Runtime: 67 ms, faster than 75.00% of Java online submissions for Maximum Performance of a Team.
 * Memory Usage: 53.4 MB, less than 99.67% of Java online submissions for Maximum Performance of a Team.
 */
@SuppressWarnings("ALL")
public class Q1383MaximumPerformanceOfATeam2 {

    @Test
    public void test() {
        assertThat(maxPerformance(3, new int[]{100, 3, 2}, new int[]{1, 33, 49}, 1)).isEqualTo(100);
        assertThat(maxPerformance(3, new int[]{100, 3, 2}, new int[]{1, 33, 49}, 2)).isEqualTo(165);
        assertThat(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2)).isEqualTo(60);
        assertThat(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3)).isEqualTo(68);
        assertThat(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4)).isEqualTo(72);
    }

    @Test
    public void tle() throws IOException {

        String filePath = getClass().getPackage().getName().replaceAll("\\.", separator) + separator;

        int[] speed = Arrays.stream(
                        new BufferedReader(
                                new FileReader(getClass().getClassLoader().getResource(
                                        filePath + "Q1383_speed.txt").getFile()))
                                .readLine()
                                .split(","))
                .mapToInt(s -> Integer.parseInt(s)).toArray();

        int[] efficiency = Arrays.stream(
                        new BufferedReader(
                                new FileReader(getClass().getClassLoader().getResource(
                                        filePath + "Q1383_efficiency.txt").getFile()))
                                .readLine()
                                .split(","))
                .mapToInt(s -> Integer.parseInt(s)).toArray();


        assertThat(maxPerformance(100000, speed, efficiency, 86484)).isEqualTo(301574164);
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> engineers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            engineers.add(new Engineer(speed[i], efficiency[i]));
        }
        engineers.sort(Comparator.comparingInt(e -> -e.efficiency));

        PriorityQueue<Engineer> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.speed));
        long max = 0, speedSum = 0;
        for (Engineer engineer : engineers) {
            pq.add(engineer);
            speedSum += engineer.speed;
            if (pq.size() > k)
                speedSum -= pq.poll().speed;
            max = Math.max(max, (speedSum * engineer.efficiency));
        }
        return (int) (max % (int) (1e9 + 7));

    }

    class Engineer {
        int speed;
        int efficiency;

        public Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }

        @Override
        public String toString() {
            return "Engineer{" +
                    "speed=" + speed +
                    ", efficiency=" + efficiency +
                    '}';
        }
    }

}
