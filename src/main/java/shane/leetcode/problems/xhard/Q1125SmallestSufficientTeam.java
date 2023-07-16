package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 32 / 38 testcases passed
 */
public class Q1125SmallestSufficientTeam {

    @Test
    void test() {
        assertThat(smallestSufficientTeam(new String[]{"algorithms", "math", "java", "reactjs", "csharp", "aws"}, Ps.strList("[[\"algorithms\",\"math\",\"java\"],[\"algorithms\",\"math\",\"reactjs\"],[\"java\",\"csharp\",\"aws\"],[\"reactjs\",\"csharp\"],[\"csharp\",\"math\"],[\"aws\",\"java\"]]")))
                .containsExactlyInAnyOrder(1, 2);
        assertThat(smallestSufficientTeam(new String[]{"java", "nodejs", "reactjs"}, Ps.strList("[[\"java\"],[\"nodejs\"],[\"nodejs\",\"reactjs\"]]"))).containsExactlyInAnyOrder(0, 2);
    }

    @Test
    void wrong() {
        assertThat(smallestSufficientTeam(new String[]{"ldq", "lpah", "i", "ypowcknvrcuouhe", "jftllvrfghmvt", "svscjulmksgo", "xt", "mnfgnpsqhcobst"}, Ps.strList("[[\"lpah\",\"xt\"],[\"ldq\",\"i\"],[\"ypowcknvrcuouhe\"],[\"lpah\",\"jftllvrfghmvt\",\"mnfgnpsqhcobst\"],[\"xt\"],[\"i\",\"xt\"],[\"svscjulmksgo\"],[\"i\"],[\"i\",\"ypowcknvrcuouhe\"],[\"i\"],[],[\"svscjulmksgo\",\"mnfgnpsqhcobst\"],[],[\"xt\",\"mnfgnpsqhcobst\"],[],[\"ypowcknvrcuouhe\",\"mnfgnpsqhcobst\"],[\"i\"],[],[\"jftllvrfghmvt\",\"svscjulmksgo\"],[\"i\",\"mnfgnpsqhcobst\"],[\"jftllvrfghmvt\"],[\"jftllvrfghmvt\"],[],[\"i\"],[\"ypowcknvrcuouhe\"],[\"ypowcknvrcuouhe\"],[],[],[],[\"ldq\",\"i\"]]")))
                .containsExactlyInAnyOrder(0, 15, 18, 29);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Person> list = new ArrayList<>();
        Map<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            List<String> skill = people.get(i);
            Person person = new Person(i, skill);
            for (String s : skill) {
                frequency.merge(s, 1, Integer::sum);
            }
            list.add(person);
        }

        List<Integer> answer = new ArrayList<>();
        Set<String> curSkills = new HashSet<>();
        while (curSkills.size() < req_skills.length) {
            list.sort((p1, p2) -> {
                if (p1.skills.size() != p2.skills.size()) {
                    return p2.skills.size() - p1.skills.size();
                }
                int p1Freq = p1.skills.stream().mapToInt(s -> frequency.get(s)).sum();
                int p2Freq = p2.skills.stream().mapToInt(s -> frequency.get(s)).sum();
                return p1Freq - p2Freq;
            });

            Person person = list.get(0);
            list.remove(person);

            Set<String> newSkills = person.skills;
            curSkills.addAll(newSkills);
            answer.add(person.index);
            for (Person p : list) {
                p.skills.removeAll(newSkills);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
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
