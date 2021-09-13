package shane.programmers.weekly;

import java.util.*;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.25ms, 59MB)
 * 테스트 2 〉	통과 (0.16ms, 59MB)
 * 테스트 3 〉	통과 (0.15ms, 59.7MB)
 * 테스트 4 〉	통과 (0.21ms, 61.8MB)
 * 테스트 5 〉	통과 (0.19ms, 70.6MB)
 * 테스트 6 〉	통과 (0.35ms, 59.7MB)
 * 테스트 7 〉	통과 (0.27ms, 59.4MB)
 * 테스트 8 〉	통과 (0.38ms, 60.5MB)
 * 테스트 9 〉	통과 (0.67ms, 59.3MB)
 * 테스트 10 〉	통과 (3.41ms, 71.1MB)
 * 테스트 11 〉	통과 (9.52ms, 74.4MB)
 * 테스트 12 〉	통과 (13.46ms, 80.1MB)
 * 테스트 13 〉	통과 (0.14ms, 71.7MB)
 * 테스트 14 〉	통과 (0.15ms, 61.6MB)
 * 테스트 15 〉	통과 (0.21ms, 70.9MB)
 * 테스트 16 〉	통과 (0.20ms, 73.6MB)
 * 테스트 17 〉	통과 (0.21ms, 60.6MB)
 * 테스트 18 〉	통과 (0.20ms, 58.2MB)
 * 테스트 19 〉	통과 (0.19ms, 72.2MB)
 * 테스트 20 〉	통과 (0.19ms, 58.9MB)
 * 테스트 21 〉	통과 (1.42ms, 71.7MB)
 * 테스트 22 〉	통과 (0.89ms, 69.9MB)
 * 테스트 23 〉	통과 (0.41ms, 74.6MB)
 * 테스트 24 〉	통과 (10.73ms, 57.6MB)
 * 테스트 25 〉	통과 (9.29ms, 75.5MB)
 * 테스트 26 〉	통과 (25.76ms, 73.1MB)
 * 테스트 27 〉	통과 (28.14ms, 73.3MB)
 * 테스트 28 〉	통과 (0.23ms, 71.6MB)
 * 테스트 29 〉	통과 (0.21ms, 71.7MB)
 * 테스트 30 〉	통과 (1.24ms, 74.1MB)
 * 테스트 31 〉	통과 (2.60ms, 71.3MB)
 * 테스트 32 〉	통과 (4.86ms, 72.6MB)
 * 테스트 33 〉	통과 (14.44ms, 61.5MB)
 * 테스트 34 〉	통과 (19.18ms, 76.9MB)
 * 테스트 35 〉	통과 (0.32ms, 74.8MB)
 * 테스트 36 〉	통과 (0.29ms, 69.5MB)
 * 테스트 37 〉	실패 (런타임 에러)
 * 채점 결과
 * 정확성: 97.1
 * 합계: 97.1 / 100.0
 */
public class Week7SocialDistance {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2}, new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1}, new int[]{2, 1, 3})));
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1}, new int[]{1, 3, 2})));
    }

    public static int[] solution(int[] enter, int[] leave) {

        int[] answer = new int[enter.length];
        Queue<Integer> out = new LinkedList<>();
        for (int n : leave) {
            out.add(n);
        }

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
