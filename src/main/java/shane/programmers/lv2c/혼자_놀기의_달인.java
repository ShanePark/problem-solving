package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class 혼자_놀기의_달인 {

    @Test
    public void test() {
        assertThat(solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4})).isEqualTo(12);
        assertThat(solution(new int[]{1})).isEqualTo(0);
    }

    public int solution(int[] cards) {
        final int LENGTH = cards.length;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= LENGTH; i++) {
            q.offer(i);
        }
        List<Integer> sizes = new ArrayList<>();
        int cur = 1;
        int curSize = 0;

        while (!q.isEmpty()) {
            if (q.remove(cur)) {
                cur = cards[cur - 1];
                curSize++;
            } else {
                sizes.add(curSize);
                cur = q.peek();
                curSize = 0;
            }
        }
        sizes.add(curSize);

        if (sizes.size() == 1)
            return 0;

        Collections.sort(sizes, Comparator.reverseOrder());
        return sizes.get(0) * sizes.get(1);
    }

}
