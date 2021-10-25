package shane.programmers.weekly;

import com.tistory.shanepark.STool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week12Fatigue {

    public static void main(String[] args) {
//        System.out.println(solution(80, STool.convertToIntArray("[[80,20],[50,40],[30,10]]")));
        System.out.println(solution(80, STool.convertToIntArray("[[90,20],[50,40],[30,10]]")));
    }

    public static int solution(int k, int[][] dungeons) {

        int[] cleared = new int[dungeons.length];
        List<Dungeon> list = new ArrayList<>();
        for (int[] data : dungeons) {
            list.add(new Dungeon(data[0], data[1]));
        }

        return dfs(k, list, cleared, 0);

    }

    private static int dfs(int k, List<Dungeon> dungeons, int[] cleared, int depth) {
        if (depth == cleared.length) {
            return Arrays.stream(cleared).sum();
        }

        int max = 0;
        for (int i = 0; i < cleared.length; i++) {
            int clearCount = 0;
            if (cleared[i] == 0) {
                Dungeon dungeon = dungeons.get(i);
                int minFatigue = dungeon.minFatigue;
                int fatigue = dungeon.consumeFatigue;
                if (minFatigue > k) {
                    clearCount = Arrays.stream(cleared).sum();
                } else {
                    int[] temp = Arrays.copyOf(cleared, cleared.length);
                    temp[i] = 1;
                    clearCount = dfs(k - fatigue, dungeons, temp, depth + 1);
                }
            }
            max = Math.max(max, clearCount);
        }

        return max;

    }

    private static class Dungeon {
        int minFatigue;
        int consumeFatigue;

        Dungeon(int min, int con) {
            this.minFatigue = min;
            this.consumeFatigue = con;
        }

        @Override
        public String toString() {
            return "Dungeon{" +
                    "minFatigue=" + minFatigue +
                    ", consumeFatigue=" + consumeFatigue +
                    '}';
        }

    }
}
