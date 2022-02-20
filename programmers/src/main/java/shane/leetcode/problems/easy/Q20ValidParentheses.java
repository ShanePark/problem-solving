package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

public class Q20ValidParentheses {

    public static void main(String[] args) {
        Assertions.assertEquals(isValid("()"), true);
        Assertions.assertEquals(isValid("()[]{}"), true);
        Assertions.assertEquals(isValid("([)]"), false);
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack();

        try {
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                    case '[':
                    case '{':
                        stack.push(c);
                        break;
                    case ')':
                        if (stack.pop() != '(')
                            return false;
                        break;
                    case ']':
                        if (stack.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (stack.pop() != '{')
                            return false;
                        break;
                }
            }
        } catch (Exception e) {
            return false;
        }

        return stack.empty();

    }

}
