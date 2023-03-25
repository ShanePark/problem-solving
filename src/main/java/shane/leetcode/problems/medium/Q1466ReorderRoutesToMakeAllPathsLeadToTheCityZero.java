package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 165 ms Beats 32.97%
 * Memory 87.1 MB Beats 18.84%
 */
public class Q1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {

    @Test
    public void test() {
        assertThat(minReorder(6, Ps.intArray("[[0,1],[1,3],[2,3],[4,0],[4,5]]"))).isEqualTo(3);
        assertThat(minReorder(5, Ps.intArray("[[1,0],[1,2],[3,2],[3,4]]"))).isEqualTo(2);
        assertThat(minReorder(3, Ps.intArray("[[1,0],[2,0]]"))).isEqualTo(0);
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, City> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new City(i));
        }
        for (int[] connection : connections) {
            City from = map.get(connection[0]);
            City to = map.get(connection[1]);
            from.addRoad(to);
        }
        City capital = map.get(0);
        int answer = capital.countReverse();
        return answer;
    }

    class City {
        public City(int num) {
            this.num = num;
        }

        int num;
        Set<City> out = new HashSet<>();
        Set<City> in = new HashSet<>();

        public void addRoad(City to) {
            this.out.add(to);
            to.in.add(this);
        }

        public int countReverse() {
            int cnt = out.size();
            for (City city : out) {
                city.in.remove(this);
                cnt += city.countReverse();
            }
            for (City city : in) {
                city.out.remove(this);
                cnt += city.countReverse();
            }
            in.addAll(out);
            out.clear();
            return cnt;
        }
    }

}
