package shane.programmers.skillCheck.level3;

import org.junit.jupiter.api.Assertions;

public class DeliverGoldAndSilver {
    public static void main(String[] args) {
        Assertions.assertEquals(50, solution(10, 10, new int[]{100}, new int[]{100}, new int[]{7}, new int[]{10}));
        Assertions.assertEquals(499, solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500}, new int[]{100, 100, 2}, new int[]{4, 8, 1}));
    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;
        return answer;
    }

}
