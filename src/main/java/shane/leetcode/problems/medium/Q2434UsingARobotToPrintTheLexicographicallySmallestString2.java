package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2434UsingARobotToPrintTheLexicographicallySmallestString2 {

    @Test
    public void test() {
        assertThat(robotWithString("vzhofnpo")).isEqualTo("fnohopzv");
        assertThat(robotWithString("bac")).isEqualTo("abc");
        assertThat(robotWithString("zza")).isEqualTo("azz");
        assertThat(robotWithString("bdda")).isEqualTo("addb");
    }

    public String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n];
        minSuffix[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = s.charAt(i);
            if (minSuffix[i + 1] < s.charAt(i)) {
                minSuffix[i] = minSuffix[i + 1];
            }
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            while (!stack.isEmpty() && stack.peek() <= minSuffix[i == n - 1 ? n - 1 : i + 1]) {
                sb.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
