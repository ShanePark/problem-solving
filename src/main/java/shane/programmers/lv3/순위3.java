package shane.programmers.lv3;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.28ms, 74.7MB)
 * 테스트 2 〉	실패 (0.28ms, 75.3MB)
 * 테스트 3 〉	통과 (0.33ms, 72.2MB)
 * 테스트 4 〉	통과 (0.37ms, 77.6MB)
 * 테스트 5 〉	통과 (1.40ms, 71.3MB)
 * 테스트 6 〉	통과 (2.33ms, 72.1MB)
 * 테스트 7 〉	실패 (7.66ms, 93.6MB)
 * 테스트 8 〉	실패 (14.06ms, 97.7MB)
 * 테스트 9 〉	실패 (22.40ms, 98.3MB)
 * 테스트 10 〉	통과 (25.71ms, 81.5MB)
 * 채점 결과
 * 정확성: 60.0
 * 합계: 60.0 / 100.0
 */
public class 순위3 {

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
                player.loseSet.add(this);
            }
        }

        public void loseAgainst(Player winner) {
            loseSet.add(winner);
            for (Player player : winner.loseSet) {
                loseSet.add(player);
                player.winSet.add(this);
            }
        }
    }

}
