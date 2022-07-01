package shane.boj.problems.b10828;

import java.io.*;
import java.util.Stack;

public class Main {

    void main() throws IOException {
        //input
        int count = Integer.parseInt(br.readLine());

        //logic
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            String input = br.readLine();
            if (input.startsWith("push")) {
                stack.push(Integer.parseInt(input.split(" ")[1]));
            } else if ("top".equals(input)) {
                if (stack.isEmpty()) {
                    println(-1);
                } else {
                    println(stack.peek());
                }
            } else if ("size".equals(input)) {
                println(stack.size());
            } else if ("pop".equals(input)) {
                if (stack.isEmpty()) {
                    println(-1);
                } else {
                    println(stack.pop());
                }
            } else if ("empty".equals(input)) {
                println(stack.isEmpty() ? 1 : 0);
            }
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Main().main();
        bw.flush();
        bw.close();
        br.close();
    }

    void println(int n) throws IOException {
        println(String.valueOf(n));
    }

    void println(String str) throws IOException {
        bw.write(str + "\n");
    }

}
