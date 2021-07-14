package shane.programmers.lv2a;

import java.util.Arrays;

public class M_MakeMin {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 4, 2},new int[] {5, 4, 4}));
	}
	
    static public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        final int LENGTH = A.length;
        for(int i=0; i<LENGTH; i++) {
        	sum += A[i] * B[LENGTH-1-i];
        }
        return sum;
    }

}
