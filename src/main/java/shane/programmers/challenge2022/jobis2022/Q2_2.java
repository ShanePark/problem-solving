package shane.programmers.challenge2022.jobis2022;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q2_2 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[2, 1, 0, 3], [3, 2, 0, 1], [3, 0 ,2, 1], [2, 3, 0, 1]]"))).containsExactly(1, 3);
        assertThat(solution(Ps.intArray("[[2, 3, 4, 0, 1], [1, 4, 3, 2, 0], [ 4, 1, 0, 2, 3], [ 3, 2, 1, 4, 0], [ 0, 3, 2, 1, 4]]"))).containsExactly(4, 3);
    }

    public int[] solution(int[][] orders) {
        List<Student> students = new ArrayList<>();
        Set<Integer> candidates = new HashSet<>();
        int length = orders.length;
        int half = (length + 1) / 2;

        for (int i = 0; i < length; i++) {
            Student student = new Student(i, orders[i]);
            students.add(student);
            candidates.add(i);
        }

        int cnt = 1;
        while (true) {
            Map<Integer, Integer> voteCnt = new HashMap<>();
            for (Integer num : candidates) {
                voteCnt.put(num, 0);
            }
            int max = 0;
            for (Student student : students) {
                int vote = student.vote(candidates);
                max = Math.max(max, voteCnt.merge(vote, 1, Integer::sum));
            }

            if (max >= half) {
                return new int[]{cnt, voteCnt.entrySet()
                        .stream()
                        .sorted((e1, e2) -> {
                            if ((int) e1.getValue() == e2.getValue()) {
                                return Integer.compare(e2.getKey(), e1.getKey());
                            }
                            return Integer.compare(e2.getValue(), e1.getValue());
                        }).findFirst().get().getKey()
                };
            }

            Integer minStudent = voteCnt.entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        if ((int) e1.getValue() == e2.getValue()) {
                            return Integer.compare(e1.getKey(), e2.getKey());
                        }
                        return Integer.compare(e1.getValue(), e2.getValue());
                    }).findFirst().get().getKey();
            candidates.remove(minStudent);
            cnt++;

        }

    }

    class Student {
        int num;
        Queue<Integer> favourite = new LinkedList<>();

        public Student(int num, int[] data) {
            this.num = num;
            for (int datum : data) {
                favourite.offer(datum);
            }
        }

        public int vote(Set<Integer> candidates) {
            while (!candidates.contains(favourite.peek())) {
                favourite.poll();
            }
            return favourite.peek();
        }
    }

}
