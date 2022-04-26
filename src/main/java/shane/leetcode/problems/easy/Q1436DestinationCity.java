package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1436DestinationCity {

    @Test
    public void test() {
        assertThat(destCity(STool.convertToStringList("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]"))).isEqualTo("Sao Paulo");
    }

    public String destCity(List<List<String>> paths) {
        Set<String> in = new HashSet<>();
        Set<String> out = new HashSet<>();
        for (List<String> path : paths) {
            in.add(path.get(0));
            out.add(path.get(1));
        }
        out.removeAll(in);
        return out.stream().collect(Collectors.toList()).get(0);
    }
}
