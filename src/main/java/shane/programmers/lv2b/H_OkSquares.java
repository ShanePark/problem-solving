package shane.programmers.lv2b;

public class H_OkSquares {

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}
	
    public static long solution(int w, int h) {
    	int	GreatestCommonDivisor = 0;
    	int max = w < h ? h : w;
    	for(int i=1; i<=max; i++) {
    		if(w%i ==0 && h%i ==0) {
    			GreatestCommonDivisor = i;
    		}
    	}
        long answer = (long)w * (long)h - ((long)w + (long)h -GreatestCommonDivisor);
        return answer;
    }

}
