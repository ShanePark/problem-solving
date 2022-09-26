package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 9 ms, faster than 6.11% of Java online submissions for Satisfiability of Equality Equations.
 * Memory Usage: 43.7 MB, less than 7.72% of Java online submissions for Satisfiability of Equality Equations.
 */
public class Q990SatisfiabilityOfEqualityEquations {

    @Test
    public void test() {
        assertThat(equationsPossible(new String[]{"b!=f", "c!=e", "f==f", "d==f", "b==f", "a==f"})).isFalse();
        assertThat(equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c"})).isTrue();
        assertThat(equationsPossible(new String[]{"a!=a"})).isFalse();
        assertThat(equationsPossible(new String[]{"a==b", "b!=a"})).isFalse();
        assertThat(equationsPossible(new String[]{"b==a", "a==b"})).isTrue();
    }

    public boolean equationsPossible(String[] equations) {
        Map<Character, Set<Character>> groups = new HashMap<>();
        Boolean[][] record = new Boolean[26][26];
        for (String equation : equations) {
            char a = equation.charAt(0);
            char b = equation.charAt(3);
            boolean same = equation.charAt(1) == '=';

            if ((record[a - 'a'][b - 'a'] != null && record[a - 'a'][b - 'a'] != same) || (record[b - 'a'][a - 'a'] != null && record[b - 'a'][a - 'a'] != same)) {
                return false;
            }

            record[a - 'a'][b - 'a'] = same;
            record[b - 'a'][a - 'a'] = same;

            Set<Character> groupA = groups.get(a);
            Set<Character> groupB = groups.get(b);
            if (a == b && !same) {
                return false;
            } else if (groupA == null && groupB == null) {
                groupA = new HashSet<>();
                groupB = same ? groupA : new HashSet<>();

                groupA.add(a);
                groupB.add(b);
                groups.put(a, groupA);
                groups.put(b, groupB);
            } else if (groupA == null) {
                groupA = same ? groupB : new HashSet<>();
                groupA.add(a);
                groups.put(a, groupA);
            } else if (groupB == null) {
                groupB = same ? groupA : new HashSet<>();
                groupB.add(b);
                groups.put(b, groupB);
            } else {
                if (same && groupA != groupB) {
                    // checked whether it can be merged
                    for (Character c1 : groupA) {
                        for (Character c2 : groupB) {
                            if (record[c1 - 'a'][c2 - 'a'] != null && !record[c1 - 'a'][c2 - 'a'])
                                return false;
                        }
                    }
                    // if possible merge it
                    groupA.addAll(groupB);
                    for (Character bMember : groupB) {
                        groups.put(bMember, groupA);
                    }
                }
                if (!same && groupA == groupB) {
                    return false;
                }
            }
        }
        return true;
    }

}
