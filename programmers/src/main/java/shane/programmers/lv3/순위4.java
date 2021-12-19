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
 * 테스트 1 〉	통과 (0.36ms, 75.1MB)
 * 테스트 2 〉	통과 (0.37ms, 74.1MB)
 * 테스트 3 〉	통과 (0.74ms, 77.3MB)
 * 테스트 4 〉	통과 (0.30ms, 77.2MB)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	실패 (시간 초과)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	실패 (시간 초과)
 * 테스트 10 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 40.0
 * 합계: 40.0 / 100.0
 */
public class 순위4 {

    public static void main(String[] args) {
//        Assertions.assertEquals(2, solution(5, STool.convertToIntArray("[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]")));
        Assertions.assertEquals(5, solution(5, STool.convertToIntArray("[[1, 2], [4, 5], [3, 4], [2, 3]]")));
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
            loser.loseAgainst(this);
            winSet.add(loser);
            for (Player player : loser.winSet) {
                winSet.add(player);
                player.loseAgainst(this);
            }
        }

        public void loseAgainst(Player winner) {
            loseSet.add(winner);
            for (Player player : winner.loseSet) {
                loseSet.add(player);
                player.winAgainst(this);
            }
        }

    }

}
