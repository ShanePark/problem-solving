package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 175 ms Beats 75.81%
 * Memory 86.9 MB Beats 78.11%
 */
public class Q1834SingleThreadedCPU {

    @Test
    public void test() {
        assertThat(getOrder(Ps.intArray("[[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]")))
                .containsExactly(6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7);
        assertThat(getOrder(Ps.intArray("[[1,2],[2,4],[3,2],[4,1]]")))
                .containsExactly(0, 2, 3, 1);
        assertThat(getOrder(Ps.intArray("[[7,10],[7,12],[7,5],[7,4],[7,2]]")))
                .containsExactly(4, 3, 2, 0, 1);
    }

    public int[] getOrder(int[][] tasks) {
        List<Process> list = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            Process process = new Process(i, task[0], task[1]);
            list.add(process);
        }
        list.sort(Comparator.comparingInt(p -> p.enqueueTime));
        Queue<Process> jobs = new LinkedList<>(list);

        int time = 0;

        PriorityQueue<Process> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.processingTime == p2.processingTime) {
                return Integer.compare(p1.index, p2.index);
            }
            return Integer.compare(p1.processingTime, p2.processingTime);
        });

        List<Integer> finished = new ArrayList<>();

        while (!jobs.isEmpty() || !pq.isEmpty()) {
            while (!jobs.isEmpty() && jobs.peek().enqueueTime <= time) {
                Process process = jobs.poll();
                pq.offer(process);
            }
            if (pq.isEmpty()) {
                time = jobs.peek().enqueueTime;
            } else {
                Process process = pq.poll();
                time += process.processingTime;
                finished.add(process.index);
            }
        }

        return finished.stream().mapToInt(i -> i).toArray();
    }

    class Process {
        int index;
        int enqueueTime;
        int processingTime;

        public Process(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }

        @Override
        public String toString() {
            return "Process{" +
                    "index=" + index +
                    ", enqueueTime=" + enqueueTime +
                    ", processingTime=" + processingTime +
                    '}';
        }
    }

}
