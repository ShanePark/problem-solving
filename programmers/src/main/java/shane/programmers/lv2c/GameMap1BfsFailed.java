package shane.programmers.lv2c;

import java.util.LinkedList;
import java.util.Queue;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	실패 (런타임 에러)
테스트 2 〉	실패 (0.40ms, 52.9MB)
테스트 3 〉	실패 (런타임 에러)
테스트 4 〉	통과 (0.56ms, 54.2MB)
테스트 5 〉	실패 (런타임 에러)
테스트 6 〉	실패 (런타임 에러)
테스트 7 〉	통과 (1.35ms, 52.5MB)
테스트 8 〉	실패 (런타임 에러)
테스트 9 〉	실패 (런타임 에러)
테스트 10 〉	통과 (0.64ms, 52.6MB)
테스트 11 〉	실패 (런타임 에러)
테스트 12 〉	통과 (0.42ms, 52.5MB)
테스트 13 〉	실패 (런타임 에러)
테스트 14 〉	실패 (0.47ms, 53.7MB)
테스트 15 〉	통과 (0.50ms, 52.3MB)
테스트 16 〉	통과 (0.33ms, 53.1MB)
테스트 17 〉	실패 (0.54ms, 52.6MB)
테스트 18 〉	실패 (런타임 에러)
테스트 19 〉	실패 (런타임 에러)
테스트 20 〉	통과 (0.44ms, 52.3MB)
테스트 21 〉	통과 (0.45ms, 53MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 25.6
효율성: 0.0
합계: 25.6 / 100.0
 */
public class GameMap1BfsFailed {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));

	}
	
    public static int solution(int[][] maps) {
    	
    	int x=0,y = 0;
    	int height = maps.length;
    	int width = maps[0].length;
    	boolean[][] visited = new boolean[height][width];
    	visited[0][0] = true;
    	
    	Queue<Node> q = new LinkedList<>();
    	q.offer(new Node(x, y, 1, visited));
    	
    	while(!q.isEmpty()) {
    		Node cur = q.poll();
    		x = cur.x;
    		y = cur.y;
    		
    		if(x == width-1 && y == height-1) {
    			return cur.distance;
    		}
    		
    		visited[x][y] = true;
    		
//    		System.out.println("x : "+ x + ", y : " + y);
//    		System.out.println(Arrays.deepToString(visited));
    		
    		// check up
    		check(x, y-1, visited, height, width, q, maps, cur.distance);
    		
    		// check down
    		check(x, y+1, visited, height, width, q, maps, cur.distance);
    		
    		// check left
    		check(x-1, y, visited, height, width, q, maps, cur.distance);
    		
    		// check right
    		check(x+1, y, visited, height, width, q, maps, cur.distance);
    		
    	}
    	
        return -1;
    }
    
    static void check(int x, int y, boolean[][] visited, int height, int width, Queue<Node> q, int[][] maps, int distance) {
    	if(x<0 || y <0 || width <= x || height <= y || visited[x][y] == true || maps[x][y] != 1 ) {
    		return;
    	}
    	
    	boolean[][] newVisited = new boolean[height][width];
    	for(int i=0; i<height; i++) {
    		for(int j=0; j<width; j++) {
    			newVisited[i][j] = visited[i][j]; 
    		}
    	}
    	
    	q.offer(new Node(x, y, distance+1, newVisited));
    	
    }
    
    static public class Node{
    	int x;
    	int y;
    	int distance;
    	boolean[][] visited;
    	
    	public Node(int x, int y, int distance, boolean[][] visited) {
    		this.x = x;
    		this.y = y;
    		this.distance = distance;
    		this.visited = visited;
    	}
    }

}
