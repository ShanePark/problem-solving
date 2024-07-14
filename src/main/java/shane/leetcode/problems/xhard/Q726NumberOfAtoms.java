package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Q726NumberOfAtoms {

    @Test
    public void test() {
        assertThat(countOfAtoms("H2O")).isEqualTo("H2O");
        assertThat(countOfAtoms("Mg(OH)2")).isEqualTo("H2MgO2");
        assertThat(countOfAtoms("K4(ON(SO3)2)2")).isEqualTo("K4N2O14S4");
    }

    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> cur = new HashMap<>();
        final int LENGTH = formula.length();

        for (int i = 0; i < LENGTH; ) {
            char c = formula.charAt(i++);
            if (c == '(') {
                stack.push(cur);
                cur = new HashMap<>();
                continue;
            }
            if (c == ')') {
                int cnt = 0;
                while (i < LENGTH && Character.isDigit(formula.charAt(i))) {
                    cnt = cnt * 10 + formula.charAt(i++) - '0';
                }
                cnt = Math.max(cnt, 1);
                if (stack.isEmpty()) {
                    continue;
                }
                Map<String, Integer> last = cur;
                cur = stack.pop();
                for (String key : last.keySet()) {
                    cur.merge(key, last.get(key) * cnt, Integer::sum);
                }
                continue;
            }
            StringBuilder atom = new StringBuilder(String.valueOf(c));
            while (i < LENGTH && Character.isLowerCase(formula.charAt(i))) {
                atom.append(formula.charAt(i));
                i++;
            }
            int cnt = 0;
            while (i < LENGTH && Character.isDigit(formula.charAt(i))) {
                cnt = cnt * 10 + formula.charAt(i++) - '0';
            }
            cur.merge(atom.toString(), Math.max(cnt, 1), Integer::sum);
        }

        return toString(cur);
    }

    private static String toString(Map<String, Integer> cnt) {
        return cnt.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> {
                    if (e.getValue() == 1)
                        return e.getKey();
                    return e.getKey() + e.getValue();
                }).collect(Collectors.joining());
    }

}
