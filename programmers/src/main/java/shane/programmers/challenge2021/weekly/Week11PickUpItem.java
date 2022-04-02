package shane.programmers.weekly;

import com.tistory.shanepark.STool;

import java.util.*;

public class Week11PickUpItem {
    public static void main(String[] args) {
        int result;

        result = solution(STool.convertToIntArray("[[1,1,7,4],[3,2,5,5],[4,3,6,9],[2,6,8,8]]"), 1, 3, 7, 8);
        System.out.println(result == 17 ? true : result);

        result = solution(STool.convertToIntArray("[[1,1,8,4],[2,2,4,9],[3,6,9,8],[6,3,7,7]]"), 9, 7, 6, 1);
        System.out.println(result == 11 ? true : result);

        result = solution(STool.convertToIntArray("[[1,1,5,7]]"), 1, 1, 4, 7);
        System.out.println(result == 9 ? true : result);

        result = solution(STool.convertToIntArray("[[2,1,7,5],[6,4,10,10]]"), 3, 1, 7, 10);
        System.out.println(result == 15 ? true : result);

        result = solution(STool.convertToIntArray("[[2,2,5,5],[1,3,6,4],[3,1,4,6]]"), 1, 4, 6, 3);
        System.out.println(result == 10 ? true : result);
    }

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        Set<Point> set = new HashSet<>();
        for (int[] ints : rectangle) {
            int xMin = Math.min(ints[0], ints[2]);
            int xMax = Math.max(ints[0], ints[2]);
            int yMin = Math.min(ints[1], ints[3]);
            int yMax = Math.max(ints[1], ints[3]);
            for (int i = xMin; i < xMax; i++) {
                for (int j = yMin; j < yMax; j++) {
                    set.add(new Point(i, j));
                }
            }
        }

        List<Point> possibleMoves = new ArrayList<>();

        if (canGoUp(characterX, characterY, set)) {
            possibleMoves.add(new Point(characterX, characterY + 1));
        }
        if (canGoDown(characterX, characterY, set)) {
            possibleMoves.add(new Point(characterX, characterY - 1));
        }
        if (canGoLeft(characterX, characterY, set)) {
            possibleMoves.add(new Point(characterX - 1, characterY));
        }
        if (canGoRight(characterX, characterY, set)) {
            possibleMoves.add(new Point(characterX + 1, characterY));
        }

        int distance1 = getDistance(possibleMoves.get(0), new Point(characterX, characterY), new Point(itemX, itemY), set, 1);
        int distance2 = getDistance(possibleMoves.get(1), new Point(characterX, characterY), new Point(itemX, itemY), set, 1);

        return Math.min(distance1, distance2);
    }

    private static int getDistance(Point point, Point before, Point item, Set<Point> set, int currentDistance) {
        if (point.equals(item))
            return currentDistance;
        Point left = moveLeft(point);
        Point right = moveRight(point);
        Point up = moveUp(point);
        Point down = moveDown(point);
        if (canGoLeft(point.x, point.y, set) && !before.equals(left)) {
            return getDistance(left, point, item, set, currentDistance+1);
        } else if (canGoRight(point.x, point.y, set) && !before.equals(right)) {
            return getDistance(right, point, item, set, currentDistance+1);
        } else if (canGoUp(point.x, point.y, set) && !before.equals(up)) {
            return getDistance(up, point, item, set, currentDistance+1);
        } else if (canGoDown(point.x, point.y, set) && !before.equals(down)) {
            return getDistance(down, point, item, set, currentDistance+1);
        } else {
            throw new IllegalStateException();
        }
    }

    private static Point moveLeft(Point point) {
        return new Point(point.x - 1, point.y);
    }

    private static Point moveRight(Point point) {
        return new Point(point.x + 1, point.y);
    }

    private static Point moveUp(Point point) {
        return new Point(point.x, point.y + 1);
    }

    private static Point moveDown(Point point) {
        return new Point(point.x, point.y - 1);
    }

    public static boolean canGoLeft(int x, int y, Set<Point> set) {
        boolean upperLeftPossible = set.contains(new Point(x - 1, y - 1)) && !set.contains(new Point(x - 1, y));
        boolean bottomLeftPossible = set.contains(new Point(x - 1, y)) && !set.contains(new Point(x - 1, y - 1));
        return upperLeftPossible || bottomLeftPossible;
    }

    public static boolean canGoRight(int x, int y, Set<Point> set) {
        boolean upperRightPossible = set.contains(new Point(x, y - 1)) && !set.contains(new Point(x, y));
        boolean bottomRightPossible = set.contains(new Point(x, y)) && !set.contains(new Point(x, y - 1));
        return upperRightPossible || bottomRightPossible;
    }

    public static boolean canGoUp(int x, int y, Set<Point> set) {
        boolean upperRightPossible = set.contains(new Point(x - 1, y)) && !set.contains(new Point(x, y));
        boolean upperLeftPossible = set.contains(new Point(x, y)) && !set.contains(new Point(x - 1, y));
        return upperRightPossible || upperLeftPossible;
    }

    public static boolean canGoDown(int x, int y, Set<Point> set) {
        boolean downRightPossible = set.contains(new Point(x - 1, y - 1)) && !set.contains(new Point(x, y - 1));
        boolean downLeftPossible = set.contains(new Point(x, y - 1)) && !set.contains(new Point(x - 1, y - 1));
        return downRightPossible || downLeftPossible;
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
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

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
