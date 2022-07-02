package shane.boj.problems.gold.b1756;
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
 * TLE 8163 ms
 */
public class MainF1 {

    @Test
    public void test() {
        assertThat(findPizza(new int[]{5, 6, 4, 3, 6, 2, 3}, new int[]{3, 2, 5})).isEqualTo(2);
        assertThat(findPizza(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5})).isEqualTo(6);
        assertThat(findPizza(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1})).isEqualTo(1);

        int[] places = new int[300000];
        int[] pizzas = new int[300000];
        Arrays.fill(places, 1);
        Arrays.fill(pizzas, 1);
        long start = System.currentTimeMillis();
        assertThat(findPizza(places, pizzas)).isEqualTo(1);
        System.out.println("logic end : " + (System.currentTimeMillis() - start) + "ms");

    }

    int findPizza(int[] places, int[] pizzas) {
        int depth = places.length;
        for (int pizza : pizzas) {
            for (int i = 0; i < depth; i++) {
                int place = places[i];
                if (pizza > place) {
                    depth = i - 1;
                    break;
                }
            }
            depth--;
        }
        return depth + 1;
    }

    void main() throws IOException {
        //input
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int depth = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        line = br.readLine();
        st = new StringTokenizer(line);
        int[] places = new int[depth];
        for (int i = 0; i < depth; i++) {
            places[i] = Integer.parseInt(st.nextToken());
        }

        line = br.readLine();
        st = new StringTokenizer(line);

        int[] pizzas = new int[count];
        for (int i = 0; i < count; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        println(findPizza(places, pizzas));
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new MainF1().main();
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
