package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.32ms, 72.9MB)
 * 테스트 2 〉	실패 (0.35ms, 76.8MB)
 * 테스트 3 〉	실패 (0.28ms, 77MB)
 * 테스트 4 〉	통과 (0.33ms, 71.8MB)
 * 테스트 5 〉	실패 (2.16ms, 74.4MB)
 * 테스트 6 〉	통과 (1.71ms, 75.6MB)
 * 테스트 7 〉	실패 (5.82ms, 84.1MB)
 * 테스트 8 〉	실패 (14.05ms, 87.2MB)
 * 테스트 9 〉	실패 (21.63ms, 105MB)
 * 테스트 10 〉	실패 (22.21ms, 82.8MB)
 * 채점 결과
 * 정확성: 30.0
 * 합계: 30.0 / 100.0
 */
public class 순위 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(5, Ps.intArray("[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]")));
    }

    public static int solution(int n, int[][] results) {
        Map<Integer, Player> map = new HashMap();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Player(i));
        }

        for (int[] result : results) {
            processResult(map, result);
        }

        int cnt = 0;
        for (Integer i : map.keySet()) {
            if (map.get(i).versusCount() == n - 1)
                cnt++;
        }
        return cnt;
    }

    private static void processResult(Map<Integer, Player> map, int[] result) {
        Player winner = map.get(result[0]);
        Player loser = map.get(result[1]);

        winner.getWinAgainst().add(loser);
        winner.getWinAgainst().addAll(loser.getWinAgainst());
        loser.getLoseAgainst().add(winner);
        loser.getLoseAgainst().addAll(winner.getLoseAgainst());
    }

    static class Player {
        private int number;
        private Set<Player> winAgainst = new HashSet<>();
        private Set<Player> loseAgainst = new HashSet<>();

        public Player(int number) {
            this.number = number;
        }

        public int versusCount() {
            return winAgainst.size() + loseAgainst.size();
        }

        public Set<Player> getWinAgainst() {
            return winAgainst;
        }

        public Set<Player> getLoseAgainst() {
            return loseAgainst;
        }
    }

}
