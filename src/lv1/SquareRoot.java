package lv1;

public class SquareRoot {

	public static void main(String[] args) {
		long l = solution(121L);
		System.out.println(l);

	}
	
    static public long solution(long n) {
        double temp = Math.sqrt(n);
        if((long)temp * (long)temp == n)
        	return (long)((temp+1)*(temp+1));
        else return -1;
    }

}
