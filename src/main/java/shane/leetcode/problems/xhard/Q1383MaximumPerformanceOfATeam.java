package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 54 / 55 test cases passed.
 */
@SuppressWarnings("ALL")
public class Q1383MaximumPerformanceOfATeam {

    @Test
    public void test() {
        assertThat(maxPerformance(3, new int[]{100, 3, 2}, new int[]{1, 33, 49}, 1)).isEqualTo(100);
        assertThat(maxPerformance(3, new int[]{100, 3, 2}, new int[]{1, 33, 49}, 2)).isEqualTo(165);
        assertThat(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2)).isEqualTo(60);
        assertThat(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 3)).isEqualTo(68);
        assertThat(maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 4)).isEqualTo(72);
    }

    /**
     * Never end forever
     * @throws IOException
     */
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

        engineers.sort((e1, e2) -> {
            if (e1.efficiency == e2.efficiency) {
                return Integer.compare(e1.speed, e2.speed);
            }
            return Integer.compare(e1.efficiency, e2.efficiency);
        });

        long max = 0;
        while (!engineers.isEmpty()) {
            Team team = new Team(engineers.get(0).efficiency);
            max = Math.max(max, team.addEngineers(engineers, k));
        }

        return (int) (max % ((int) 1e9 + 7));

    }

    class Team {
        int efficiency;
        List<Engineer> engineers = new ArrayList<>();
        long performance;

        public Team(int efficiency) {
            this.efficiency = efficiency;
        }

        public long addEngineers(List<Engineer> list, int k) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Engineer engineer = list.get(i);
                this.engineers.add(engineer);
                if (engineer.efficiency == this.efficiency) {
                    list.remove(i);
                    i--;
                    size--;
                }
            }
            this.engineers = this.engineers
                    .stream()
                    .sorted(Comparator.comparingInt(e -> -e.speed))
                    .limit(k)
                    .collect(Collectors.toList());

            this.performance = engineers.stream().mapToLong(e -> e.speed).sum() * efficiency;
            return performance;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "efficiency=" + efficiency +
                    ", engineers=" + engineers +
                    '}';
        }
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
