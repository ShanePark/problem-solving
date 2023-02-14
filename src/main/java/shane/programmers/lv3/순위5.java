package shane.programmers.lv3;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 순위5 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(5, Ps.intArray("[[4, 3], [4, 2], [3, 2], [1, 2], [2, 5]]")));
        Assertions.assertEquals(5, solution(5, Ps.intArray("[[1, 2], [4, 5], [3, 4], [2, 3]]")));
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
        winner.addNewWinSet(loser);
        loser.addNewLostSet(winner);
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

        public void addNewWinSet(Player loser) {
            this.winSet.add(loser);
            for (Player player : loser.winSet) {
                this.winSet.add(player);
                player.loseSet.add(this);
                for (Player stronger : this.loseSet) {
                    stronger.winSet.add(player);
                    player.loseSet.add(stronger);
                }
            }
            for (Player player : this.loseSet) {
                player.winSet.add(loser);
                loser.loseSet.add(player);
            }
        }

        public void addNewLostSet(Player winner) {
            this.loseSet.add(winner);
            for (Player player : winner.loseSet) {
                this.loseSet.add(player);
                player.winSet.add(this);
                for (Player weaker : this.winSet) {
                    weaker.loseSet.add(player);
                    player.winSet.add(weaker);
                }
            }
            for (Player player : this.winSet) {
                player.loseSet.add(winner);
                winner.winSet.add(player);
            }
        }
    }

}

