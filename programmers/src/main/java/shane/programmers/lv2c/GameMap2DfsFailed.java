package shane.programmers.lv2c;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.07ms, 53.5MB)
테스트 2 〉	통과 (0.03ms, 53MB)
테스트 3 〉	통과 (0.06ms, 51.9MB)
테스트 4 〉	통과 (0.04ms, 52.3MB)
테스트 5 〉	통과 (0.06ms, 51.7MB)
테스트 6 〉	통과 (0.09ms, 52.2MB)
테스트 7 〉	통과 (0.15ms, 52.3MB)
테스트 8 〉	통과 (0.05ms, 52MB)
테스트 9 〉	통과 (0.18ms, 52.9MB)
테스트 10 〉	통과 (2.30ms, 51.8MB)
테스트 11 〉	통과 (0.03ms, 51.8MB)
테스트 12 〉	통과 (0.03ms, 52.2MB)
테스트 13 〉	통과 (0.05ms, 56.6MB)
테스트 14 〉	통과 (0.05ms, 52.4MB)
테스트 15 〉	통과 (0.05ms, 52.5MB)
테스트 16 〉	통과 (0.04ms, 52.8MB)
테스트 17 〉	통과 (0.14ms, 52.4MB)
테스트 18 〉	통과 (0.06ms, 52.8MB)
테스트 19 〉	통과 (0.04ms, 52MB)
테스트 20 〉	통과 (0.02ms, 52.5MB)
테스트 21 〉	통과 (0.03ms, 52.4MB)
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
public class GameMap2DfsFailed {
	static int answer;

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));

	}
	
    public static int solution(int[][] maps) {
    	
    	answer = -1;
    	
    	int height = maps.length;
    	int width = maps[0].length;
    	boolean[][] visited = new boolean[height][width];
    	visited[0][0] = true;
    	
    	dfs(0, 0, visited, height, width, maps, 1);

        return answer;
    }
    
    static void dfs(int x, int y, boolean[][] visited, int height, int width, int[][] maps, int distance) {
    	
//    	System.out.println("x : " + x + ", y : " + y);
    	if(x == width-1 && y== height -1) {
    		answer = (answer==-1) ? distance : Math.min(answer, distance);
//    		System.out.println(answer);
    		return;
    	}
    	
    	if(answer >0 && answer <= distance)
    		return;
    	
		// check up
    	if(0 < y && visited[y-1][x] == false && maps[y-1][x] == 1) {
    		visited[y-1][x] = true;
    		dfs(x, y-1, visited, height, width, maps, distance+1);
    		visited[y-1][x] = false;
    	}
		
		// check down
    	if(y < height-1 && visited[y+1][x] == false && maps[y+1][x] == 1) {
    		visited[y+1][x] = true;
    		dfs(x, y+1, visited, height, width, maps, distance+1);
    		visited[y+1][x] = false;
    	}
	
		// check left
    	if(0 < x && visited[y][x-1] == false && maps[y][x-1] == 1) {
    		visited[y][x-1] = true;
    		dfs(x-1, y, visited, height, width, maps, distance+1);
    		visited[y][x-1] = false;
    	}
	
		// check right
    	if(x < width-1 && visited[y][x+1] == false && maps[y][x+1] == 1) {
    		visited[y][x+1] = true;
    		dfs(x+1, y, visited, height, width, maps, distance+1);
    		visited[y][x+1] = false;
    	}
    	
    	
    }
    
    

}
