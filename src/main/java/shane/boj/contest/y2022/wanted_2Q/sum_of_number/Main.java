package shane.boj.contest.y2022.wanted_2Q.sum_of_number;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * failed
 */
public class Main {

    @Test
    public void test() {
        assertThat(solution(10, new long[]{1, 5, 2, 3, 4, 1, 2, 4, 2, 1}, new long[]{1, 5, 2, 3, 4, 1, 2, 4, 2, 1})).isEqualTo(55);
        assertThat(solution(4, new long[]{0, 1, 3, 2}, new long[]{1, 0, 3, 2})).isEqualTo(6);
        assertThat(solution(4, new long[]{0, 0, 0, 0}, new long[]{0, 0, 0, 0})).isEqualTo(10);
        assertThat(solution(3, new long[]{1, 2, 3}, new long[]{1, 3, 2})).isEqualTo(3);
        assertThat(solution(5, new long[]{1, 2, 3, 4, 5}, new long[]{4, 5, 6, 7, 8})).isEqualTo(0);
    }

    private long solution(int length, long[] arr1, long[] arr2) {
        long[] arr = new long[length];

        for (int i = 0; i < length; i++) {
            arr[i] = arr1[i] - arr2[i];
        }

        long[] dp = new long[length];
        long sum = arr1[0] - arr2[0];
        long cnt = sum == 0 ? 1 : 0;
        dp[0] = cnt;
        for (int i = 1; i < length; i++) {
            long n = arr[i];
            sum += n;
            if (sum == 0) {
                dp[i] = ++cnt;
            }
        }
        return Arrays.stream(dp).sum();
    }

    void main() throws IOException {
        //input
        int length = Integer.parseInt(br.readLine());
        long[] arr1 = new long[length];
        long[] arr2 = new long[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr1[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr2[i] = Long.parseLong(st.nextToken());
        }

        println(solution(length, arr1, arr2));
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
