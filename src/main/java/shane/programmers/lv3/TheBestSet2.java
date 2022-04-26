package shane.programmers.lv3;

import java.util.Arrays;


public class TheBestSet2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(2, 9)));
    }

    public static int[] solution(int n, int s) {
        if (s < n)
            return new int[]{-1};
        int value = s / n;
        int left = s % n;

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = value + ((i<n-left) ? 0 : 1);
        }
        return arr;
    }
}
