package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Avoid Circular Dependency
 * Runtime 135 ms Beats 45.3%
 * Memory 43.8 MB Beats 17.35%
 */
@SuppressWarnings("DuplicatedCode")
public class Q2101DetonateTheMaximumBombs4 {

    @Test
    void test() {
        assertThat(maximumDetonation(Ps.intArray("[[38496,37528,4845],[46272,98187,1365],[70550,7578,3223],[77200,18005,7272],[7648,58155,7628],[95708,33470,1889],[20157,92266,9823],[52803,2765,6751],[50429,63049,3002],[72582,69729,2281],[49317,35327,1922],[715,8902,9620],[21154,58349,8544],[43935,46296,6868],[7881,24144,2372],[95258,97730,6554],[5525,56971,9191],[95762,81415,2027],[62518,75469,1330],[83660,4341,6817],[30268,38781,8309],[97922,20474,4047],[39466,40057,2061],[91983,24242,5451],[92380,31509,8446],[12436,8897,5279],[28386,8556,4702],[54672,88180,1106],[17843,95337,4420],[21956,49924,1839]]")))
                .isEqualTo(3);
        assertThat(maximumDetonation(Ps.intArray("[[855,82,158],[17,719,430],[90,756,164],[376,17,340],[691,636,152],[565,776,5],[464,154,271],[53,361,162],[278,609,82],[202,927,219],[542,865,377],[330,402,270],[720,199,10],[986,697,443],[471,296,69],[393,81,404],[127,405,177]]")))
                .isEqualTo(9);
        assertThat(maximumDetonation(Ps.intArray("[[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]"))).isEqualTo(5);
        assertThat(maximumDetonation(Ps.intArray("[[2,1,3],[6,1,4]]"))).isEqualTo(2);
        assertThat(maximumDetonation(Ps.intArray("[[54,95,4],[99,46,3],[29,21,3],[96,72,8],[49,43,3],[11,20,3],[2,57,1],[69,51,7],[97,1,10],[85,45,2],[38,47,1],[83,75,3],[65,59,3],[33,4,1],[32,10,2],[20,97,8],[35,37,3]]"))).isEqualTo(1);
        assertThat(maximumDetonation(Ps.intArray("[[1,1,100000],[100000,100000,1]]"))).isEqualTo(1);
        assertThat(maximumDetonation(Ps.intArray("[[1,1,5],[10,10,5]]"))).isEqualTo(1);
    }

    /**
     * 34 ms
     */
    @Test
    void slow() {
        int[][] arr = new int[100][3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[]{0, 0, 3};
        }
        assertThat(maximumDetonation(arr)).isEqualTo(100);
    }

    public int maximumDetonation(int[][] bombs) {
        List<Bomb> list = Arrays.stream(bombs)
                .map(arr -> new Bomb(arr[0], arr[1], arr[2]))
                .collect(Collectors.toList());

        int max = 0;
        for (int i = 0; i < bombs.length; i++) {
            max = Math.max(max, dfs(i, list, new boolean[bombs.length]));
        }
        return max;
    }

    private int dfs(int index, List<Bomb> bombs, boolean[] visited) {
        int cnt = 1;
        visited[index] = true;
        Bomb bomb = bombs.get(index);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i])
                continue;
            if (bomb.canDetonate(bombs.get(i))) {
                cnt += dfs(i, bombs, visited);
            }
        }

        return cnt;
    }

    class Bomb {
        int x;
        int y;
        int radius;

        public Bomb(int x, int y, int radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public boolean canDetonate(Bomb bomb2) {
            long distanceXDistance = (long) (x - bomb2.x) * (x - bomb2.x) + (long) (y - bomb2.y) * (y - bomb2.y);
            return (long) radius * radius >= distanceXDistance;
        }
    }

}
