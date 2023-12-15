package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 34.58%of users with Java
 * Memory Details 43.61MB Beats 7.38%of users with Java
 */
public class Q1436DestinationCity2 {

    @Test
    public void test() {
        assertThat(destCity(Ps.strList("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]"))).isEqualTo("Sao Paulo");
        assertThat(destCity(Ps.strList("[[\"B\",\"C\"],[\"D\",\"B\"],[\"C\",\"A\"]]"))).isEqualTo("A");
        assertThat(destCity(Ps.strList("[[\"A\",\"Z\"]]"))).isEqualTo("Z");
    }

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(1));
        }
        for (List<String> path : paths) {
            set.remove(path.get(0));
        }
        return set.stream().findFirst().orElse(null);
    }

}
