package shane.programmers.lv2b;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.54ms, 52.7MB)
테스트 2 〉	통과 (0.41ms, 52MB)
테스트 3 〉	통과 (0.51ms, 52.1MB)
테스트 4 〉	통과 (0.43ms, 52.9MB)
테스트 5 〉	통과 (0.38ms, 52.2MB)
테스트 6 〉	통과 (0.43ms, 52.8MB)
테스트 7 〉	통과 (0.40ms, 52.8MB)
테스트 8 〉	통과 (0.36ms, 52.2MB)
테스트 9 〉	통과 (0.33ms, 53.1MB)
테스트 10 〉	통과 (0.41ms, 51.9MB)
테스트 11 〉	통과 (0.48ms, 54.1MB)
테스트 12 〉	통과 (0.45ms, 52.2MB)
테스트 13 〉	통과 (0.49ms, 52.7MB)
테스트 14 〉	통과 (0.61ms, 52.8MB)
테스트 15 〉	통과 (0.96ms, 52.2MB)
테스트 16 〉	통과 (0.51ms, 52.2MB)
테스트 17 〉	통과 (0.45ms, 52.4MB)
테스트 18 〉	통과 (0.55ms, 52.7MB)
테스트 19 〉	통과 (0.60ms, 54.3MB)
테스트 20 〉	통과 (0.70ms, 53.1MB)
테스트 21 〉	통과 (0.77ms, 52.6MB)
테스트 22 〉	통과 (0.77ms, 52.8MB)
테스트 23 〉	통과 (1.14ms, 53.6MB)
테스트 24 〉	통과 (3.46ms, 53.2MB)
테스트 25 〉	통과 (0.81ms, 55.4MB)
테스트 26 〉	통과 (0.95ms, 53.8MB)
테스트 27 〉	통과 (1.06ms, 53.5MB)
테스트 28 〉	통과 (0.84ms, 54.8MB)
테스트 29 〉	통과 (2.53ms, 54.1MB)
테스트 30 〉	통과 (0.82ms, 55.2MB)
테스트 31 〉	통과 (0.60ms, 52.7MB)
테스트 32 〉	실패 (시간 초과)
채점 결과
정확성: 96.9
합계: 96.9 / 100.0
 */
public class S_Delivery7 {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}} ,3));
		System.out.println(solution(6,new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}} ,4));
	}
	
    public static int solution(int N, int[][] road, int K) {

    	int[][] map = new int[N+1][N+1];
    	for(int[] rd : road) {
    		if(map[rd[0]][rd[1]] == 0 || map[rd[0]][rd[1]] > rd[2]) {
    			map[rd[0]][rd[1]] = rd[2];
    			map[rd[1]][rd[0]] = rd[2];
    		}
    	}
    	
    	Queue<Node> q = new LinkedList<>();
    	boolean[] defaultVisited = new boolean[N+1];
    	defaultVisited[1] = true;
    	q.add(new Node(defaultVisited, K, 1));
    	
    	Set<Integer> towns = new HashSet<>();
    	towns.add(1);
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		for(int i=2; i<=N; i++) {
    			if(node.visited[i]!=true && map[node.townNumber][i]!=0 && map[node.townNumber][i] <= node.deliveryTime) {
    				boolean[] visited = Arrays.copyOf(node.visited, N+1);
    				visited[i] = true;
    				q.offer(new Node(visited, node.deliveryTime-map[node.townNumber][i], i));
    				towns.add(i);
    			}
    		}
    	}
    	
        return towns.size();
    }
    
    static class Node{
    	boolean[] visited;
    	int deliveryTime;
    	int townNumber;
    	public Node(boolean[] visited, int deliveryTime, int townNumber) {
    		this.visited = visited;
    		this.deliveryTime = deliveryTime;
    		this.townNumber = townNumber;
    	}
		@Override
		public String toString() {
			return "Node [visited=" + Arrays.toString(visited) + ", deliveryTime=" + deliveryTime + ", townNumber="
					+ townNumber + "]";
		}
    }
    

}

