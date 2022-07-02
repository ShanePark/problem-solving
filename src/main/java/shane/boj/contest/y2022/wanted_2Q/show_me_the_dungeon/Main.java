package shane.boj.contest.y2022.wanted_2Q.show_me_the_dungeon;

/**
 * don't forget to Copy from import to the EOF
 * * * * * * * * * * * * * * * * *
 */

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {

    @Test
    public void test() {
        assertThat(result(5, new int[]{5, 3, 1, 2, 4}, new int[]{10, 10, 10, 10, 10})).isEqualTo(20);
        assertThat(result(100, new int[]{1, 1, 1, 1, 1}, new int[]{10, 10, 10, 10, 10})).isEqualTo(50);
        assertThat(result(1, new int[]{2, 2, 2, 2, 2}, new int[]{2, 2, 2, 2, 2})).isEqualTo(0);
        assertThat(result(9, new int[]{1, 3, 3, 3, 1}, new int[]{1, 1, 1, 1, 1})).isEqualTo(3);
    }

    int max = 0;

    private int result(int life, int[] monsters, int[] towns) {
        max = 0;
        Town[] arr = new Town[monsters.length];
        for (int i = 0; i < monsters.length; i++) {
            arr[i] = new Town(monsters[i], towns[i]);
        }
        Arrays.sort(arr, (o1, o2) -> o1.monster - o2.monster);
        bt(life, 0, 0, 0, arr);
        return max;
    }

    private void bt(int life, int score, int dmg, int i, Town[] towns) {
        max = Math.max(max, score);
        if (i == towns.length)
            return;

        // skip
        bt(life, score, dmg, i + 1, towns);

        // check
        if (life >= dmg + towns[i].monster) {
            bt(life - dmg - towns[i].monster, score + towns[i].people, dmg + towns[i].monster, i + 1, towns);
        }
    }

    class Town {
        int monster;
        int people;

        public Town(int monster, int people) {
            this.monster = monster;
            this.people = people;
        }

        @Override
        public String toString() {
            return "Town{" +
                    "monster=" + monster +
                    ", people=" + people +
                    '}';
        }
    }


    void main() throws IOException {
        //input
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        //logic
        int cnt = Integer.parseInt(st.nextToken());
        int life = Integer.parseInt(st.nextToken());

        line = br.readLine();
        st = new StringTokenizer(line);
        int[] monsters = new int[cnt];
        int[] towns = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            monsters[i] = Integer.parseInt(st.nextToken());
        }

        line = br.readLine();
        st = new StringTokenizer(line);

        for (int i = 0; i < cnt; i++) {
            towns[i] = Integer.parseInt(st.nextToken());
        }

        int result = result(life, monsters, towns);

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
