package shane.programmers.lv3;

import com.tistory.shanepark.STool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        System.out.println(solution(STool.convertToIntArray("[[0, 3], [1, 9], [2, 6]]")));
    }

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<Job> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.size, o2.size));
        int time = 0;
        int complete = 0;
        int index = 0;
        int sum = 0;
        while (complete < jobs.length) {
            for (int i = index; i < jobs.length; i++) {
                Job job = new Job(jobs[i]);
                if (job.start <= time) {
                    q.add(job);
                    index++;
                } else {
                    break;
                }
            }
            if (q.size() > 0) {
                Job job = q.poll();
                time += job.size;
                complete++;
                sum += time - job.start;
            } else {
                time++;
            }
        }

        return sum / jobs.length;
    }

    static class Job {
        int start;
        int size;

        Job(int[] arr) {
            this.start = arr[0];
            this.size = arr[1];
        }

        public void work() {
            this.size--;
        }

    }
}
