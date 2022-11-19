package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 82 ms Beats 5.17%
 * Memory 67.6 MB Beats 5.17%
 */
public class Q587ErectTheFence {

    @Test
    public void test() {
        assertThat(outerTrees(STool.convertToIntArray("[[0,2],[0,1],[0,0],[1,0],[2,0],[1,1]]")).length).isEqualTo(6);

        assertThat(outerTrees(STool.convertToIntArray("[[3,0],[4,0],[5,0],[6,1],[7,2],[7,3],[7,4],[6,5],[5,5],[4,5],[3,5],[2,5],[1,4],[1,3],[1,2],[2,1],[4,2],[0,3]]")).length)
                .isEqualTo(STool.convertToIntArray("[[4,5],[2,5],[6,1],[3,5],[2,1],[1,4],[1,2],[7,4],[7,3],[7,2],[3,0],[0,3],[5,0],[5,5],[4,0],[6,5]]").length);

        assertThat(outerTrees(STool.convertToIntArray("[[1,2],[2,2],[4,2],[4,1]]")).length).isEqualTo(4);

        assertThat(outerTrees(STool.convertToIntArray("[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]")).length).isEqualTo(5);

        assertThat(outerTrees(STool.convertToIntArray("[[1,1],[1,2],[1,3]]")).length)
                .isEqualTo(STool.convertToIntArray("[[1, 1], [1, 2], [1, 2]]").length);

        assertThat(outerTrees(STool.convertToIntArray("[[0,2],[1,1],[2,2],[2,4],[4,2],[3,3]]")).length)
                .isEqualTo(STool.convertToIntArray("[[0,2],[4,2],[3,3],[1,1],[2,4]]").length);
        assertThat(outerTrees(STool.convertToIntArray("[[1,2],[2,2],[4,2]]")).length).isEqualTo(3);
    }

    public int[][] outerTrees(int[][] trees) {
        List<Tree> allTrees = new ArrayList<>();
        Set<Tree> answer = new HashSet<>();

        for (int[] t : trees) {
            allTrees.add(new Tree(t));
        }
        Tree first = new Tree(new int[]{101, -1});

        for (Tree tree : allTrees) {
            if (tree.x < first.x || (tree.x == first.x && tree.y > first.y)) {
                first = tree;
            }
        }

        Tree before = first;
        answer.add(before);

        Set<Quadrant> availableQuadrants = new HashSet<>();
        availableQuadrants.addAll(List.of(Quadrant.values()));
        do {
            Double bestAngle = null;
            Quadrant bestQuadrant = null;
            List<Tree> candidates = new ArrayList<>();
            for (Tree tree : allTrees) {
                if (tree == before)
                    continue;
                Double thisAngle = tree.calcAngle(before);
                Quadrant thisQuadrant = before.calcQuadrant(tree);
                if (!availableQuadrants.contains(thisQuadrant)) {
                    continue;
                }

                if (bestAngle == null || bestQuadrant.ordinal() > thisQuadrant.ordinal() || (bestQuadrant == thisQuadrant && bestAngle < thisAngle)) {
                    candidates.clear();
                    candidates.add(tree);
                    bestAngle = thisAngle;
                    bestQuadrant = thisQuadrant;
                } else if ((bestQuadrant == thisQuadrant) && (Double.compare(bestAngle, thisAngle) == 0)) {
                    candidates.add(tree);
                }
            }

            if (candidates.isEmpty())
                break;

            answer.addAll(candidates);
            final Tree lastPoint = before;
            candidates.sort(Comparator.comparingDouble(t -> -t.distanceSquare(lastPoint)));

            for (Quadrant value : Quadrant.values()) {
                if (bestQuadrant.ordinal() > value.ordinal()) {
                    availableQuadrants.remove(value);
                }
            }
            before = candidates.get(0);
        } while (before != first);

        int[][] result = new int[answer.size()][2];
        int i = 0;
        for (Tree tree : answer) {
            result[i++] = new int[]{tree.x, tree.y};
        }
        return result;
    }

    class Tree {
        int x;
        int y;

        public Tree(int[] data) {
            this.x = data[0];
            this.y = data[1];
        }

        @Override
        public String toString() {
            return "Tree{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public double distanceSquare(Tree tree) {
            return Math.pow((tree.x - x), 2) + Math.pow((tree.y - y), 1);
        }

        public Double calcAngle(Tree before) {
            return (double) (y - before.y) / (x - before.x);
        }

        public Quadrant calcQuadrant(Tree tree) {
            if (tree.x == x)
                return tree.y > y ? Quadrant.UP : Quadrant.DOWN;
            if (tree.y == y)
                return tree.x > x ? Quadrant.RIGHT : Quadrant.LEFT;
            if (x < tree.x && y < tree.y) {
                return Quadrant.QUADRANT1;
            }
            if (x < tree.x && y > tree.y) {
                return Quadrant.QUADRANT4;
            }
            if (x > tree.x && y > tree.y) {
                return Quadrant.QUADRANT3;
            }
            return Quadrant.QUADRANT2;
        }
    }

    enum Quadrant {
        QUADRANT1,
        RIGHT,
        QUADRANT4,
        DOWN,
        QUADRANT3,
        LEFT,
        QUADRANT2,
        UP,
    }

}
