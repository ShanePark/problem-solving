package shane.programmers.lv2a;

import java.util.ArrayList;
import java.util.Arrays;

public class F_Spicier_sort2_Failed {

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

		boolean isPossible = false;
		Arrays.sort(scoville);
		for(int i : scoville) {
			if(i<K)
				list.add(i);
			else{
				isPossible = true;
				break;
			}
		}

		int count = 0;

		while(true) {
			int SIZE = list.size();

			if(SIZE <= 1) {
				if(list.size() == 0) {
					if(isPossible) return count;
					else return -1;
				}else {	//SIZE == 1
					if(isPossible) return count+1;
					else return -1;
				}
			}else if(list.get(0) >= K)
				return count;
			else {
				count++;
				int small1 = list.get(0);
				int small2 = list.get(1);
				int result = small1 + small2 * 2;
				list.remove(0);
				list.remove(0);
				if(K <= result && SIZE-2 <1)
					return count;
				if(result < K) {
					int index=getIndex(list,result);
					list.add(index,result);
				}else if(!isPossible)
					isPossible = true;
			}

		}




	}

	static public int getIndex(ArrayList<Integer> list, int result){
		int mid = 0;
		int left = 0;
		int right = list.size() - 1;

		while(right >= left) {
			mid = (right+left) / 2;

			if( result == list.get(mid)) {
				return mid;
			}
			if(result < list.get(mid))
				right  = mid - 1;
			else
				left = mid +1;

		}
		return mid;


	}

}
