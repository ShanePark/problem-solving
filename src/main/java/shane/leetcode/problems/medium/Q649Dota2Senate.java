package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 13 ms Beats 29.55%
 * Memory 43.5 MB Beats 13.64%
 */
public class Q649Dota2Senate {

    @Test
    public void test() {
        assertThat(predictPartyVictory("RD")).isEqualTo("Radiant");
        assertThat(predictPartyVictory("RDD")).isEqualTo("Dire");
    }

    public String predictPartyVictory(String senate) {
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            q.offer(senate.charAt(i));
        }

        int rPower = 0;
        int dPower = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Character poll = q.poll();
                if (poll == 'R') {
                    if (dPower > 0) {
                        dPower--;
                    } else {
                        rPower++;
                        q.offer(poll);
                    }
                } else {
                    if (rPower > 0) {
                        rPower--;
                    } else {
                        dPower++;
                        q.offer(poll);
                    }
                }
            }
            if (q.size() == size) {
                return q.peek() == 'R' ? "Radiant" : "Dire";
            }
        }
        return null;
    }

}
