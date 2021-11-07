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
        list.add(new int[]{from, to});
        hanoi(temp, to, n - 1, list);
    }

    public static int temp(Integer from, Integer to) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(from);
        list.remove(to);
        return list.get(0);
    }

}
