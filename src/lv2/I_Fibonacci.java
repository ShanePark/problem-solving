package lv2;
public class I_Fibonacci {

	public static void main(String[] args) {
		System.out.println(fib(162));
		System.out.println(solution(162));
	}
	
    static public int solution(int n) {
    	if(n==0)
    		return 0;
    	else if(n==1)
    		return 1;
    	else {
    		long before = 0;
    		long now = 1;
    		long next = before + now;
    		for(int i=1; i<=n; i++) {
    			now = next;
    			next = (before%1234567 + now%1234567)%1234567;
    			before = now;
    		}
    		return (int)now;
    	}
    }
    
    
    static public long fib(int n) {	// find fib number
    	if(n==0)
    		return 0;
    	else if(n==1)
    		return 1;
    	else {
    		long before = 0;
    		long now = 1;
    		long next = before + now;
    		for(int i=1; i<=n; i++) {
    			now = next;
    			next = before + now;
    			before = now;
    		}
    		return now;
    	}
    }

}
