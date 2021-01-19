package lv2;

public class I_Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(4));
	}
	
    static public int solution(int n) {
        return (int)(fib(n)%123456);
    }
    
    static public long fib(int n) {
    	if(n==0)
    		return 0;
    	else if(n==1)
    		return 1;
    	else {
    		long before = 0;
    		long now = 1;
    		for(int i=0; i<n; i++) {
    			now = before + now;
    			before = now;
    			System.out.println(i+" 번째 before : " + before + " now : " + now);
    		}
    		return before;
    	}
    }

}
