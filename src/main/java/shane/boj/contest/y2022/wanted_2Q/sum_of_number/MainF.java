package shane.boj.contest.y2022.wanted_2Q.sum_of_number;
/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class MainF {

    @Test
    public void test() {
        assertThat(solution(10, new int[]{1, 5, 2, 3, 4, 1, 2, 4, 2, 1}, new int[]{1, 5, 2, 3, 4, 1, 2, 4, 2, 1})).isEqualTo(55);
        assertThat(solution(4, new int[]{0, 1, 3, 2}, new int[]{1, 0, 3, 2})).isEqualTo(6);
        assertThat(solution(4, new int[]{0, 0, 0, 0}, new int[]{0, 0, 0, 0})).isEqualTo(10);
        assertThat(solution(3, new int[]{1, 2, 3}, new int[]{1, 3, 2})).isEqualTo(3);
        assertThat(solution(5, new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 6, 7, 8})).isEqualTo(0);
    }

    private long solution(int length, int[] arr1, int[] arr2) {
        long answer = 0;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += (arr1[j] - arr2[j]);
                if (sum == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

    void main() throws IOException {
        //input
        int length = Integer.parseInt(br.readLine());
        int[] arr1 = new int[length];
        int[] arr2 = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        println(solution(length, arr1, arr2));
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new MainF().main();
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
