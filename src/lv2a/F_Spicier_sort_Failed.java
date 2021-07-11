package lv2a;
// Efficient test failed
import java.util.ArrayList;
import java.util.Arrays;

public class F_Spicier_sort_Failed {

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
//			System.out.println("list : " + list + "count : " + count);
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
					// 이진검색으로 자리 찾아 삽입하기
					int index=getIndex(list,result);
					list.add(index,result);
					//
				}else if(!isPossible)
					isPossible = true;
			}

		}

		
		
		
	}
	
	static public int getIndex(ArrayList<Integer> list, int result){
		final int SIZE = list.size();
		for(int i=0 ; i<SIZE ; i++) {
			if( result < list.get(i))
				return i;
		}
		return list.size();
	}

}
