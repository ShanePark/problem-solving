package shane.programmers.challenge2021.monthly.sep2021;

import com.tistory.shanepark.STool;

public class P6 {
    public static void main(String[] args) {
        STool.printArray(solution(3, 2, 5)); // [3,2,2,3]
        STool.printArray(solution(4, 7, 14)); // [4,3,3,3,4,4,4,4]
    }

    public static int[] solution(int n, long left, long right) {

        int size = (int)(right - left) + 1;
        int[] answer = new int[size];
        int i=0;
        for(long l = left; l<=right; l++,i++ ) {
            answer[i] = numberToIJ(l, n);
        }
        return answer;
    }

    static int numberToIJ(long number, int n) {
        int y = (int)(number / n) ;
        int x = (int)(number % n);
        return Math.max(x, y)+1;
    }

}
