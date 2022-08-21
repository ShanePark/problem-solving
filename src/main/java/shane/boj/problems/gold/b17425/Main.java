package shane.boj.problems.gold.b17425;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.Arrays;

public class Main {

    void main() throws IOException {

        int cnt = Integer.parseInt(br.readLine());

        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            String line = br.readLine();
            arr[i] = Integer.parseInt(line);
        }

        long[] dp = new long[1000001];
        Arrays.fill(dp, 1);

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 1; i * j <= 1000000; j++) {
                dp[i * j] += i;
            }
        }

        long[] answer = new long[1000001];
        for (int i = 1; i <= 1000000; i++) {
            answer[i] = answer[i - 1] + dp[i];
        }

        for (int i : arr) {
            println(answer[i]);
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

    void println(long n) throws IOException {
        println(String.valueOf(n));
    }

    void println(String str) throws IOException {
        bw.write(str + "\n");
    }

}
