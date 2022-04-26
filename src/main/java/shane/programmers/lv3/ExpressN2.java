package shane.programmers.lv3;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.69ms, 76.9MB)
 * 테스트 2 〉	통과 (0.05ms, 75.5MB)
 * 테스트 3 〉	통과 (0.07ms, 76.2MB)
 * 테스트 4 〉	통과 (3.71ms, 77.2MB)
 * 테스트 5 〉	실패 (4.13ms, 77.9MB)
 * 테스트 6 〉	실패 (1.80ms, 83.3MB)
 * 테스트 7 〉	실패 (0.86ms, 73.1MB)
 * 테스트 8 〉	실패 (4.84ms, 78.3MB)
 * 테스트 9 〉	통과 (0.02ms, 78.6MB)
 * 채점 결과
 * 정확성: 55.6
 * 합계: 55.6 / 100.0
 */
public class ExpressN2 {

    public static void main(String[] args) {
//        System.out.println(solution(5, 12));
//        System.out.println(solution(2, 11));
//        System.out.println(solution(5, 31168));
    }

    public static int solution(int N, int number) {
        if (N == number)
            return 1;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(new HashSet<>());
        }

        list.get(1).add(N);
        list.get(2).add(0);
        list.get(2).add(1);
        list.get(2).add(2 * N);
        list.get(2).add(N * N);
        list.get(2).add(11 * N);
        list.get(3).add(N * 111);
        list.get(4).add(N * 1111);

        for (int i = 2; i < 9; i++) {
            if (list.get(i).contains(number)) {
                return i;
            }
            calc(N, i, list);
        }

        return -1;

    }

    public static void calc(int N, int i, List<Set<Integer>> list) {
        Set<Integer> set = list.get(i);
        Set<Integer> next = list.get(i + 1);
        for (Integer n : set) {
            next.add(n + N);
            next.add(n - N);
            next.add(N - n);
            next.add(n * N);
            if (N != 0)
                next.add(n / N);
            if (n != 0)
                next.add(N / n);
        }
    }

}
