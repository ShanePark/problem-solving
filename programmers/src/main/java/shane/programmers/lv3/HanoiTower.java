package shane.programmers.lv3;

import com.tistory.shanepark.STool;

import java.util.ArrayList;
import java.util.List;

public class HanoiTower {

    public static void main(String[] args) {
        STool.printDeepArray(solution(3));
    }

    public static int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        hanoi(1, 3, n, list);
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void hanoi(int from, int to, int n, List<int[]> list) {
        if (n == 1) {
            list.add(new int[]{from, to});
            return;
        }
        int temp = temp(from, to);
        hanoi(from, temp, n - 1, list);
        hanoi(from, to, 1, list);
        hanoi(temp, to, n - 1, list);
    }

    public static int temp(int from, int to) {
        for (int i = 1; i <= 3; i++) {
            if (i != from && i != to)
                return i;
        }
        return -1;
    }

    public static int leftShift(int n) {
        return n - 1 > 0 ? n - 1 : n + 2;
    }

    public static int rightShift(int n) {
        return n + 1 <= 3 ? n + 1 : n - 2;
    }

}
