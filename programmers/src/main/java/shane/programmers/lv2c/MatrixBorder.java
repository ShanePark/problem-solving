package shane.programmers.lv2c;

import java.util.Arrays;

public class MatrixBorder {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6,6,new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}})));
		System.out.println(Arrays.toString(solution(3,3,new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}})));
		System.out.println(Arrays.toString(solution(100,97,new int[][] {{1,1,100,97}})));

	}
	
    public static int[] solution(int rows, int columns, int[][] queries) {
    	
    	int[][] array = new int[rows][columns];
    	int number =1;
    	for(int i=0; i<rows; i++) {
    		for(int j=0; j<columns; j++) {
    			array[i][j] = number++;
    		}
    	}
    	
    	int querySize = queries.length;
    	int[] answer = new int[querySize];
    	for(int i=0; i<querySize; i++) {
    		answer[i] = process(queries[i], array, columns, rows);
    	}
    	
        return answer;
    }
    
    public static int process(int[] query, int[][] array, int columns, int rows) {
    	
    	int min = rows * columns;
    	int p1y = query[0]-1;
    	int p1x = query[1]-1;
    	int p2y = query[2]-1;
    	int p2x = query[3]-1;
    	
    	int y = p1y;
    	int x = p1x;
    	
    	int before = array[y][x];
    	do {
//    		System.out.println(y + " " + x);
//    		System.out.println("p1 : " + p1y + " " + p1x );
//    		System.out.println("p2 : " + p2y + " " + p2x );
    		min = Math.min(before, min);
    		// move point
    		if(y==p1y && x!= p2x) {
    			x++;
    		}else if(x==p2x && y!=p2y) {
    			y++;
//    			System.out.println(x + " " + p2x + " " + y + " ");
    		}else if(y==p2y && x!=p1x) {
    			x--;
    		}else if(x==p1x && y!=p1y) {
    			y--;
    		}
    		
    		// save next number
    		int temp = array[y][x];
    		array[y][x] = before;
    		before = temp;
    		
    		
    	} while(!(x==p1x && y==p1y));
    	
    	return min;
    }

}








