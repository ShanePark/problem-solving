package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MostPresent {

    @Test
    public void test() {
        assertThat(solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"})).isEqualTo(2);
        assertThat(solution(new String[]{"joy", "brad", "alessandro", "conan", "david"}, new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"})).isEqualTo(4);
        assertThat(solution(new String[]{"a", "b", "c"}, new String[]{"a b", "b a", "c a", "a c", "a c", "c a"})).isEqualTo(0);
    }

    public int solution(String[] friends, String[] gifts) {
        Map<String, Person> map = new HashMap<>();
        Map<Person, Integer> receives = new HashMap<>();
        for (String s : friends) {
            map.put(s, new Person());
        }
        for (String gift : gifts) {
            String[] split = gift.split(" ");
            Person from = map.get(split[0]);
            Person to = map.get(split[1]);
            from.map.merge(to, 1, Integer::sum);
            to.map.merge(from, -1, Integer::sum);
            from.giftIndex++;
            to.giftIndex--;
        }

        List<Person> people = new ArrayList<>(map.values());
        for (int i = 0; i < people.size(); i++) {
            for (int j = i + 1; j < people.size(); j++) {
                Person p1 = people.get(i);
                Person p2 = people.get(j);
                int index = p1.map.getOrDefault(p2, 0);
                if (index < 0) {
                    receives.merge(p2, 1, Integer::sum);
                    continue;
                }
                if (index > 0) {
                    receives.merge(p1, 1, Integer::sum);
                    continue;
                }
                if (p1.giftIndex == p2.giftIndex)
                    continue;
                if (p1.giftIndex < p2.giftIndex) {
                    receives.merge(p2, 1, Integer::sum);
                } else {
                    receives.merge(p1, 1, Integer::sum);
                }
            }
        }
        if (receives.isEmpty())
            return 0;
        return receives.values().stream().mapToInt(Integer::valueOf).max().getAsInt();
    }

    static class Person {
        Map<Person, Integer> map = new HashMap<>();
        int giftIndex = 0;
    }

}
