package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Satisfiability of Equality Equations.
 * Memory Usage: 42 MB, less than 81.80% of Java online submissions for Satisfiability of Equality Equations.
 */
@SuppressWarnings("ALL")
public class Q990SatisfiabilityOfEqualityEquations2 {

    @Test
    public void test() {
        assertThat(equationsPossible(new String[]{"b!=f", "c!=e", "f==f", "d==f", "b==f", "a==f"})).isFalse();
        assertThat(equationsPossible(new String[]{"c==c", "f!=a", "f==b", "b==c"})).isTrue();
        assertThat(equationsPossible(new String[]{"a!=a"})).isFalse();
        assertThat(equationsPossible(new String[]{"a==b", "b!=a"})).isFalse();
        assertThat(equationsPossible(new String[]{"b==a", "a==b"})).isTrue();
    }

    public boolean equationsPossible(String[] equations) {
        int[] arr = new int[26];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;

        for (String equation : equations) {
            boolean same = equation.charAt(1) == '=';
            if (same) {
                arr[unionFind(equation.charAt(0) - 'a', arr)] = unionFind(equation.charAt(3) - 'a', arr);
            }
        }
        for (String equation : equations) {
            boolean same = equation.charAt(1) == '=';
            if (!same && unionFind(equation.charAt(0) - 'a', arr) == unionFind(equation.charAt(3) - 'a', arr))
                return false;
        }
        return true;
    }

    public int unionFind(int x, int[] arr) {
        if (x != arr[x]) {
            arr[x] = unionFind(arr[x], arr);
        }
        return arr[x];
    }

}
