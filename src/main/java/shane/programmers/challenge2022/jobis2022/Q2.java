package shane.programmers.challenge2022.jobis2022;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 정확성 테스트
 * 테스트 1 〉 통과 (1.73ms, 76MB)
 * 테스트 2 〉 통과 (4.40ms, 77.1MB)
 * 테스트 3 〉 실패 (5.18ms, 74.8MB)
 * 테스트 4 〉 실패 (17.26ms, 88.2MB)
 * 테스트 5 〉 실패 (시간 초과)
 * 테스트 6 〉 실패 (시간 초과)
 * 테스트 7 〉 실패 (243.11ms, 111MB)
 * 테스트 8 〉 실패 (1350.84ms, 193MB)
 * 테스트 9 〉 실패 (1003.77ms, 185MB)
 * 테스트 10 〉 통과 (32.93ms, 156MB)
 * 테스트 11 〉 통과 (1.51ms, 73.9MB)
 * 테스트 12 〉 실패 (시간 초과)
 * 테스트 13 〉 통과 (1284.58ms, 193MB)
 * 테스트 14 〉 실패 (시간 초과)
 * 테스트 15 〉 실패 (1202.39ms, 193MB)
 * 테스트 16 〉 통과 (1072.74ms, 180MB)
 * 테스트 17 〉 실패 (800.03ms, 184MB)
 * 테스트 18 〉 실패 (709.04ms, 149MB)
 * 테스트 19 〉 실패 (398.22ms, 146MB)
 * 테스트 20 〉 통과 (355.41ms, 140MB)
 */
public class Q2 {

    @Test
    public void test() {
        assertThat(solution(STool.convertToIntArray("[[2, 1, 0, 3], [3, 2, 0, 1], [3, 0 ,2, 1], [2, 3, 0, 1]]"))).containsExactly(1, 3);
        assertThat(solution(STool.convertToIntArray("[[2, 3, 4, 0, 1], [1, 4, 3, 2, 0], [ 4, 1, 0, 2, 3], [ 3, 2, 1, 4, 0], [ 0, 3, 2, 1, 4]]"))).containsExactly(4, 3);
    }

    public int[] solution(int[][] orders) {
        List<Student> students = new ArrayList<>();
        Map<Integer, Integer> candidates = new HashMap<>();
        int length = orders.length;
        int half = (length + 1) / 2;

        for (int i = 0; i < length; i++) {
            Student student = new Student(i, orders[i]);
            students.add(student);
            candidates.put(i, student.num);
        }

        int cnt = 1;
        while (true) {
            Map<Integer, Integer> voteCnt = new HashMap<>();
            for (Integer num : candidates.values()) {
                voteCnt.put(num, 0);
            }
            int max = 0;
            for (Student student : students) {
                int vote = student.vote();
                Integer cur = voteCnt.merge(vote, 1, Integer::sum);
                if (max < cur) {
                    max = cur;
                }
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

            int min = voteCnt.size();
            int minStudent = -1;
            for (Map.Entry<Integer, Integer> e : voteCnt.entrySet()) {
                Integer studentN = e.getKey();
                Integer votes = e.getValue();
                if (votes < min) {
                    minStudent = studentN;
                    min = votes;
                }
            }
            candidates.remove(minStudent);
            final int toDelete = minStudent;
            students.forEach(s -> s.deleteCandidate(toDelete));
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

        public int vote() {
            return favourite.peek();
        }

        public void deleteCandidate(int minStudent) {
            favourite.remove(minStudent);
        }
    }

}
