package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 73/89 testcases passed O(N²)
 */
public class Q2306NamingACompany {

    @Test
    public void test() {
        assertThat(distinctNames(new String[]{"coffee", "donuts", "time", "toffee"})).isEqualTo(6);
        assertThat(distinctNames(new String[]{"lack", "back"})).isEqualTo(0);
    }

    public long distinctNames(String[] ideas) {
        Set<String> names = new HashSet<>();
        for (String idea : ideas) {
            names.add(idea);
        }
        for (int i = 0; i < ideas.length; i++) {
            for (int j = i + 1; j < ideas.length; j++) {
                String first = ideas[i];
                String second = ideas[j];
                String swapFirst = second.charAt(0) + first.substring(1, first.length());
                String swapSecond = first.charAt(0) + second.substring(1, second.length());
                if (!names.contains(swapFirst) && !names.contains(swapSecond)) {
                    names.add(swapFirst + " " + swapSecond);
                    names.add(swapSecond + " " + swapFirst);
                }
            }
        }
        return names.size() - ideas.length;
    }

}
