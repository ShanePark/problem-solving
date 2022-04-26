package shane.programmers.lv3;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.28ms, 73.7MB)
 * 테스트 2 〉	실패 (0.44ms, 71.8MB)
 * 테스트 3 〉	실패 (0.42ms, 73.9MB)
 * 테스트 4 〉	통과 (0.49ms, 79MB)
 * 테스트 5 〉	실패 (1203.58ms, 390MB)
 * 테스트 6 〉	통과 (6434.22ms, 386MB)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	실패 (시간 초과)
 * 테스트 10 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 30.0
 * 합계: 30.0 / 100.0
 */
public class 순위2 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(5, STool.convertToIntArray("[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]")));
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

        winner.winAgainst(loser);
        loser.loseAgainst(winner);
    }

    static class Player {
        private int number;
        private Set<Player> winSet = new HashSet<>();
        private Set<Player> loseSet = new HashSet<>();

        public Player(int number) {
            this.number = number;
        }

        public int versusCount() {
            return winSet.size() + loseSet.size();
        }

        public void winAgainst(Player loser) {
            winSet.add(loser);
            for (Player player : loser.winSet) {
                winAgainst(player);
            }
        }

        public void loseAgainst(Player winner) {
            loseSet.add(winner);
            for (Player player : winner.loseSet) {
                loseAgainst(player);
            }
        }
    }

}
