package shane.programmers.lv2b;

import java.util.*;

public class S_Delivery8 {

	public static void main(String[] args) {
		System.out.println(solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}} ,3));
		System.out.println(solution(6,new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}} ,4));
	}
	
    public static int solution(int N, int[][] road, int K) {
   
    	int[][] map = new int[N+1][N+1];
    	
    	for(int i=1; i<N+1; i++) {
    		for(int j=1; j<N+1; j++){
    			if(i == j) {
    				map[i][j] = 0;
    			}else {
    				map[i][j] = 500001;
    			}
    		}
    	}
    	
    	for(int i=0; i<road.length; i++) {
    		if(map[road[i][0]][road[i][1]] >= road[i][2]) {
    			map[road[i][0]][road[i][1]] = road[i][2];
    			map[road[i][1]][road[i][0]] = road[i][2];
    		}
    	}
    	
    	for(int k=1; k<=N; k++) {
    		for(int i=1; i<=N; i++) {
    			for(int j=1; j<=N; j++) {
    				if(map[i][j] > map[i][k] + map[k][j]) {
    					map[i][j] = map[i][k] + map[k][j];
    				}
    			}
    		}
    	}
    	
    	int answer = 0;
    	for(int i=1; i<=N; i++) {
    		if(map[1][i] <= K)
    			answer++;
    	}
    	
    	return answer;
    }

}

