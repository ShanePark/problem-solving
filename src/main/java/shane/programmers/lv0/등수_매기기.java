package shane.programmers.lv0;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class 등수_매기기 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[80, 70], [90, 50], [40, 70], [50, 80]]"))).containsExactly(1, 2, 4, 3);
        assertThat(solution(Ps.intArray("[[80, 70], [70, 80], [30, 50], [90, 100], [100, 90], [100, 100], [10, 30]]"))).containsExactly(4, 4, 6, 2, 2, 1, 7);
    }

    public int[] solution(int[][] score) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(new Person(i, score[i][0], score[i][1]));
        }

        int[] answer = new int[score.length];
        Arrays.fill(answer, 1);
        for (int i = 0; i < score.length; i++) {
            Person person = list.get(i);
            int sum = person.english + person.math;
            for (Person p : list) {
                if (sum < p.math + p.english) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }

    class Person {
        int index;
        int math;
        int english;

        public Person(int index, int math, int english) {
            this.index = index;
            this.math = math;
            this.english = english;
        }
    }
}
