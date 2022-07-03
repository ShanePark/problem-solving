package shane.boj.problems.gold.b1644;
/**
 * don't forget to Copy from import to the EOF
 * try not to copy first line "package ..."
 * * * * * * * * * * * * * * * * *
 */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

    @Test
    public void test() {
        assertThat(solution(20)).isEqualTo(0);
        assertThat(solution(3)).isEqualTo(1);
        assertThat(solution(41)).isEqualTo(3);
        assertThat(solution(53)).isEqualTo(2);
    }

    private int solution(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        int left = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < primes.size(); i++) {
            sum += primes.get(i);
            while (sum > n) {
                sum -= primes.get(left++);
            }
            if (sum == n) {
                cnt++;
            }
        }

        return cnt;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    void main() throws IOException {
        //input
        int input = Integer.parseInt(br.readLine());

        //logic
        int result = solution(input);

        //output
        println(result);
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
