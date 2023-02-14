package shane.programmers.challenge2021.monthly.sep2021;

public class P6 {

    public static int[] solution(int n, long left, long right) {

        int size = (int) (right - left) + 1;
        int[] answer = new int[size];
        int i = 0;
        for (long l = left; l <= right; l++, i++) {
            answer[i] = numberToIJ(l, n);
        }
        return answer;
    }

    static int numberToIJ(long number, int n) {
        int y = (int) (number / n);
        int x = (int) (number % n);
        return Math.max(x, y) + 1;
    }

}
