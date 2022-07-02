package shane.boj.problems.silver.b17427;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;

/**
 * 2615ms
 */
public class MainF1 {

    void main() throws IOException {
        long start = System.currentTimeMillis();
        //input
        String line = br.readLine();

        //logic
        int input = Integer.parseInt(line);

        long[] dp = new long[input + 1];
        for (int i = 1; i <= input; i++) {
            dp[i] = dp[i - 1] + sumOfElements(i);
        }

        //output
        println(dp[input]);
        System.out.println("END: " + (System.currentTimeMillis() - start) + "ms");
    }

    private long sumOfElements(int input) {
        if (input == 1)
            return 1;
        long sum = 0;
        for (int i = 1; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                sum += i;
                if (i != input / i) {
                    sum += input / i;
                }
            }
        }
        return sum;
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new MainF1().main();
        bw.flush();
        bw.close();
        br.close();
    }

    void println(long n) throws IOException {
        println(String.valueOf(n));
    }

    void println(String str) throws IOException {
        bw.write(str + "\n");
    }

}
