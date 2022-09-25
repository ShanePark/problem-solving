package shane.leetcode.contest.weekly.w312;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    // java 버전 바꾸기 8이나 11로

    @Test
    public void test() {
        assertThat(sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})).containsExactly("Mary", "Emma", "John");
        assertThat(sortPeople(new String[]{"Alice", "Bob", "Bob"}, new int[]{155, 185, 150})).containsExactly("Bob", "Alice", "Bob");
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Person(names[i], heights[i]));
        }
        return list.stream().sorted().map(p -> p.name).collect(Collectors.toList()).toArray(String[]::new);
    }

    class Person implements Comparable {
        String name;
        int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Object o) {
            Person p = (Person) o;
            return Integer.compare(p.height, this.height);
        }
    }

}
