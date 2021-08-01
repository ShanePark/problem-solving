package shane.programmers.lv2c;

import java.util.*;

public class GameMap5 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
	
    public static int solution(int[][] maps) {
    	
    	int height = maps.length;
    	int width = maps[0].length;
    	boolean[][] visited = new boolean[height][width];
    	visited[0][0] = true;
    	
    	int[] dx = {0,0,1,-1};
    	int[] dy = {1,-1,0,0};
    	
    	Queue<int[]> q = new LinkedList<>();
    	
    	q.offer(new int[] {0,0,1});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int y = cur[0];
    		int x = cur[1];
    		int distance = cur[2];
    		
    		if(x == width-1 & y== height -1) {
    			return distance;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int tempY = y + dy[i];
    			int tempX = x + dx[i];
    			
    			if(tempX >= 0 && tempY >= 0 && tempX < width && tempY < height && visited[tempY][tempX]==false && maps[tempY][tempX] == 1) {
    				visited[tempY][tempX] = true;
    				q.offer(new int[] {tempY, tempX, distance+1});
    			}
    			
    		}
    		
    	}
    	
        return -1;
    }
    

}
