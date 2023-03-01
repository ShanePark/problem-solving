package shane.programmers.challenge2021.weekly;

import io.github.shanepark.Ps;

import java.util.*;

public class Week9Pylon {

    public static void main(String[] args) {
        System.out.println(solution(9, Ps.intArray("[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]")));
        System.out.println(solution(4, Ps.intArray("[[1,2],[2,3],[3,4]]")));
        System.out.println(solution(7, Ps.intArray("[[1,2],[2,7],[3,7],[3,4],[4,5],[6,7]]")));
    }

    static class Pylon {
        int number;
        List<Pylon> pylons;

        Pylon(int number) {
            this.number = number;
            this.pylons = new ArrayList<>();
        }

        void add(Pylon remote) {
            pylons.add(remote);
        }

        @Override
        public String toString() {
            return "Pylon{" +
                    "number=" + number +
                    ", pylons=" + printPylons() +
                    '}';
        }

        public String printPylons() {
            StringBuffer sb = new StringBuffer("[");
            for (Pylon pylon : pylons) {
                sb.append(String.format("%d ", pylon.number));
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static int solution(int n, int[][] wires) {
        int result = 100;
        for (int j = 0; j < wires.length; j++) {
            Map<Integer, Pylon> map = new HashMap<>();
            for (int i = 0; i < wires.length; i++) {
                if (i == j) continue;
                int[] wire = wires[i];
                int host = wire[0];
                int remote = wire[1];
                Pylon pylon = map.get(host);
                if (pylon == null) {
                    pylon = new Pylon(host);
                    map.put(host, pylon);
                }
                Pylon pylon2 = map.get(remote);
                if (pylon2 == null) {
                    pylon2 = new Pylon(remote);
                    map.put(remote, pylon2);
                }
                map.put(remote, pylon2);
                pylon.add(pylon2);
                pylon2.add(pylon);

            }
            int size1 = calcSize(map, wires[j][0]);
            int size2 = calcSize(map, wires[j][1]);
            int diff = Math.abs(size1 - size2);
            result = Math.min(result, diff);
        }

        return result;
    }

    public static int calcSize(Map<Integer, Pylon> map, int number) {
        Pylon pylon = map.get(number);
        if (pylon == null)
            return 1;
        int size = 1;
        Set<Integer> set = new HashSet<>();
        set.add(number);
        travel(pylon, set);

        return set.size();
    }

    public static void travel(Pylon pylon, Set set) {
        List<Pylon> list = pylon.pylons;
        for (Pylon p : list) {
            if (!set.contains(p.number)) {
                set.add(p.number);
                travel(p, set);
            }
        }
    }

}
