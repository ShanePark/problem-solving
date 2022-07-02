package shane.boj.problems.silver.b17427;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

    @Test
    public void test() throws IOException {
        assertThat(solution(1)).isEqualTo(1);
        assertThat(solution(2)).isEqualTo(4);
        assertThat(solution(10)).isEqualTo(87);
        assertThat(solution(70)).isEqualTo(4065);
        assertThat(solution(1000)).isEqualTo(823081L);
        assertThat(solution(10000)).isEqualTo(82256014);
        assertThat(solution(100000)).isEqualTo(8224740835L);
        assertThat(solution(1000000)).isEqualTo(822468118437L);
    }

    void main() throws IOException {
        //input
        String line = br.readLine();

        //logic
        int input = Integer.parseInt(line);
        //output
        System.out.println(solution(input));
    }

    long solution(int n) {
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (n / i) * i;
        }
        return answer;
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
