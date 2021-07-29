package shane.programmers.lv2b;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (1.64ms, 52.9MB)
테스트 2 〉	통과 (1.38ms, 53.8MB)
테스트 3 〉	통과 (1.51ms, 54.7MB)
테스트 4 〉	통과 (1.10ms, 53MB)
테스트 5 〉	통과 (0.99ms, 52.5MB)
테스트 6 〉	통과 (1.16ms, 53.5MB)
테스트 7 〉	통과 (1.26ms, 52.2MB)
테스트 8 〉	통과 (1.15ms, 52MB)
테스트 9 〉	통과 (1.09ms, 52.1MB)
테스트 10 〉	통과 (1.06ms, 52.4MB)
테스트 11 〉	통과 (1.18ms, 52.1MB)
테스트 12 〉	통과 (1.19ms, 52.9MB)
테스트 13 〉	통과 (1.62ms, 53.3MB)
테스트 14 〉	통과 (3.39ms, 53.3MB)
테스트 15 〉	통과 (4.97ms, 53.9MB)
테스트 16 〉	통과 (1.27ms, 53MB)
테스트 17 〉	통과 (2.10ms, 54.4MB)
테스트 18 〉	통과 (1.89ms, 53.2MB)
테스트 19 〉	통과 (4.44ms, 52.9MB)
테스트 20 〉	통과 (2.24ms, 53.4MB)
테스트 21 〉	통과 (6.86ms, 53.7MB)
테스트 22 〉	통과 (2.08ms, 52.3MB)
테스트 23 〉	통과 (5.46ms, 53.1MB)
테스트 24 〉	통과 (7.93ms, 53.7MB)
테스트 25 〉	통과 (7.50ms, 57.4MB)
테스트 26 〉	통과 (8.12ms, 53.7MB)
테스트 27 〉	통과 (7.22ms, 55.6MB)
테스트 28 〉	통과 (7.51ms, 53MB)
테스트 29 〉	통과 (7.33ms, 56.3MB)
테스트 30 〉	통과 (5.66ms, 57MB)
테스트 31 〉	통과 (2.30ms, 53.8MB)
테스트 32 〉	실패 (시간 초과)
채점 결과
정확성: 96.9
합계: 96.9 / 100.0
 */
public class S_Delivery4 {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}} ,3));
		System.out.println(solution(6,new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}} ,4));

	}
	
    public static int solution(int N, int[][] road, int K) {

    	final int length = road.length;
    	List<Road> roadInfo = new ArrayList<>();
    	for(int i=0; i<length; i++) {
    		roadInfo.add(new Road(road[i]));
    	}
    	
    	Collections.sort(roadInfo, new Comparator<Road>() {
			@Override
			public int compare(Road o1, Road o2) {
				return o1.distance - o2.distance;
			}
		});
    	
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
    			Road rd = roadInfo.get(i);
    			int town1 = rd.town1;
    			int town2 = rd.town2;
    			int distance = rd.distance;
    			if(node.deliveryTime < distance) {
    				break;
    			}
    			if(town1!=node.townNumber && town2!=node.townNumber) {
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
    
    static class Road{
    	int town1;
    	int town2;
    	int distance;
    	public Road(int[] road) {
    		this.town1 = road[0];
    		this.town2 = road[1];
    		this.distance = road[2];
    	}
		@Override
		public String toString() {
			return "Road [town1=" + town1 + ", town2=" + town2 + ", distance=" + distance + "]";
		}
    	
    }

}

