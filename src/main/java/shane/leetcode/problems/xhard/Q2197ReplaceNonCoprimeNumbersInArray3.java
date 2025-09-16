package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Euclidean algorithm
 */
public class Q2197ReplaceNonCoprimeNumbersInArray3 {

    @Test
    public void test() {
        assertThat(replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2})).isEqualTo(List.of(12, 7, 6));
        assertThat(replaceNonCoprimes(new int[]{2, 2, 1, 1, 3, 3, 3})).isEqualTo(List.of(2, 1, 1, 3));
        assertThat(replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561})).isEqualTo(List.of(31, 97561));
        assertThat(replaceNonCoprimes(new int[]{287, 41, 49, 287, 899, 23, 23, 20677, 5, 825})).isEqualTo(List.of(2009, 20677, 825));
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i % 2 == 0 ? 100000 : 84659;
        }
        assertThat(replaceNonCoprimes(arr)).isEqualTo(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int n : nums) {
            while (!stack.isEmpty()) {
                int coPrime = findCoPrime(stack.peek(), n);
                if (coPrime == 1)
                    break;
                n = (int) ((long) n * stack.pop() / coPrime);
            }
            stack.add(n);
        }
        return stack;
    }

    private int findCoPrime(int a, int b) {
        return b > 0 ? findCoPrime(b, a % b) : a;
    }

}
