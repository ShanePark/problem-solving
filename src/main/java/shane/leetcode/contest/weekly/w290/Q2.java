package shane.leetcode.contest.weekly.w290;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(countLatticePoints(Ps.intArray("[[2,2,1]]"))).isEqualTo(5);
        assertThat(countLatticePoints(Ps.intArray("[[2,2,2],[3,4,1]]"))).isEqualTo(16);
        assertThat(countLatticePoints(Ps.intArray("[[8,9,6],[9,8,4],[4,1,1],[8,5,1],[7,1,1],[6,7,5],[7,1,1],[7,1,1],[5,5,3]]"))).isEqualTo(141);
    }

    public int countLatticePoints(int[][] circles) {
        Set<LatticePoint> set = new HashSet<>();
        for (int[] circle : circles) {
            int y = circle[1];
            int x = circle[0];
            int r = circle[2];
            for (int i = y - r; i <= y + r; i++) {
                for (int j = x - r; j <= x + r; j++) {
                    if ((i - y) * (i - y) + (j - x) * (j - x) <= r * r) {
                        set.add(new LatticePoint(i, j));
                    }
                }
            }
        }
        return set.size();
    }

    class LatticePoint {
        int y;
        int x;

        public LatticePoint(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LatticePoint that = (LatticePoint) o;
            return y == that.y && x == that.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }

}
