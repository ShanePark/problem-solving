package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PerformanceReview2 {

    @Test
    public void test() {
        assertThat(solution(Ps.intArray("[[2,2],[1,4],[3,2],[3,2],[2,1]]"))).isEqualTo(4);
        assertThat(solution(Ps.intArray("[[0,0],[1,4],[3,2],[3,2],[2,1]]"))).isEqualTo(-1);
        assertThat(solution(Ps.intArray("[[2,3],[1,10],[2,11]]"))).isEqualTo(2);
    }

    @Test
    public void tle() {
        int[][] arr = new int[100_000][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 100;
            arr[i][1] = 100;
        }
        assertThat(solution(arr)).isEqualTo(1);
    }

    public int solution(int[][] scores) {
        List<Person> people = new ArrayList<>();
        Person wanho = null;
        for (int i = 0; i < scores.length; i++) {
            Person person = new Person(i, scores[i][0], scores[i][1]);
            people.add(person);
            if (i == 0) {
                wanho = person;
            }
        }

        Collections.sort(people);
        List<Person> validPeople = new ArrayList<>();
        int maxRating = -1;

        for (Person p : people) {
            if (maxRating <= p.rating) {
                validPeople.add(p);
            } else if (p.index == 0) {
                return -1;
            }
            maxRating = Math.max(maxRating, p.rating);
        }

        int aboveScoreCnt = 0;
        int wanhoScore = wanho.getTotal();
        for (Person person : validPeople) {
            if (wanhoScore < person.getTotal()) {
                aboveScoreCnt++;
            }
        }
        return aboveScoreCnt + 1;
    }

    static class Person implements Comparable<Person> {
        final int index;
        final int attitude;
        final int rating;

        public Person(int index, int attitude, int rating) {
            this.index = index;
            this.attitude = attitude;
            this.rating = rating;
        }

        public int getTotal() {
            return this.attitude + this.rating;
        }

        @Override
        public int compareTo(Person o) {
            if (this.attitude == o.attitude) {
                return this.rating - o.rating;
            }
            return o.attitude - this.attitude;
        }
    }

}
