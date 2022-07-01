package shane.programmers.challenge2021.weekly;

import java.util.*;

public class Week7SocialDistance {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2}, new int[]{1, 2, 3})));
//        System.out.println(Arrays.toString(solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 3, 4})));
//        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1}, new int[]{2, 1, 3})));
//        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1}, new int[]{1, 3, 2})));
        System.out.println(Arrays.toString(solution(new int[]{1}, new int[]{1})));
    }

    public static int[] solution(int[] enter, int[] leave) {

        int[] answer = new int[enter.length];
        Queue<Integer> out = new LinkedList<>();
        for (int n : leave) {
            out.add(n);
        }

        if(enter.length == 1)
            return new int[]{0};

        Set<Integer> set = new HashSet<>();
        set.add(enter[0]);
        int i = 1;
        while (set.size() > 0 || i < enter.length - 1) {
            int number = enter[i];
            int peek = out.peek();
            if (set.contains(peek)) {
                answer[peek - 1] += set.size() - 1;
                for (int n : set) {
                    if (n != peek)
                        answer[n - 1]++;
                }
                set.remove(out.poll());
            } else {
                set.add(number);
                if (i < enter.length - 1)
                    i++;
            }
        }

        return answer;
    }

}
