package shane.programmers.challenge2021.monthly.sep2021;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class P1 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    }

    public static int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            set.add(i);
        }

        Arrays.stream(numbers).forEach(n -> set.remove(n));
        int answer = 0;
        for (int n : set) {
            answer += n;
        }

        return answer;

    }

}
