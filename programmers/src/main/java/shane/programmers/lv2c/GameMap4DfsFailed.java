package shane.programmers.lv2c;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.20ms, 54MB)
테스트 2 〉	통과 (0.14ms, 52.5MB)
테스트 3 〉	통과 (0.18ms, 52MB)
테스트 4 〉	통과 (0.12ms, 52.1MB)
테스트 5 〉	통과 (0.20ms, 53MB)
테스트 6 〉	통과 (0.17ms, 52MB)
테스트 7 〉	통과 (0.30ms, 52.3MB)
테스트 8 〉	통과 (0.19ms, 52.1MB)
테스트 9 〉	통과 (0.27ms, 52.1MB)
테스트 10 〉	통과 (0.22ms, 53.3MB)
테스트 11 〉	통과 (0.19ms, 52.6MB)
테스트 12 〉	통과 (0.15ms, 52MB)
테스트 13 〉	통과 (0.14ms, 52.5MB)
테스트 14 〉	통과 (0.11ms, 52.1MB)
테스트 15 〉	통과 (0.20ms, 52.6MB)
테스트 16 〉	통과 (0.13ms, 52.4MB)
테스트 17 〉	통과 (0.20ms, 51.8MB)
테스트 18 〉	통과 (0.12ms, 52.6MB)
테스트 19 〉	통과 (0.12ms, 52MB)
테스트 20 〉	통과 (0.14ms, 53.8MB)
테스트 21 〉	통과 (0.13ms, 52.8MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 69.9
효율성: 0.0
합계: 69.9 / 100.0
 */
public class GameMap4DfsFailed {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}
	
    public static int solution(int[][] maps) {
    	
    	int height = maps.length;
    	int width = maps[0].length;
    	boolean[][] visited = new boolean[height][width];
    	int[] dx = {0,0,1,-1};
    	int[] dy = {1,-1,0,0};
    	
    	Queue<int[]> q = new LinkedList<>();
    	
    	q.offer(new int[] {0,0,1});
    	
    	while(!q.isEmpty()) {
    		int[] cur = q.poll();
    		int y = cur[0];
    		int x = cur[1];
    		int distance = cur[2];
    		visited[y][x] = true;
    		
    		if(x == width-1 & y== height -1) {
    			return distance;
    		}
    		
    		for(int i=0; i<4; i++) {
    			int tempY = y + dy[i];
    			int tempX = x + dx[i];
    			
    			if(tempX >= 0 && tempY >= 0 && tempX < width && tempY < height && visited[tempY][tempX]==false && maps[tempY][tempX] == 1) {
    				q.offer(new int[] {tempY, tempX, distance+1});
    			}
    			
    		}
    		
    	}
    	
        return -1;
    }
    

}
