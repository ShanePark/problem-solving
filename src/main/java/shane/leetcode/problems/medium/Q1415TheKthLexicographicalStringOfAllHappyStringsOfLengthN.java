package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1415TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

    @Test
    public void test() {
        assertThat(getHappyString(3, 9)).isEqualTo("cab");
        assertThat(getHappyString(1, 3)).isEqualTo("c");
        assertThat(getHappyString(1, 4)).isEqualTo("");
    }

    public String getHappyString(int n, int k) {
        List<List<String>> happy = new ArrayList<>();
        happy.add(Arrays.asList("a", "b", "c"));

        if (n == 1) {
            if (k > 3) return "";
            else return happy.get(0).get(k - 1);
        }

        for (int i = 1; i < n; i++) {
            List<String> newHappy = new ArrayList<>();
            for (String s1 : happy.get(0)) {
                for (String s2 : happy.get(happy.size() - 1)) {
                    if (s1.charAt(0) != s2.charAt(0)) {
                        if (i < n - 1) {
                            newHappy.add(s1 + s2);
                        } else {
                            if (--k == 0) {
                                return s1 + s2;
                            }
                        }
                    }
                }
            }
            happy.add(newHappy);
        }

        return "";
    }
}
