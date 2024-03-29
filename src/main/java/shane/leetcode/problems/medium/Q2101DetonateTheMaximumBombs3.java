package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Resolved overflow but very slow
 * <p>
 * Runtime 1545 ms Beats 5.3
 * Memory 44.5 MB Beats 6.89%
 */
@SuppressWarnings("DuplicatedCode")
public class Q2101DetonateTheMaximumBombs3 {

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
     * 70 ms
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
        int length = bombs.length;
        List<Bomb> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int[] arr = bombs[i];
            list.add(new Bomb(i, arr[0], arr[1], arr[2]));
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j)
                    continue;
                Bomb bomb1 = list.get(i);
                Bomb bomb2 = list.get(j);
                if (bomb1.canDetonate(bomb2)) {
                    bomb1.next.add(bomb2);
                }
            }
        }
        int max = 0;

        for (Bomb bomb : list) {
            int size = bomb.detonate().size();
            max = Math.max(max, size);
        }

        return max;
    }

    class Bomb {
        int index;
        int x;
        int y;
        int radius;
        Set<Bomb> next = new HashSet<>();

        public Bomb(int index, int x, int y, int radius) {
            this.index = index;
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        public boolean canDetonate(Bomb bomb2) {
            long distanceXDistance = (long) (x - bomb2.x) * (x - bomb2.x) + (long) (y - bomb2.y) * (y - bomb2.y);
            return (long) radius * radius >= distanceXDistance;
        }

        public Set<Bomb> detonate() {
            HashSet<Bomb> visited = new HashSet<>();
            visited.add(this);
            return detonate(visited);
        }

        public Set<Bomb> detonate(Set<Bomb> visited) {
            for (Bomb bomb : next) {
                if (visited.add(bomb)) {
                    visited.addAll(bomb.detonate(visited));
                }
            }
            visited.addAll(next);
            visited.add(this);
            return visited;
        }

        @Override
        public String toString() {
            return "Bomb{" +
                    "index=" + index +
                    ", next=" + next.stream().map(b -> b.index).collect(Collectors.toList()) +
                    '}';
        }
    }

}
