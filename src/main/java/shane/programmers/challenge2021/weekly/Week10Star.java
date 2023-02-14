package shane.programmers.challenge2021.weekly;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.58ms, 72.6MB)
 * 테스트 2 〉	통과 (9.32ms, 84.6MB)
 * 테스트 3 〉	통과 (0.34ms, 84.2MB)
 * 테스트 4 〉	통과 (14.58ms, 98.3MB)
 * 테스트 5 〉	통과 (7.96ms, 88.4MB)
 * 테스트 6 〉	통과 (3.34ms, 80.3MB)
 * 테스트 7 〉	통과 (12.91ms, 88.4MB)
 * 테스트 8 〉	통과 (0.60ms, 79.1MB)
 * 테스트 9 〉	통과 (20.53ms, 90.4MB)
 * 테스트 10 〉	통과 (17.96ms, 78.2MB)
 * 테스트 11 〉	통과 (19.34ms, 80.7MB)
 * 테스트 12 〉	통과 (22.01ms, 89.7MB)
 * 테스트 13 〉	통과 (36.00ms, 87MB)
 * 테스트 14 〉	통과 (35.32ms, 88.8MB)
 * 테스트 15 〉	통과 (20.40ms, 85.2MB)
 * 테스트 16 〉	통과 (20.39ms, 77.9MB)
 * 테스트 17 〉	통과 (45.79ms, 92.1MB)
 * 테스트 18 〉	통과 (23.82ms, 83.2MB)
 * 테스트 19 〉	통과 (19.57ms, 75MB)
 * 테스트 20 〉	통과 (21.56ms, 71.2MB)
 * 테스트 21 〉	통과 (31.22ms, 97.1MB)
 * 테스트 22 〉	통과 (0.45ms, 78.2MB)
 * 테스트 23 〉	통과 (0.36ms, 76.8MB)
 * 테스트 24 〉	통과 (0.33ms, 76.5MB)
 * 테스트 25 〉	통과 (0.32ms, 65.6MB)
 * 테스트 26 〉	통과 (0.34ms, 74MB)
 * 테스트 27 〉	통과 (0.32ms, 66.8MB)
 * 테스트 28 〉	통과 (0.31ms, 77.4MB)
 * 테스트 29 〉	실패 (0.13ms, 77MB)
 * 채점 결과
 * 정확성: 96.6
 * 합계: 96.6 / 100.0
 */
public class Week10Star {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
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
                int a = line[i][0];
                int b = line[i][1];
                int e = line[i][2];
                int c = line[j][0];
                int d = line[j][1];
                int f = line[j][2];
                if ((a * d - b * c) == 0) {
                    continue;
                }
                double x = (double) (b * f - e * d) / (a * d - b * c);
                double y = (double) (e * c - a * f) / (a * d - b * c);
                if (((x % 1) == 0) && ((y % 1) == 0)) {
                    set.add(new Point((int) x, (int) y));
                }

            }
        }

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = -Integer.MAX_VALUE;
        int maxY = -Integer.MAX_VALUE;

        for (Point point : set) {
            minX = Math.min(minX, point.x);
            maxX = Math.max(maxX, point.x);
            minY = Math.min(minY, point.y);
            maxY = Math.max(maxY, point.y);
        }

        String[] result = new String[maxY - minY + 1];
        for (int j = 0; j < result.length; j++) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < maxX - minX + 1; i++) {
                sb.append(".");
            }
            result[j] = sb.toString();
        }

        for (Point point : set) {
            int x = point.x - minX;
            int y = point.y - minY;
            StringBuffer sb = new StringBuffer(result[maxY - minY - y]);
            sb.replace(x, x + 1, "*");
            result[maxY - minY - y] = sb.toString();
        }

        return result;
    }


}
