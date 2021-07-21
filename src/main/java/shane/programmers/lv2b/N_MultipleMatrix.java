package shane.programmers.lv2b;

import java.util.Arrays;

public class N_MultipleMatrix {

	public static void main(String[] args) {
		
		System.out.println(Arrays.deepToString(solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3, 3}, {3, 3}})));
		System.out.println(Arrays.deepToString(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}})));

	}
	
    public static int[][] solution(int[][] arr1, int[][] arr2) {
    	int arr1Width = arr1[0].length;
    	int height = arr1.length;
    	int width = arr2[0].length;
        int[][] answer = new int[height][width];
        
        for(int i=0; i<height; i++) {
        	for(int j=0; j<width; j++) {
        		 for(int k=0; k<arr1Width; k++) {
        			 answer[i][j] += arr1[i][k] * arr2[k][j];
        		 }
        	}
        }
        
        return answer;
    }

}
