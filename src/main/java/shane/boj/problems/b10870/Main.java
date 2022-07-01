package shane.boj.problems.b10870;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    void main() throws IOException {
        //input
        String line = br.readLine();
        int n = Integer.parseInt(line);

        long[] dp = new long[21];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        //output
        println(dp[n]);
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
