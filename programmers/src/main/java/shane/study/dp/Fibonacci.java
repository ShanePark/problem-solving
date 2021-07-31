package shane.study.dp;

public class Fibonacci {

	public static void main(String[] args) {
		
		final int n = 50;
		
		Fibonacci fibonacci = new Fibonacci();
		
		for(int i=1; i<=n; i++) {
			System.out.println(fibonacci.fibonacci(i));
		}

	}
	
	public long fibonacci(int n){
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		return fibonacci(n-1) + fibonacci(n-2);
		
	}

}
