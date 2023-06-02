package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Union find : fail.
 * 137 / 160 testcases passed
 */
public class Q2101DetonateTheMaximumBombs {

    @Test
    void test() {
        assertThat(maximumDetonation(Ps.intArray("[[54,95,4],[99,46,3],[29,21,3],[96,72,8],[49,43,3],[11,20,3],[2,57,1],[69,51,7],[97,1,10],[85,45,2],[38,47,1],[83,75,3],[65,59,3],[33,4,1],[32,10,2],[20,97,8],[35,37,3]]"))).isEqualTo(1);
        assertThat(maximumDetonation(Ps.intArray("[[1,1,100000],[100000,100000,1]]"))).isEqualTo(1);
        assertThat(maximumDetonation(Ps.intArray("[[2,1,3],[6,1,4]]"))).isEqualTo(2);
        assertThat(maximumDetonation(Ps.intArray("[[1,1,5],[10,10,5]]"))).isEqualTo(1);
        assertThat(maximumDetonation(Ps.intArray("[[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]"))).isEqualTo(5);
    }

    @Test
    void fail() {
        assertThat(maximumDetonation(Ps.intArray("[[855,82,158],[17,719,430],[90,756,164],[376,17,340],[691,636,152],[565,776,5],[464,154,271],[53,361,162],[278,609,82],[202,927,219],[542,865,377],[330,402,270],[720,199,10],[986,697,443],[471,296,69],[393,81,404],[127,405,177]]")))
                .isEqualTo(9);
    }

    public int maximumDetonation(int[][] bombs) {
        List<Bomb> list = Arrays.stream(bombs).map(
                        arr -> new Bomb(arr[0], arr[1], arr[2]))
                .collect(Collectors.toList());
        int length = bombs.length;

        UnionFind uf = new UnionFind(length);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                Bomb bomb1 = list.get(i);
                Bomb bomb2 = list.get(j);
                if (bomb1.isConnected(bomb2)) {
                    uf.union(i, j);
                }
            }
        }

        return uf.findMaxSize();
    }

    class UnionFind {
        final int[] arr;

        public UnionFind(int length) {
            arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = i;
            }
        }

        public void union(int i, int j) {
            int ufi = unionFind(i);
            int ufj = unionFind(j);
            arr[ufj] = ufi;
        }

        private int unionFind(int i) {
            if (arr[i] == i)
                return i;
            int root = unionFind(arr[i]);
            arr[i] = root;
            return root;
        }

        public int findMaxSize() {
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int uf = unionFind(i);
                cntMap.merge(uf, 1, Integer::sum);
            }
            return cntMap.values().stream().max(Comparator.naturalOrder()).orElse(0);
        }
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

        public boolean isConnected(Bomb bomb2) {
            long distanceXDistance = (long) (x - bomb2.x) * (x - bomb2.x) + (y - bomb2.y) * (y - bomb2.y);
            int longer = Math.max(radius, bomb2.radius);
            return (long) longer * longer >= distanceXDistance;
        }
    }

}
