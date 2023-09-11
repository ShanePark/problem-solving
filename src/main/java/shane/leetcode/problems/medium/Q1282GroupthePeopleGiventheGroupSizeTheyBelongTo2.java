package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 12ms Beats 9.51%of users with Java
 * Memory Details 44.80MB Beats 20.16%of users with Java
 */
public class Q1282GroupthePeopleGiventheGroupSizeTheyBelongTo2 {

    @Test
    void test() {
        assertThat(groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3})).isEqualTo(Ps.intList("[[5],[0,1,2],[3,4,6]]"));
        assertThat(groupThePeople(new int[]{2, 1, 3, 3, 3, 2})).isEqualTo(Ps.intList("[[1],[0,5],[2,3,4]]"));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            Person person = new Person(i, groupSizes[i]);
            people.add(person);
        }
        Collections.sort(people, (p1, p2) -> {
            if (p1.groupSize == p2.groupSize)
                return Integer.compare(p1.index, p2.index);
            return Integer.compare(p1.groupSize, p2.groupSize);
        });
        int left = 0;
        List<List<Integer>> answer = new ArrayList<>();
        for (Person person : people) {
            if (left == 0) {
                answer.add(new ArrayList<>());
                left = person.groupSize;
            }
            answer.get(answer.size() - 1).add(person.index);
            left--;
        }
        return answer;
    }

    class Person {
        int index;
        int groupSize;

        public Person(int index, int groupSize) {
            this.index = index;
            this.groupSize = groupSize;
        }
    }

}
