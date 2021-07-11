package lv2a;

import java.util.ArrayList;
import java.util.Arrays;

public class F_Spicier_sort4 {

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

		Arrays.sort(scoville);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i : scoville) {
			list.add(i);
		}

		int count = 0;

		while(list.size() >1 && list.get(0) < K) {
			count++;
			int small1 = list.get(0);
			int small2 = list.get(1);
			int result = small1 + small2 * 2;
			list.remove(0);
			list.remove(0);
			int index = list.size()==0? 0 : getIndex(list,result);
			list.add(index,result);
		}
		if(K <= list.get(0))
			return count;
		else
			return -1;

	}

	static public int getIndex(ArrayList<Integer> list, int result){
		int mid = 0;
		int left = 0;
		int right = list.size() - 1;

		while(left +1 <= right) {
			mid = (right+left) / 2;

			if(result < list.get(mid))
				right  = mid-1;
			else
				left = mid +1;
		}
		return list.get(left) < result ? left+1 : left;

	}

}


