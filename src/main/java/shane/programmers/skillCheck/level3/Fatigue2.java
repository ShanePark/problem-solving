package shane.programmers.skillCheck.level3;

import org.junit.jupiter.api.Assertions;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Fatigue2 {
    public static void main(String[] args) {
        Assertions.assertEquals(12, solution(4, new int[]{4, 3, 3}));
        Assertions.assertEquals(6, solution(1, new int[]{2, 1, 2}));
        Assertions.assertEquals(0, solution(3, new int[]{1, 1}));
    }

    public static long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int work : works) {
            q.add(work);
        }

        while (n > 0) {
            int max = q.poll();
            if(max == 0)
                return 0;
            q.add(max - 1);
            n--;
        }

        long sum = 0;
        for(int i : q){
            sum += (long) i * i;
        }

        return sum;

    }

}
