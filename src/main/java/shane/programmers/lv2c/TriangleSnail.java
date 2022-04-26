package shane.programmers.lv2c;

import java.util.Arrays;

public class TriangleSnail {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(4)));
	}
	
    public static int[] solution(int n) {
    	
    	int[][] array = new int[n][];
    	for(int i=0; i<n; i++) {
    		int[] arr = new int[i+1];
    		array[i] = arr;
    	}
    	
    	int summaryUntilN = n * (n+1) /2;
    	
    	int y=0, x=0;
    	for(int i=1; i<=summaryUntilN; i++) {
//    		System.out.println("y : " + y + ", x : " + x);
    		array[y][x] = i;
    		
    		if(
    			x!=0 && (
    					(x == array[y].length-1 && array[y-1][x-1] == 0)
    					|| ( x<array[y].length-1 && (array[y][x+1] != 0) && array[y-1][x-1] == 0)
    			)
    		) {
    			x--;
    			y--;
    		}else if(y==array.length-1 || array[y+1][x] !=0){
    			x++;
    		}else {
    			y++;
    		}
    	}
    	
//    	System.out.println(Arrays.deepToString(array));
    	
    	int[] answer = new int[summaryUntilN];
    	int i = 0;
    	for(int[] arr : array) {
    		for(int num : arr) {
    			answer[i++] = num;
    		}
    	}
    	
        return answer;
    }
    
}
