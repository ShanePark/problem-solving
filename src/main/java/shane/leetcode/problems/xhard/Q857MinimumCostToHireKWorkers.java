package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class Q857MinimumCostToHireKWorkers {

    @Test
    public void test() {
        assertThat(mincostToHireWorkers(new int[]{10, 20, 5}, new int[]{70, 50, 30}, 2)).isEqualTo(105.0);
        assertThat(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3)).isCloseTo(30.66667, within(0.00001));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Worker> workers = IntStream.range(0, quality.length)
                .mapToObj(i -> new Worker(quality[i], wage[i]))
                .sorted(Comparator.comparingDouble(w -> w.ratio))
                .collect(Collectors.toList());

        double answer = Double.MAX_VALUE;
        int totalQuality = 0;
        PriorityQueue<Worker> pq = new PriorityQueue<>(Comparator.comparingInt(w -> -w.quality));
        for (Worker worker : workers) {
            pq.offer(worker);
            totalQuality += worker.quality;

            if (pq.size() < k) {
                continue;
            }

            if (pq.size() > k) {
                Worker poll = pq.poll();
                totalQuality -= poll.quality;
            }

            answer = Math.min(totalQuality * worker.ratio, answer);
        }

        return answer;
    }

    static class Worker {
        int quality;
        int wage;
        double ratio;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            ratio = (double) wage / quality;
        }
    }

}
