package shane.programmers.lv3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressN3 {

    public static void main(String[] args) {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
        System.out.println(solution(5, 31168));
        System.out.println(solution(5, 26)); // 4
    }

    public static int solution(int N, int number) {
        if (N == number)
            return 1;
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(new HashSet<>());
        }

        list.get(1).add(N);
        list.get(2).add(0);
        list.get(2).add(1);
        list.get(2).add(2 * N);
        list.get(2).add(11 * N);
        list.get(2).add(N * N);
        list.get(3).add(N * 111);
        list.get(4).add(N * 1111);

        for (int i = 2; i < 9; i++) {
            if (list.get(i).contains(number)) {
                return i;
            }
            calc(N, i, list);
        }

        return -1;

    }

    public static void calc(int N, int index, List<Set<Integer>> list) {
        Set<Integer> next = list.get(index + 1);
        for (int i = 1; i <= (index / 2) + 1; i++) {
            calc(list.get(i), list.get(index+1 - i), next);
        }
    }

    public static void calc(Set<Integer> set1, Set<Integer> set2, Set<Integer> next) {
        for (Integer n : set1) {
            for (Integer N : set2) {
                next.add(n + N);
                next.add(n - N);
                next.add(N - n);
                next.add(n * N);
                if (N != 0)
                    next.add(n / N);
                if (n != 0)
                    next.add(N / n);
            }
        }
    }

}
