package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * failed. 69 / 70 testcases passed
 */
public class Q886PossibleBipartition {

    // not pass this
    @Test
    public void test3() {
        assertThat(possibleBipartition(100, Ps.intArray("[[60,69],[27,46],[24,92],[17,20],[33,41],[73,82],[8,72],[12,17],[17,90],[13,20],[32,87],[60,81],[23,95],[8,87],[52,63],[26,54],[20,32],[21,37],[54,61],[6,41],[1,89],[18,36],[65,71],[44,55],[55,71],[54,99],[49,51],[4,12],[2,12],[26,49],[6,14],[4,42],[87,94],[58,59],[48,68],[3,55],[8,63],[25,70],[81,97],[1,82],[43,45],[17,50],[65,88],[37,63],[14,19],[45,47],[22,83],[50,51],[27,31],[59,89],[64,98],[71,90],[23,75],[14,65],[3,60],[9,81],[22,30],[54,91],[42,53],[33,98],[1,25],[92,99],[35,90],[9,67],[54,56],[28,43],[13,68],[16,33],[30,49],[50,82],[40,68],[43,49],[67,76],[30,64],[19,93],[7,70],[21,95],[83,87],[59,99],[57,87],[53,60],[68,100],[22,40],[6,47],[25,49],[50,77],[28,81],[26,65],[38,79],[90,93],[54,79],[31,91],[10,22],[21,88],[83,92],[9,98],[80,87],[32,70],[3,19],[59,94],[10,90],[82,85],[2,36],[49,100],[62,90],[39,76],[4,50],[10,45],[79,92],[38,88],[82,92],[39,59],[69,90],[15,50],[8,66],[96,97],[27,55],[4,19],[61,85],[36,89],[35,36],[36,39],[72,82],[12,56],[19,86],[23,100],[15,59],[51,97],[2,28],[24,49],[60,86],[15,33],[84,92],[32,74],[9,88],[21,24],[95,97],[29,40],[24,70],[59,69],[13,92],[36,52],[76,84],[7,64],[48,63],[45,57],[1,16],[65,100],[2,23],[90,100],[6,86],[5,46],[3,50],[70,96],[9,13],[6,71],[54,77],[31,99],[24,63],[46,86],[12,98],[23,80],[15,55],[45,67],[19,48],[14,66],[3,59],[34,60],[4,90],[27,76],[38,94],[12,37],[36,58],[51,66],[6,80],[15,22],[41,66],[18,68],[16,92],[8,73],[19,57],[59,79],[17,21],[23,27],[4,65],[1,80],[42,61],[51,54],[6,75],[3,87],[19,88],[45,62],[21,82],[20,57],[60,80],[25,50],[20,39],[62,74],[37,92],[13,64],[55,57],[9,32],[6,40],[39,90],[2,72],[7,45],[37,45],[42,56],[40,72],[37,55],[53,63],[30,46],[68,96],[1,34],[72,99],[87,95],[23,41],[6,35],[4,55],[63,89],[6,69],[49,83],[26,97],[76,77],[42,77],[47,78],[23,82],[27,50],[38,96],[28,53],[34,64],[22,39],[29,56],[16,19],[41,45],[13,76],[65,82],[42,52],[40,92],[10,29],[3,28],[60,91],[32,55],[39,65],[25,54],[29,43],[7,54],[28,89],[38,41],[12,52],[65,77],[76,89],[12,18],[56,76],[42,99],[51,63],[23,94],[21,58],[45,88],[71,97],[1,47],[34,76],[24,74],[17,38],[63,82],[28,80],[53,72],[36,48],[20,83],[20,30],[2,19],[50,57],[46,83],[1,14],[87,99],[38,71],[46,53],[27,63],[60,71],[23,77],[45,96],[62,85],[1,53],[4,49],[1,81],[17,31],[50,71],[40,49],[1,75],[65,95],[79,97],[26,31],[9,100],[1,7],[66,79],[56,64],[19,52],[59,84],[60,94],[25,36],[37,76],[32,50],[14,70],[25,78],[36,88],[29,80],[23,30],[10,49],[13,36],[55,84],[43,59],[31,84],[41,70],[41,72],[2,31],[33,91],[20,62],[68,80],[73,77],[36,71],[29,41],[10,74],[40,63],[30,54],[28,91],[11,53],[74,93],[6,79],[10,65],[20,52],[76,91],[42,71],[43,65],[47,68],[18,85],[23,88],[53,59],[34,74],[7,19],[22,41],[48,64],[6,44],[8,21],[30,72],[20,93],[6,88],[29,57],[10,23],[66,88],[22,95],[19,75],[44,72],[58,87],[26,60],[47,50],[72,77],[36,83],[34,63],[8,54],[31,37],[5,50],[26,73],[42,47],[72,83],[54,71],[41,50],[37,60],[9,25],[14,22],[38,51],[56,92],[1,5],[2,54],[56,66],[60,88],[4,28],[63,100],[34,54],[5,59],[9,56],[6,48],[41,59],[53,66],[76,94],[65,98],[2,29],[42,100],[46,69],[21,61],[19,37],[9,95],[6,39],[4,33],[8,36],[61,72],[38,75],[52,65],[41,60],[54,75],[31,95],[11,13],[45,56],[49,61],[41,87],[56,63],[70,83],[21,32],[34,72],[48,66],[11,86],[24,78],[2,66],[36,57],[5,55],[16,49],[4,92],[10,11],[47,97],[39,63],[56,87],[19,77],[11,24],[44,74],[28,71],[21,79],[9,47],[3,20],[60,67],[21,41],[28,52],[32,63],[11,79],[10,50],[4,97],[68,79],[58,92],[89,97],[20,51],[58,70],[37,72]]"))).isTrue();
    }

    @Test
    public void test() {
        assertThat(possibleBipartition(1, new int[][]{})).isTrue();
        assertThat(possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}})).isTrue();
        assertThat(possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}})).isFalse();
        assertThat(possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}})).isFalse();
        assertThat(possibleBipartition(4, new int[][]{{1, 2}, {3, 4}, {4, 2}})).isTrue();
    }

    @Test
    public void test2() {
        assertThat(possibleBipartition(4, new int[][]{{1, 2}, {4, 3}})).isTrue();
        assertThat(possibleBipartition(50, Ps.intArray("[[21,47],[4,41],[2,41],[36,42],[32,45],[26,28],[32,44],[5,41],[29,44],[10,46],[1,6],[7,42],[46,49],[17,46],[32,35],[11,48],[37,48],[37,43],[8,41],[16,22],[41,43],[11,27],[22,44],[22,28],[18,37],[5,11],[18,46],[22,48],[1,17],[2,32],[21,37],[7,22],[23,41],[30,39],[6,41],[10,22],[36,41],[22,25],[1,12],[2,11],[45,46],[2,22],[1,38],[47,50],[11,15],[2,37],[1,43],[30,45],[4,32],[28,37],[1,21],[23,37],[5,37],[29,40],[6,42],[3,11],[40,42],[26,49],[41,50],[13,41],[20,47],[15,26],[47,49],[5,30],[4,42],[10,30],[6,29],[20,42],[4,37],[28,42],[1,16],[8,32],[16,29],[31,47],[15,47],[1,5],[7,37],[14,47],[30,48],[1,10],[26,43],[15,46],[42,45],[18,42],[25,42],[38,41],[32,39],[6,30],[29,33],[34,37],[26,38],[3,22],[18,47],[42,48],[22,49],[26,34],[22,36],[29,36],[11,25],[41,44],[6,46],[13,22],[11,16],[10,37],[42,43],[12,32],[1,48],[26,40],[22,50],[17,26],[4,22],[11,14],[26,39],[7,11],[23,26],[1,20],[32,33],[30,33],[1,25],[2,30],[2,46],[26,45],[47,48],[5,29],[3,37],[22,34],[20,22],[9,47],[1,4],[36,46],[30,49],[1,9],[3,26],[25,41],[14,29],[1,35],[23,42],[21,32],[24,46],[3,32],[9,42],[33,37],[7,30],[29,45],[27,30],[1,7],[33,42],[17,47],[12,47],[19,41],[3,42],[24,26],[20,29],[11,23],[22,40],[9,37],[31,32],[23,46],[11,38],[27,29],[17,37],[23,30],[14,42],[28,30],[29,31],[1,8],[1,36],[42,50],[21,41],[11,18],[39,41],[32,34],[6,37],[30,38],[21,46],[16,37],[22,24],[17,32],[23,29],[3,30],[8,30],[41,48],[1,39],[8,47],[30,44],[9,46],[22,45],[7,26],[35,42],[1,27],[17,30],[20,46],[18,29],[3,29],[4,30],[3,46]]"))).isTrue();
    }


    public boolean possibleBipartition(int n, int[][] dislikes) {
        if (dislikes.length == 0)
            return true;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int[] dislike : dislikes) {
            if (dislike[0] > dislike[1]) {
                int tmp = dislike[0];
                dislike[0] = dislike[1];
                dislike[1] = tmp;
            }
        }
        Arrays.sort(dislikes, Comparator.comparingInt(o -> o[0]));
        Queue<int[]> q = new LinkedList<>();
        q.addAll(Arrays.stream(dislikes).collect(Collectors.toList()));
        int[] poll = q.poll();
        set1.add(poll[0]);
        set2.add(poll[1]);

        Set<int[]> passed = new HashSet<>();

        while (!q.isEmpty()) {
            int[] dislike = q.poll();
            int first = dislike[0];
            int second = dislike[1];
            if (set1.contains(first)) {
                if (set1.contains(second))
                    return false;
                set2.add(second);
            } else if (set2.contains(first)) {
                if (set2.contains(second))
                    return false;
                set1.add(second);
            } else if (set1.contains(second)) {
                set2.add(first);
            } else if (!passed.contains(dislike)) {
                q.offer(dislike);
                passed.add(dislike);
            } else {
                passed.clear();
                set1.add(first);
                set2.add(second);
            }
        }
        return true;
    }

}
