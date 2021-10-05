package shane.programmers.weekly;

import com.tistory.shanepark.STool;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

public class Week9Pylon {

    public static void main(String[] args) {
        System.out.println(solution(9, STool.convertToIntArray("[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]")));
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
                sb.append(String.format("%d ",pylon.number));
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static int solution(int n, int[][] wires) {

        Map<Integer, Pylon> map = new HashMap<>();

        for (int[] wire : wires) {
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

        System.out.println(map);


        int answer = -1;
        return answer;
    }

}
