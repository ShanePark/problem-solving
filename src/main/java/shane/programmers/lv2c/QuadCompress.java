package shane.programmers.lv2c;

import java.util.Arrays;

public class QuadCompress {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
		System.out.println(Arrays.toString(solution(new int[][]{{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}}
)));
	}
	
    public static int[] solution(int[][] arr) {
    	int[] answer = new int[2];
    	compress(arr, answer);
    	return answer;
    }
    
    public static void compress(int[][] arr, int[] answer) {
    	final int length = arr.length;
    	
    	int temp = arr[0][0];
    	boolean compressed = true;
    	
    	loop:for(int j=0; j<length; j++) {
    		for(int i=0; i<length; i++) {
    			if(temp!=arr[i][j]) {
    				compressed = false;
    				break loop;
    			}
    		}
    	}
    	
    	if(compressed) {
    		answer[temp]++;
    		return;
    	}
    	
    	if(length == 2) {
    		answer[arr[0][0]]++;
    		answer[arr[0][1]]++;
    		answer[arr[1][0]]++;
    		answer[arr[1][1]]++;
    	}else {
    		int[][] arr1 = deepCopy(arr, 0, 0);
    		int[][] arr2 = deepCopy(arr, length/2, 0);
    		int[][] arr3 = deepCopy(arr, 0, length/2);
    		int[][] arr4 = deepCopy(arr, length/2, length/2);
    		compress(arr1, answer);
    		compress(arr2, answer);
    		compress(arr3, answer);
    		compress(arr4, answer);
    	}
    	
    }
    
    public static int[][] deepCopy(int[][] arr, int x, int y){
    	int[][] answer = new int[arr.length/2][arr.length/2];
    	for(int j=0; j<arr.length/2; j++) {
    		for(int i=0; i<arr.length/2; i++) {
    			answer[i][j] = arr[x+i][y+j];
    		}
    	}
    	
    	return answer;
    }

}
