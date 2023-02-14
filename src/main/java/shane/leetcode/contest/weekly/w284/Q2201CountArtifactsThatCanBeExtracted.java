package shane.leetcode.contest.weekly.w284;

import com.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Q2201CountArtifactsThatCanBeExtracted {

    @Test
    void test() {
//        Assertions.assertThat(digArtifacts(2, Ps.intArray("[[0,0,0,0],[0,1,1,1]]"), Ps.intArray("[[0,0],[0,1]]"))).isEqualTo(1);
//        Assertions.assertThat(digArtifacts(2, Ps.intArray("[[0,0,0,0],[0,1,1,1]]"), Ps.intArray("[[0,0],[0,1],[1,1]]"))).isEqualTo(2);
        Assertions.assertThat(digArtifacts(5, Ps.intArray("[[3,1,4,1],[1,1,2,2],[1,0,2,0],[4,3,4,4],[0,3,1,4],[2,3,3,4]]"), Ps.intArray("[[0,0],[2,1],[2,0],[2,3],[4,3],[2,4],[4,1],[0,2],[4,0],[3,1],[1,2],[1,3],[3,2]]"))).isEqualTo(1);
    }

    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        Map<Point, Artifact> map = new HashMap<>();
        for (int[] arr : artifacts) {
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];
            Artifact artifact = new Artifact((y2 - y1 + 1) * (x2 - x1 + 1));
            int bigX = Math.max(x1, x2);
            int bigY = Math.max(y1, y2);
            int smallX = Math.min(x1, x2);
            int smallY = Math.min(y1, y2);
            for (int x = smallX; x <= bigX; x++) {
                for (int y = smallY; y <= bigY; y++) {
                    map.put(new Point(x, y), artifact);
                }
            }
        }

        int answer = 0;
        for (int[] ints : dig) {
            Point point = new Point(ints[0], ints[1]);
            Artifact artifact = map.get(point);
            if(artifact == null)
                continue;

            artifact.size--;
            if (artifact.size == 0) {
                answer++;
            }
        }
        return answer;
    }

    class Artifact {
        int size;

        public Artifact(int size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Artifact{" +
                    "size=" + size +
                    '}';
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
