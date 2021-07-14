package shane.programmers.lv1;

public class Divisor {
	
	public static void main(String[] args) {
		System.out.println(solution(24, 27));
	}
	
    public static int solution(int left, int right) {
    	int sum = 0;
        for(int i=left; i<=right; i++) {
        	double sqrt = Math.sqrt(i);
        	if(sqrt == Math.floor(sqrt)) {
        		sum -= i;
        	}else {
        		sum += i;
        	}
        }
        return sum;
    }
    

}
