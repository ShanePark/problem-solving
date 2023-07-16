package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BackTracking TLE
 */
public class Q1125SmallestSufficientTeam2 {

    @Test
    void test() {
        assertThat(smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"}, Ps.strList("[[\"java\"],[\"nodejs\"],[\"nodejs\",\"reactjs\"]]"))).containsExactlyInAnyOrder(0, 2);
        assertThat(smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"}, Ps.strList("[[\"algorithms\",\"math\",\"java\"],[\"algorithms\",\"math\",\"reactjs\"],[\"java\",\"csharp\",\"aws\"],[\"reactjs\",\"csharp\"],[\"csharp\",\"math\"],[\"aws\",\"java\"]]")))
                .containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void tle() {
        assertThat(smallestSufficientTeam(new String[]{"ldq", "lpah", "i", "ypowcknvrcuouhe", "jftllvrfghmvt", "svscjulmksgo", "xt", "mnfgnpsqhcobst"}, Ps.strList("[[\"lpah\",\"xt\"],[\"ldq\",\"i\"],[\"ypowcknvrcuouhe\"],[\"lpah\",\"jftllvrfghmvt\",\"mnfgnpsqhcobst\"],[\"xt\"],[\"i\",\"xt\"],[\"svscjulmksgo\"],[\"i\"],[\"i\",\"ypowcknvrcuouhe\"],[\"i\"],[],[\"svscjulmksgo\",\"mnfgnpsqhcobst\"],[],[\"xt\",\"mnfgnpsqhcobst\"],[],[\"ypowcknvrcuouhe\",\"mnfgnpsqhcobst\"],[\"i\"],[],[\"jftllvrfghmvt\",\"svscjulmksgo\"],[\"i\",\"mnfgnpsqhcobst\"],[\"jftllvrfghmvt\"],[\"jftllvrfghmvt\"],[],[\"i\"],[\"ypowcknvrcuouhe\"],[\"ypowcknvrcuouhe\"],[],[],[],[\"ldq\",\"i\"]]")))
                .hasSize(4);
    }

    int[] answer;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < people.size(); i++) {
            List<String> skill = people.get(i);
            Person person = new Person(i, skill);
            list.add(person);
        }

        answer = new int[people.size() + 1];

        dfs(list, 0, new HashSet<>(), new ArrayList<>(), req_skills.length);
        return answer;
    }

    private void dfs(List<Person> list, int index, Set<Integer> visited, List<String> skills, int target) {
        if (list.size() == index)
            return;
        if (answer.length <= visited.size()) {
            return;
        }

        // skip
        dfs(list, index + 1, visited, skills, target);

        // visit
        Person person = list.get(index);
        visited.add(person.index);

        int beforeSize = skills.size();
        skills.addAll(person.skills);

        if (skills.stream().distinct().count() == target) {
            answer = visited.stream().mapToInt(Integer::intValue).toArray();
        }

        int afterSize = skills.size();
        dfs(list, index + 1, visited, skills, target);
        visited.remove(person.index);
        for (int i = 0; i < afterSize - beforeSize; i++) {
            skills.remove(beforeSize);
        }

    }

    class Person {
        int index;
        Set<String> skills = new HashSet<>();

        public Person(int index, List<String> skill) {
            this.index = index;
            for (String s : skill) {
                this.skills.add(s);
            }
        }

        @Override
        public String toString() {
            return "Person{" +
                    "index=" + index +
                    ", skills=" + skills +
                    '}';
        }
    }

}
