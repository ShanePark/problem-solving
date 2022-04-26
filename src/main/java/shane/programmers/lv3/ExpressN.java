package shane.programmers.lv3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (2.44ms, 73.7MB)
 * 테스트 2 〉	통과 (0.87ms, 71.8MB)
 * 테스트 3 〉	통과 (1.12ms, 73.7MB)
 * 테스트 4 〉	통과 (11.87ms, 80.9MB)
 * 테스트 5 〉	실패 (7.79ms, 89.8MB)
 * 테스트 6 〉	실패 (4.54ms, 79.5MB)
 * 테스트 7 〉	실패 (3.05ms, 73.7MB)
 * 테스트 8 〉	실패 (11.68ms, 83MB)
 * 테스트 9 〉	실패 (1.10ms, 77.2MB)
 * 채점 결과
 * 정확성: 44.4
 * 합계: 44.4 / 100.0
 */
public class ExpressN {

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
        System.out.println(solution(5, 31168));
    }

    public static int solution(int N, int number) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(N, 1);

        while (true) {
            for (int i : map.keySet().stream().collect(Collectors.toList())) {
                if (map.get(i) > 8)
                    return -1;
                if (calc(N, i, map, number)) {
                    return map.get(i) + 1;
                }
            }
        }

    }

    public static boolean calc(int N, int i, Map<Integer, Integer> map, int number) {
        Set<Integer> temps = operation(N, i);
        for (Integer temp : temps) {
            if (temp == number) {
                return true;
            } else if (map.get(temp) == null || map.get(temp) > map.get(i)) {
                map.put(temp, map.get(i) + 1);
            }
        }

        return false;
    }

    public static Set<Integer> operation(int i, int j) {
        Set<Integer> set = new HashSet<>();
        set.add(i + j);
        set.add(i - j);
        set.add(j - i);
        set.add(i * j);
        set.add(i * 11);
        try {
            set.add(i / j);
            set.add(j / i);
        } catch (ArithmeticException e) {

        }

        return set;
    }

}
