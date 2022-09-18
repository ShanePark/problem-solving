package shane.programmers.challenge2022.jobis2022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(solution(new String[]{"AAALLLAPAA", "AAAAAAAPPP", "ALAAAAPAAA"})).containsExactly(3, 1, 2);
        assertThat(solution(new String[]{"ALALLAAPAA", "ALLLAAAPAA", "APAPALLAAA"})).containsExactly(1, 2, 3);
    }

    public int[] solution(String[] students) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < students.length; i++) {
            list.add(new Student(i + 1, students[i]));
        }
        list.sort((s1, s2) -> {
            if (s1.score == s2.score) {
                return Integer.compare(s1.num, s2.num);
            }
            return Integer.compare(s2.score, s1.score);
        });
        return list.stream().map(s -> s.num).mapToInt(Integer::intValue).toArray();
    }

    class Student {
        int num;
        int score;
        int absent = 0;
        int present = 0;
        int late = 0;

        public Student(int num, String data) {
            this.num = num;
            for (int i = 0; i < data.length(); i++) {
                char c = data.charAt(i);
                switch (c) {
                    case 'P':
                        absent++;
                        break;
                    case 'L':
                        late++;
                        break;
                    case 'A':
                        present++;
                        break;
                }
            }
            this.score = 10 + present - absent - (late / 2);
            if (absent + (late / 2) >= 3){
                this.score = 0;
            }
        }

        @Override
        public String toString() {
            return "Student{" +
                    "num=" + num +
                    ", score=" + score +
                    '}';
        }
    }

}
