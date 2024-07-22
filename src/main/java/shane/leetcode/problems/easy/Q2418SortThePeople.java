package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime13msBeats38.59%
 */
public class Q2418SortThePeople {

    @Test
    public void test() {
        assertThat(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170}))
                .containsExactly("Mary", "Emma", "John");
        assertThat(sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150}))
                .containsExactly("Bob", "Alice", "Bob");
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new Person(heights[i], names[i]));
        }
        return people.stream()
                .sorted(Comparator.comparingInt(p -> -p.height))
                .map(p -> p.name)
                .toArray(String[]::new);
    }

    static class Person {
        public Person(int height, String name) {
            this.height = height;
            this.name = name;
        }

        final int height;
        final String name;
    }

}
