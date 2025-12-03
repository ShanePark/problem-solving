package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Noy my solution
 */
public class Q3625CountNumberOfTrapezoidsII {

    @Test
    public void test() {
        assertThat(countTrapezoids(Ps.intArray("[[-3,2],[3,0],[2,3],[3,2],[2,-3]]"))).isEqualTo(2);
        assertThat(countTrapezoids(Ps.intArray("[[0,0],[1,0],[0,1],[2,1]]"))).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(countTrapezoids(Ps.intArray("[[83,-25],[74,11],[-65,-25],[33,-25],[17,-25],[1,30],[-84,-25],[1,-25],[1,-92],[-87,13]]"))).isEqualTo(0);
    }

    public int countTrapezoids(int[][] points) {
        int n = points.length;

        Map<Long, List<int[]>> slopeGroups = new HashMap<>();
        Map<Long, int[]> slopeToValues = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] slope = normalizedSlope(points[i], points[j]);
                long key = encodeSlope(slope);
                slopeGroups.computeIfAbsent(key, k -> new ArrayList<>()).add(new int[]{i, j});
                slopeToValues.putIfAbsent(key, slope);
            }
        }

        long trapezoidCount = 0;

        for (Map.Entry<Long, List<int[]>> entry : slopeGroups.entrySet()) {
            List<int[]> segments = entry.getValue();
            int k = segments.size();
            if (k < 2) continue;

            int[] slope = slopeToValues.get(entry.getKey());
            int dy = slope[0], dx = slope[1];

            Map<Long, List<int[]>> lineGroups = new HashMap<>();
            for (int[] seg : segments) {
                long lineId = (long) dy * points[seg[0]][0] - (long) dx * points[seg[0]][1];
                lineGroups.computeIfAbsent(lineId, l -> new ArrayList<>()).add(seg);
            }

            long A = 0;
            for (List<int[]> lineSegs : lineGroups.values()) {
                long m = lineSegs.size();
                A += m * (m - 1) / 2;
            }

            Map<Integer, Integer> pointCnt = new HashMap<>();
            for (int[] seg : segments) {
                pointCnt.merge(seg[0], 1, Integer::sum);
                pointCnt.merge(seg[1], 1, Integer::sum);
            }
            long B = 0;
            for (int c : pointCnt.values()) {
                B += (long) c * (c - 1) / 2;
            }

            long C = 0;
            for (List<int[]> lineSegs : lineGroups.values()) {
                Map<Integer, Integer> plCnt = new HashMap<>();
                for (int[] seg : lineSegs) {
                    plCnt.merge(seg[0], 1, Integer::sum);
                    plCnt.merge(seg[1], 1, Integer::sum);
                }
                for (int c : plCnt.values()) {
                    C += (long) c * (c - 1) / 2;
                }
            }

            long totalPairs = (long) k * (k - 1) / 2;
            trapezoidCount += totalPairs - A - B + C;
        }

        trapezoidCount -= countParallelograms(points);

        return (int) trapezoidCount;
    }

    private int[] normalizedSlope(int[] p1, int[] p2) {
        int dy = p2[1] - p1[1];
        int dx = p2[0] - p1[0];
        if (dx == 0) return new int[]{1, 0};
        if (dy == 0) return new int[]{0, 1};
        int g = gcd(Math.abs(dy), Math.abs(dx));
        dy /= g;
        dx /= g;
        if (dx < 0) {
            dy = -dy;
            dx = -dx;
        }
        return new int[]{dy, dx};
    }

    private long encodeSlope(int[] slope) {
        return (long) (slope[0] + 2001) * 2002 + slope[1];
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long countParallelograms(int[][] points) {
        int n = points.length;
        Map<Long, List<int[]>> midpointGroups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int mx = points[i][0] + points[j][0];
                int my = points[i][1] + points[j][1];
                long midKey = (long) (mx + 2001) * 4003 + (my + 2001);
                midpointGroups.computeIfAbsent(midKey, k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        long count = 0;
        for (List<int[]> pairs : midpointGroups.values()) {
            int k = pairs.size();
            if (k < 2) continue;

            for (int a = 0; a < k; a++) {
                for (int b = a + 1; b < k; b++) {
                    int[] p1 = pairs.get(a);
                    int[] p2 = pairs.get(b);
                    if (p1[0] == p2[0] || p1[0] == p2[1] || p1[1] == p2[0] || p1[1] == p2[1]) {
                        continue;
                    }
                    int[] A = points[p1[0]];
                    int[] B = points[p1[1]];
                    int[] C = points[p2[0]];
                    if (collinear(A, B, C)) {
                        continue;
                    }
                    count++;
                }
            }
        }

        return count;
    }

    private boolean collinear(int[] A, int[] B, int[] C) {
        long cross = (long) (B[0] - A[0]) * (C[1] - A[1]) - (long) (B[1] - A[1]) * (C[0] - A[0]);
        return cross == 0;
    }

}
