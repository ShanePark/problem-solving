package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 674
 * ms
 * Beats
 * 7.22%
 */
public class Q2197ReplaceNonCoprimeNumbersInArray2 {

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

    Map<String, Integer> coPrimeMap = new HashMap<>();

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int before = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int coPrime = findCoPrime(before, n);
            if (coPrime == 1) {
                stack.push(before);
                before = n;
                continue;
            }
            before = (int) ((long) before * n / coPrime);
            while (!stack.isEmpty() && findCoPrime(stack.peek(), before) > 1) {
                int coPrime_ = findCoPrime(stack.peek(), before);
                int pop = stack.pop();
                before = (int) ((long) pop * before / coPrime_);
            }
        }
        stack.push(before);
        return new ArrayList<>(stack);
    }

    private int findCoPrime(int before, int n) {
        String key = before + " " + n;
        if (coPrimeMap.containsKey(key))
            return coPrimeMap.get(key);
        int min = Math.min(before, n);
        while (1 < min) {
            if (before % min == 0 && n % min == 0) {
                coPrimeMap.put(key, min);
                return min;
            }
            min--;
        }
        coPrimeMap.put(key, 1);
        return 1;
    }

}
