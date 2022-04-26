package shane.programmers.lv2b;

import java.util.*;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (1.80ms, 53.3MB)
테스트 2 〉	통과 (1.13ms, 52.5MB)
테스트 3 〉	통과 (1.47ms, 52.4MB)
테스트 4 〉	통과 (1.03ms, 53MB)
테스트 5 〉	통과 (1.27ms, 52.3MB)
테스트 6 〉	통과 (1.15ms, 52.3MB)
테스트 7 〉	통과 (1.38ms, 52.5MB)
테스트 8 〉	통과 (1.13ms, 52.4MB)
테스트 9 〉	통과 (1.14ms, 52.9MB)
테스트 10 〉	통과 (1.07ms, 53.3MB)
테스트 11 〉	통과 (1.23ms, 52.4MB)
테스트 12 〉	통과 (1.41ms, 52.8MB)
테스트 13 〉	통과 (1.32ms, 52.3MB)
테스트 14 〉	통과 (11.75ms, 53MB)
테스트 15 〉	통과 (16.14ms, 53.6MB)
테스트 16 〉	통과 (1.28ms, 52MB)
테스트 17 〉	통과 (1.20ms, 53.2MB)
테스트 18 〉	통과 (2.85ms, 52.3MB)
테스트 19 〉	통과 (17.76ms, 53.5MB)
테스트 20 〉	통과 (8.67ms, 53.3MB)
테스트 21 〉	통과 (19.97ms, 53.1MB)
테스트 22 〉	통과 (8.32ms, 52.7MB)
테스트 23 〉	통과 (27.57ms, 54.3MB)
테스트 24 〉	통과 (15.90ms, 53.7MB)
테스트 25 〉	통과 (39.22ms, 57.5MB)
테스트 26 〉	통과 (18.49ms, 53.4MB)
테스트 27 〉	통과 (29.85ms, 53.6MB)
테스트 28 〉	통과 (41.59ms, 57.3MB)
테스트 29 〉	통과 (41.28ms, 57.9MB)
테스트 30 〉	통과 (25.74ms, 53.5MB)
테스트 31 〉	통과 (2.46ms, 52.4MB)
테스트 32 〉	실패 (시간 초과)
채점 결과
정확성: 96.9
합계: 96.9 / 100.0
 */
public class S_Delivery6 {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}} ,3));
		System.out.println(solution(6,new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}} ,4));
	}
	
    public static int solution(int N, int[][] road, int K) {

    	int length = road.length;
    	List<Road> roadInfo = new ArrayList<>();
    	for(int i=0; i<length; i++) {
    		Road rd = new Road(road[i]);
    		if(roadInfo.indexOf(rd)<0) {
    			roadInfo.add(rd);
    		}else {
    			Road old = roadInfo.get(roadInfo.indexOf(rd));
    			roadInfo.set(roadInfo.indexOf(rd), rd.distance < old.distance ? rd : old);
    		}
    	}
    	length = roadInfo.size();
    	
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
    		this.town1 = Math.min(road[0], road[1]);
    		this.town2 = Math.max(road[0], road[1]);
    		this.distance = road[2];
    	}
		@Override
		public String toString() {
			return "Road [town1=" + town1 + ", town2=" + town2 + ", distance=" + distance + "]";
		}
		
		@Override
		public boolean equals(Object obj) {
			Road rd = (Road)obj;
			return (rd.town1==town1) && (rd.town2==town2);
		}
    	
    }

}

