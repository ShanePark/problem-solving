package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * TLE
 */
public class Q799ChampagneTower {

    @Test
    void test() {
        Assertions.assertThat(champagneTower(1, 1, 1)).isEqualTo(0.00000);
        Assertions.assertThat(champagneTower(2, 1, 1)).isEqualTo(0.50000);
        Assertions.assertThat(champagneTower(1000000, 1, 1)).isEqualTo(1);
//        Assertions.assertThat(champagneTower(100000009, 33, 17)).isEqualTo(1.00000);
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        Map<Point, Champagne> map = new HashMap<>();
        Champagne root = new Champagne(new Point(0, 0), map);
        root.pour(poured, map);

        Champagne champagne = map.get(new Point(query_row, query_glass));
        return champagne == null ? 0 : champagne.amount;
    }

    class Champagne {
        Point point;
        double amount;
        Champagne left;
        Champagne right;

        public Champagne(Point point, Map<Point, Champagne> map) {
            this.point = point;
            this.amount = 0;
            map.put(point, this);
        }

        public void pour(double poured, Map<Point, Champagne> map) {
            System.out.println("poured = " + poured);
            System.out.println("point = " + point);
            System.out.println("this.amount = " + this.amount);
            if (this.amount + poured <= 1) {
                this.amount += poured;
            } else {
                poured -= (1 - this.amount);
                this.amount = 1;

                Point leftPoint = new Point(point.queryRow + 1, point.queryGlass);
                Point rightPoint = new Point(point.queryRow + 1, point.queryGlass + 1);
                Champagne left = map.getOrDefault(leftPoint, new Champagne(leftPoint, map));
                Champagne right = map.getOrDefault(rightPoint, new Champagne(rightPoint, map));
                this.left = left;
                this.right = right;
                left.pour(poured / 2, map);
                right.pour(poured / 2, map);
            }
        }
    }

    class Point {
        int queryRow;
        int queryGlass;

        public Point(int queryRow, int queryGlass) {
            this.queryRow = queryRow;
            this.queryGlass = queryGlass;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return queryRow == point.queryRow && queryGlass == point.queryGlass;
        }

        @Override
        public int hashCode() {
            return Objects.hash(queryRow, queryGlass);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "queryRow=" + queryRow +
                    ", queryGlass=" + queryGlass +
                    '}';
        }
    }
}
