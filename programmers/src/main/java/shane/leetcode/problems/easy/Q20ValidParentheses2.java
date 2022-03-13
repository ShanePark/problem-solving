package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q20ValidParentheses2 {

    public static void main(String[] args) {
        Assertions.assertEquals(isValid("()"), true);
        Assertions.assertEquals(isValid("()[]{}"), true);
        Assertions.assertEquals(isValid("([)]"), false);
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || map.get(c) != stack.pop()) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();

    }

}
