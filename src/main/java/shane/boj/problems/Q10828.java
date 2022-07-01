package shane.boj.problems;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Q10828 {

    public static void main(String[] args) throws IOException {
        //input
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= count; i++) {
            String input = scanner.nextLine();
            if (input.startsWith("push")) {
                stack.push(Integer.parseInt(input.split(" ")[1]));
            } else if ("top".equals(input)) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            } else if ("size".equals(input)) {
                System.out.println(stack.size());
            } else if ("pop".equals(input)) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if ("empty".equals(input)) {
                System.out.println(stack.isEmpty() ? 1 : 0);
            }
        }
    }

}
