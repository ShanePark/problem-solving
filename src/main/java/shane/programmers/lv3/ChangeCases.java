package shane.programmers.lv3;

import java.util.Arrays;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.57ms, 74.3MB)
테스트 2 〉	통과 (0.47ms, 61.4MB)
테스트 3 〉	통과 (0.42ms, 60.9MB)
테스트 4 〉	통과 (0.41ms, 71.6MB)
테스트 5 〉	통과 (0.37ms, 71.8MB)
테스트 6 〉	통과 (0.36ms, 58.2MB)
테스트 7 〉	통과 (0.88ms, 71.9MB)
테스트 8 〉	통과 (0.67ms, 59.9MB)
테스트 9 〉	통과 (0.83ms, 58.9MB)
테스트 10 〉	통과 (0.54ms, 73.2MB)
테스트 11 〉	통과 (0.59ms, 60MB)
테스트 12 〉	통과 (0.66ms, 69.3MB)
테스트 13 〉	통과 (0.36ms, 59.5MB)
테스트 14 〉	통과 (0.66ms, 73.2MB)
효율성  테스트
테스트 1 〉	통과 (44.81ms, 69.7MB)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	통과 (39.90ms, 70.3MB)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
채점 결과
정확성: 70.0
효율성: 10.0
합계: 80.0 / 100.0
 */
public class ChangeCases {


	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 1, 2, 5 }));
	}

	static int count;
	public static int solution(int n, int[] money) {

		count = 0;
		process(n, money);
		return count;
	}

	public static void process(int n, int[] money) {

		if (n == 0) {
			count++;
			return;
		}

		if (money.length == 1) {
			if (n % money[0] == 0) {
				count++;
			}
			return;
		}

		int i=0;
		int temp;
		while( (temp=i*money[money.length-1]) <= n) {
			int[] arr = Arrays.copyOf(money, money.length-1);
			process(n-temp, arr);
			i++;
		}
	}

}







