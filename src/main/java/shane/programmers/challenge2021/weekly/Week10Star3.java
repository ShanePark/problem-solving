package shane.programmers.challenge2021.weekly;

import io.github.shanepark.Ps;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Week10Star3 {

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
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

    public static String[] solution(int[][] line) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                if ((a * d - b * c) == 0 || (b * f - e * d)%(a * d - b * c) !=0 || (e * c - a * f)%(a * d - b * c)!=0 ) {
                    continue;
                }
                long x = (b * f - e * d) / (a * d - b * c);
                long y = (e * c - a * f) / (a * d - b * c);
                set.add(new Point((int) x, (int) y));
            }
        }

        long minX = Integer.MAX_VALUE;
        long minY = Integer.MAX_VALUE;
        long maxX = -Integer.MAX_VALUE;
        long maxY = -Integer.MAX_VALUE;

        for (Point point : set) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        String[] result = new String[(int)(maxY - minY) + 1];
        for (int j = 0; j < result.length; j++) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < maxX - minX + 1; i++) {
                sb.append(".");
            }
            result[j] = sb.toString();
        }

        for (Point point : set) {
            int x = (int)(point.x - minX);
            int y = (int)(point.y - minY);
            StringBuffer sb = new StringBuffer(result[(int)(maxY - minY - y)]);
            sb.replace(x, x + 1, "*");
            result[(int)(maxY - minY - y)] = sb.toString();
        }

        return result;
    }


}
