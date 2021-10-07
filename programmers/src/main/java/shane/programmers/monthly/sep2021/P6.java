package shane.programmers.monthly.sep2021;

import com.tistory.shanepark.STool;

/**
 * 문제 설명
 *
 * 정수 n, left, right가 주어집니다. 다음 과정을 거쳐서 1차원 배열을 만들고자 합니다.
 * 1. n행 n열 크기의 비어있는 2차원 배열을 만듭니다.
 * 2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복합니다.
 *  1행 1열부터 i행 i열까지의 영역 내의 모든 빈 칸을 숫자 i로 채웁니다.
 * 3. 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만듭니다.
 * 4. 새로운 1차원 배열을 arr이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지웁니다.
 * 정수 n, left, right가 매개변수로 주어집니다. 주어진 과정대로 만들어진 1차원 배열을 return 하도록 solution 함수를 완성해주세요.
 */
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
