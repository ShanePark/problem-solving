package shane.programmers.lv2a;

import java.util.Arrays;

public class S_Carpet {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString((solution(10, 2))));
		System.out.println(Arrays.toString((solution(8, 1))));
		System.out.println(Arrays.toString((solution(24, 24))));
	}
	
    public static int[] solution(int brown, int yellow) {
    	int x = -1,y = -1;
    	for(x=0; x<brown/2; x++) {
    		if((brown - 2*x + 4) % 2 != 0)
    			continue;
    		y = (brown - 2*x + 4)/2;
    		if(x*y - 2*x - 2*y + 4 == yellow)
    			break;
    	}
    	if(x < y) {
    		int temp = x;
    		x = y;
    		y = temp;
    	}
        int[] answer = {x,y};
        return answer;
    }

}
