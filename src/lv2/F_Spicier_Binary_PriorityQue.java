package lv2;

import java.util.PriorityQueue;

public class F_Spicier_Binary_PriorityQue {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 1, 1},4) == 2);
		System.out.println(solution(new int[] {10, 10, 10, 10, 10},100) == 4);
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12},7) ==2);
		System.out.println(solution(new int[] {0, 2, 3, 9, 10, 12},7) ==2);
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},7) ==3);	// 해결 필요
		System.out.println(solution(new int[] {0, 0, 0, 0},7) == -1);
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},7000) == -1);
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},0) == 0);	// answer must be 0
		System.out.println(solution(new int[] {0, 0, 3, 9, 10, 12},1) == 2);
		System.out.println(solution(new int[] {0,0},0) == 0); // answer must be 0
		System.out.println(solution(new int[] {0,0},1) == -1);
		System.out.println(solution(new int[] {1,0},1) == 1);
		System.out.println(solution(new int[] {1,2,3},11));

	}
	static public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i: scoville) 
			q.add(i);
		
		int count = 0;
		
		while(q.size() > 1 && q.peek() < K) {
			count++;
			int min = q.poll();
			int min2 = q.poll();
			
			int result = min + 2 * min2;
			q.add(result);
		}
		if(K <= q.peek())
			return count;
		else
			return -1;
		
	}

}
