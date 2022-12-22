package shane.programmers.pccp.mock01;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q4 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[2, 0, 10], [1, 5, 5], [3, 5, 3], [3, 12, 2]]")))
                .containsExactly(20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0);
        assertThat(solution(STool.convertToIntArray("[[3, 6, 4], [4, 2, 5], [1, 0, 5], [5, 0, 5]]")))
                .containsExactly(19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0);
    }

    public long[] solution(int[][] program) {
        long[] answer = new long[11];
        int currentTime = 0;
        Queue<Process> processes = new LinkedList<>();
        Arrays.stream(program)
                .map(ints -> new Process(ints))
                .sorted(Comparator.comparingInt(p -> p.callTime))
                .forEach(processes::offer);
        PriorityQueue<Process> pq = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1.priority == p2.priority) {
                        return Integer.compare(p1.callTime, p2.callTime);
                    }
                    return Integer.compare(p1.priority, p2.priority);
                }
        );

        while (!processes.isEmpty()) {
            while (!processes.isEmpty() && processes.peek().callTime <= currentTime) {
                Process poll = processes.poll();
                pq.offer(poll);
            }
            if (pq.isEmpty()) {
                currentTime = processes.peek().callTime;
            } else {
                currentTime = pq.poll().process(currentTime, answer);
            }
        }

        while (!pq.isEmpty()) {
            currentTime = pq.poll().process(currentTime, answer);
        }

        return answer;
    }

    class Process {
        int priority;
        int callTime;
        int timeRequired;

        public Process(int[] ints) {
            this.priority = ints[0];
            this.callTime = ints[1];
            this.timeRequired = ints[2];
        }

        @Override
        public String toString() {
            return "Process{" +
                    "score=" + priority +
                    ", callTime=" + callTime +
                    ", totalTime=" + timeRequired +
                    '}';
        }

        public int process(int currentTime, long[] answer) {
            answer[priority] += (currentTime - callTime);
            currentTime += timeRequired;
            answer[0] = currentTime;
            return currentTime;
        }
    }

}
