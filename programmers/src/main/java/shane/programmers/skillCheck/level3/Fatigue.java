package shane.programmers.skillCheck.level3;

import org.junit.jupiter.api.Assertions;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (2.83ms, 72.9MB)
 * 테스트 2 〉	통과 (2.53ms, 76MB)
 * 테스트 3 〉	통과 (2.46ms, 77.5MB)
 * 테스트 4 〉	통과 (2.58ms, 74.6MB)
 * 테스트 5 〉	통과 (2.55ms, 84.4MB)
 * 테스트 6 〉	통과 (2.61ms, 75.2MB)
 * 테스트 7 〉	통과 (2.40ms, 72.5MB)
 * 테스트 8 〉	통과 (4.10ms, 75.2MB)
 * 테스트 9 〉	통과 (4.74ms, 74MB)
 * 테스트 10 〉	통과 (2.61ms, 79.4MB)
 * 테스트 11 〉	통과 (2.48ms, 78.6MB)
 * 테스트 12 〉	통과 (2.70ms, 73.5MB)
 * 테스트 13 〉	통과 (0.59ms, 77.1MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (135.82ms, 68.3MB)
 * 테스트 2 〉	실패 (120.14ms, 69.4MB)
 * 채점 결과
 * 정확성: 43.3
 * 효율성: 0.0
 * 합계: 43.3 / 50
 */
public class Fatigue {
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
            if (q.peek() == 0)
                return 0;
            q.add(q.poll() - 1);
            n--;
        }

        return q.stream().flatMapToInt(i -> IntStream.of(i * i)).sum();

    }

}
