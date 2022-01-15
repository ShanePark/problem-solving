package shane.programmers.lv2a;

import java.util.PriorityQueue;

@SuppressWarnings("DuplicatedCode")
public class F_Spicier {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1}, 4) == 2);
        System.out.println(solution(new int[]{10, 10, 10, 10, 10}, 100) == 4);
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7) == 2);
        System.out.println(solution(new int[]{0, 2, 3, 9, 10, 12}, 7) == 2);
        System.out.println(solution(new int[]{0, 0, 3, 9, 10, 12}, 7) == 3);    // 해결 필요
        System.out.println(solution(new int[]{0, 0, 0, 0}, 7) == -1);
        System.out.println(solution(new int[]{0, 0, 3, 9, 10, 12}, 7000) == -1);
        System.out.println(solution(new int[]{0, 0, 3, 9, 10, 12}, 0) == 0);    // answer must be 0
        System.out.println(solution(new int[]{0, 0, 3, 9, 10, 12}, 1) == 2);
        System.out.println(solution(new int[]{0, 0}, 0) == 0); // answer must be 0
        System.out.println(solution(new int[]{0, 0}, 1) == -1);
        System.out.println(solution(new int[]{1, 0}, 1) == 1);
        System.out.println(solution(new int[]{1, 2, 3}, 11));

    }

    static public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i : scoville) {
            q.offer(i);
        }

        int count = 0;

        while (q.size() >= 2 && q.peek() < K) {
            count++;
            q.add(q.poll() + 2 * q.poll());
        }
        return K <= q.peek() ? count : -1;

    }

}
