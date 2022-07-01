package shane.programmers.challenge2021.weekly;

import com.tistory.shanepark.STool;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.70ms, 76.9MB)
 * 테스트 2 〉	통과 (13.70ms, 90.4MB)
 * 테스트 3 〉	통과 (0.59ms, 77.2MB)
 * 테스트 4 〉	통과 (15.91ms, 87.8MB)
 * 테스트 5 〉	통과 (8.81ms, 91.2MB)
 * 테스트 6 〉	통과 (3.07ms, 69MB)
 * 테스트 7 〉	통과 (9.20ms, 81.3MB)
 * 테스트 8 〉	통과 (0.63ms, 81MB)
 * 테스트 9 〉	통과 (28.51ms, 89.4MB)
 * 테스트 10 〉	통과 (22.96ms, 78.1MB)
 * 테스트 11 〉	통과 (24.32ms, 77.9MB)
 * 테스트 12 〉	통과 (34.87ms, 72.8MB)
 * 테스트 13 〉	통과 (32.24ms, 88.3MB)
 * 테스트 14 〉	통과 (37.80ms, 82.6MB)
 * 테스트 15 〉	통과 (37.49ms, 84.8MB)
 * 테스트 16 〉	통과 (46.40ms, 72MB)
 * 테스트 17 〉	통과 (39.48ms, 88.3MB)
 * 테스트 18 〉	통과 (36.96ms, 86.3MB)
 * 테스트 19 〉	통과 (34.14ms, 91.5MB)
 * 테스트 20 〉	통과 (28.86ms, 81.2MB)
 * 테스트 21 〉	통과 (34.81ms, 87.7MB)
 * 테스트 22 〉	통과 (0.45ms, 73.4MB)
 * 테스트 23 〉	통과 (0.35ms, 78.4MB)
 * 테스트 24 〉	통과 (0.46ms, 79MB)
 * 테스트 25 〉	통과 (0.50ms, 73.3MB)
 * 테스트 26 〉	통과 (0.32ms, 76.6MB)
 * 테스트 27 〉	통과 (0.44ms, 69.4MB)
 * 테스트 28 〉	실패 (0.38ms, 78MB)
 * 테스트 29 〉	통과 (0.33ms, 77.7MB)
 * 채점 결과
 * 정확성: 96.6
 * 합계: 96.6 / 100.0
 */
public class Week10Star2 {

    public static void main(String[] args) {
        STool.printDeepArray(solution(STool.convertToIntArray("[[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]")));
        STool.printDeepArray(solution(STool.convertToIntArray("[[0, 1, -1], [1, 0, -1], [1, 0, 1]]")));
        STool.printDeepArray(solution(STool.convertToIntArray("[[1, -1, 0], [2, -1, 0]]")));
        STool.printDeepArray(solution(STool.convertToIntArray("[[1, -1, 0], [2, -1, 0], [4, -1, 0]]")));
    }

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
                double a = line[i][0];
                double b = line[i][1];
                double e = line[i][2];
                double c = line[j][0];
                double d = line[j][1];
                double f = line[j][2];
                if ((a * d - b * c) == 0) {
                    continue;
                }
                double x = (b * f - e * d) / (a * d - b * c);
                double y = (e * c - a * f) / (a * d - b * c);
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
