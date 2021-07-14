package shane.programmers.lv2a;

import java.util.ArrayList;
import java.util.Arrays;

public class F_Spicier_sort3_Failed {

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
		ArrayList<Integer> list = new ArrayList<>();

		Arrays.sort(scoville);

		for(int i : scoville) {
			list.add(i);
		}

		int count = 0;

		while(true) {
			int SIZE = list.size();

			if(list.get(0) >= K)
				return count;
			if(SIZE <= 2) {
				if(SIZE==2) {
					if(list.get(0) + list.get(1) *2 >= K)
						return count+1;
					else return -1;
				}else if(list.get(0) >= K)
					return count;
				else return -1;
			}

			count++;
			int small1 = list.get(0);
			int small2 = list.get(1);
			int result = small1 + small2 * 2;
			list.remove(0);
			list.remove(0);
			int index=getIndex(list,result);
			list.add(index,result);

		}

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


