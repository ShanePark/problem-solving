package lv1;

public class PlusMinus {
	
	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		System.out.println(solution(absolutes, signs));
	}
	
    public static int solution(int[] absolutes, boolean[] signs) {
    	int length = absolutes.length;
    	int sum = 0;
    	for(int i=0; i<length; i++) {
    		if(signs[i] == true) {
    			sum += absolutes[i];
    		}else {
    			sum -= absolutes[i];
    		}
    	}
        return sum;
    }

}
