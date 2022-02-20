package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Q22GenerateParentheses {

    @Test
    void test() {
        Assertions.assertThat(generateParenthesis(3)).contains("((()))", "(()())", "(())()", "()(())", "()()()");
        Assertions.assertThat(generateParenthesis(1)).contains("()");
    }

    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("()");
        for (int i = 1; i < n; i++) {
            set = make(set);
        }
        return set.stream().collect(Collectors.toList());
    }

    private Set<String> make(Set<String> set) {
        Set<String> temp = new HashSet<>();
        for (String s : set) {
            for (int i = 0; i < s.length(); i++) {
                temp.add(s.substring(0, i) + "()" + s.substring(i, s.length()));
            }
        }
        return temp;
    }

}
