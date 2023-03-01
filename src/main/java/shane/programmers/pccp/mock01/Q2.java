package shane.programmers.pccp.mock01;

import io.github.shanepark.Ps;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	실패 (0.48ms, 90.9MB)
 * 테스트 2 〉	실패 (0.37ms, 77.6MB)
 * 테스트 3 〉	실패 (0.43ms, 74.2MB)
 * 테스트 4 〉	실패 (0.43ms, 73.5MB)
 * 테스트 5 〉	통과 (0.28ms, 75.6MB)
 * 테스트 6 〉	통과 (0.37ms, 68.9MB)
 * 테스트 7 〉	실패 (0.29ms, 74.1MB)
 * 테스트 8 〉	실패 (0.27ms, 74.1MB)
 * 테스트 9 〉	실패 (0.41ms, 76MB)
 * 테스트 10 〉	실패 (0.32ms, 79.1MB)
 * 채점 결과
 * 정확성: 20.0
 * 합계: 20.0 / 100.0
 */
public class Q2 {

    @org.junit.jupiter.api.Test
    public void test() {
        assertThat(solution(Ps.intArray("[[40, 10, 10], [20, 5, 0], [30, 30, 30], [70, 0, 70], [100, 100, 100]]"))).isEqualTo(210);
        assertThat(solution(Ps.intArray("[[20, 30], [30, 20], [20, 30]]"))).isEqualTo(60);
    }

    public int solution(int[][] ability) {
        Person[] best = new Person[ability[0].length];
        Person[] people = new Person[ability.length];
        Queue<Person> queue = new LinkedList<>();

        for (int i = 0; i < ability.length; i++) {
            Person person = new Person(i, ability[i]);
            people[i] = person;
            queue.add(person);
        }

        while (!queue.isEmpty()) {
            Person person = queue.poll();
            int maxGap = 0;
            int maxIndex = 0;
            for (int i = 0; i < best.length; i++) {
                Person bestGuy = best[i];
                if (bestGuy != null) {
                    int diff = person.score[i] - bestGuy.score[i];
                    if (diff > maxGap) {
                        maxGap = diff;
                        maxIndex = i;
                    }
                } else if (person.score[i] > maxGap) {
                    maxGap = person.score[i];
                    maxIndex = i;
                }

            }
            if (maxGap > 0) {
                Person notBestAnymore = best[maxIndex];
                best[maxIndex] = person;
                if (notBestAnymore != null) {
                    queue.offer(notBestAnymore);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < best.length; i++) {
            sum += best[i].score[i];
        }
        return sum;
    }

    class Person {
        final int index;
        final int[] score;

        public Person(int index, int[] score) {
            this.index = index;
            this.score = score;
        }
    }
}
