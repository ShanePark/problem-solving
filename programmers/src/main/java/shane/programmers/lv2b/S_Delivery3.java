package shane.programmers.lv2b;

import java.util.*;

/**
같은 코드로 채점한 결과가 있습니다.
정확성  테스트
테스트 1 〉	통과 (0.35ms, 52.5MB)
테스트 2 〉	통과 (0.54ms, 52.4MB)
테스트 3 〉	통과 (0.64ms, 52.8MB)
테스트 4 〉	통과 (0.45ms, 52.9MB)
테스트 5 〉	통과 (0.43ms, 53.3MB)
테스트 6 〉	통과 (0.47ms, 52.6MB)
테스트 7 〉	통과 (0.47ms, 52MB)
테스트 8 〉	통과 (0.41ms, 52.1MB)
테스트 9 〉	통과 (0.43ms, 52.1MB)
테스트 10 〉	통과 (0.49ms, 52.4MB)
테스트 11 〉	통과 (0.49ms, 53MB)
테스트 12 〉	통과 (0.51ms, 51.5MB)
테스트 13 〉	통과 (0.84ms, 52.2MB)
테스트 14 〉	통과 (1.01ms, 53MB)
테스트 15 〉	통과 (4.83ms, 53.9MB)
테스트 16 〉	통과 (0.47ms, 51.9MB)
테스트 17 〉	통과 (0.47ms, 51.8MB)
테스트 18 〉	통과 (0.65ms, 53.4MB)
테스트 19 〉	통과 (1.55ms, 53MB)
테스트 20 〉	통과 (1.20ms, 52.5MB)
테스트 21 〉	통과 (2.71ms, 53.3MB)
테스트 22 〉	통과 (1.65ms, 52.9MB)
테스트 23 〉	통과 (8.37ms, 53.1MB)
테스트 24 〉	통과 (22.39ms, 53.3MB)
테스트 25 〉	통과 (3.41ms, 54.3MB)
테스트 26 〉	통과 (5.78ms, 57MB)
테스트 27 〉	통과 (10.33ms, 52.9MB)
테스트 28 〉	통과 (7.28ms, 52.7MB)
테스트 29 〉	통과 (23.26ms, 56.8MB)
테스트 30 〉	통과 (13.75ms, 57.3MB)
테스트 31 〉	통과 (0.45ms, 52.1MB)
테스트 32 〉	실패 (시간 초과)
 */
public class S_Delivery3 {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}} ,3));
		System.out.println(solution(6,new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}} ,4));

	}
	
    public static int solution(int N, int[][] road, int K) {

    	final int length = road.length;

    	Queue<Node> q = new LinkedList<>();
    	boolean[] defaultVisited = new boolean[N+1];
    	defaultVisited[1] = true;
    	q.add(new Node(defaultVisited, K, 1));
    	
    	Set<Integer> towns = new HashSet<>();
    	towns.add(1);
    	
    	while(!q.isEmpty()) {
    		Node node = q.poll();
    		if(node.deliveryTime == 0) {
    			continue;
    		}
    		for(int i=0; i<length; i++) {
    			int town1 = road[i][0];
    			int town2 = road[i][1];
    			int distance = road[i][2];
    			if(node.deliveryTime < distance || (town1!=node.townNumber && town2!=node.townNumber) ) {
    				continue;
    			}
    			int destination = (town1==node.townNumber) ? town2 : town1;
    			if(node.visited[destination] != true) {
    				boolean[] visited = Arrays.copyOf(node.visited, N+1);
    				visited[destination] = true;
    				towns.add(destination);
    				q.add(new Node(visited, node.deliveryTime-distance, destination));
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

