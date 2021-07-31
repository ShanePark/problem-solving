package shane.study.dp;

public class FibonacciDP {
	
	static long[] memo;

	public static void main(String[] args) {
		final int n = 93;
		memo = new long[n+1];
		
		FibonacciDP fibonacci = new FibonacciDP();
		
		for(int i=1; i<=n; i++) {
			System.out.println(fibonacci.fibonacci(i));
		}

	}
	
	public long fibonacci(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		if(memo[n] != 0) {
			return memo[n];
		}else {
			return memo[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		
	}

}
