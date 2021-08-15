package shane.programmers.lv3;

public class ChangeCases2 {


	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 2, 5 }));
	}

	public static int solution(int n, int[] money) {
		int[] memo = new int[n+1];
		memo[0] = 1;
		
		for(int i=1; i<=n; i++) {
			if( i % money[0] == 0)
				memo[i] = 1;
		}
		
		for(int i=1; i<money.length; i++) {
			if(n<money[i]) {
				n = i-1;
				break;
			}
			for(int j=1; j<=n; j++) {
				if(j>=money[i])
					memo[j] = memo[j] + memo[j-money[i]];
			}
		}
		
		return memo[n];
		
	}


}







