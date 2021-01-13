package lv1;


public class NnumbersWith_X_Distance {

	public static void main(String[] args) {
		long[] numbers = solution(2,5);
		
		for(long n : numbers)
			System.out.println(n);
	}

	static public long[] solution(int x, int n) {
		long[] answer = new long[n];
		for(int i=0; i<n; i++ ) {
			answer[i] = x+(long)x*i;			
		}
		  
		return answer;
	}

}
