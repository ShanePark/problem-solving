package shane.programmers.challenge2021.weekly;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.04ms, 52.3MB)
테스트 2 〉	통과 (0.03ms, 52.4MB)
테스트 3 〉	통과 (0.03ms, 53.3MB)
테스트 4 〉	실패 (0.04ms, 53.4MB)
테스트 5 〉	통과 (0.02ms, 52.8MB)
테스트 6 〉	통과 (0.03ms, 53MB)
테스트 7 〉	통과 (0.02ms, 55.7MB)
테스트 8 〉	통과 (0.02ms, 51.9MB)
테스트 9 〉	통과 (0.02ms, 52MB)
테스트 10 〉	통과 (0.02ms, 52.6MB)
테스트 11 〉	통과 (0.02ms, 51.8MB)
테스트 12 〉	통과 (0.02ms, 52.3MB)
테스트 13 〉	통과 (0.03ms, 52.7MB)
테스트 14 〉	통과 (0.02ms, 52.6MB)
테스트 15 〉	통과 (0.02ms, 53.1MB)
테스트 16 〉	통과 (0.02ms, 51.7MB)
테스트 17 〉	통과 (0.03ms, 53.4MB)
테스트 18 〉	실패 (0.03ms, 52.8MB)
테스트 19 〉	실패 (0.02ms, 53.1MB)
테스트 20 〉	실패 (0.02ms, 52.2MB)
테스트 21 〉	실패 (0.02ms, 52.1MB)
테스트 22 〉	실패 (0.02ms, 53.1MB)
테스트 23 〉	통과 (0.02ms, 52.8MB)
채점 결과
정확성: 73.9
합계: 73.9 / 100.0
 */
public class Week1CalcDeficient {

	public static void main(String[] args) {
		Week1CalcDeficient solution = new Week1CalcDeficient();
		System.out.println(solution.solution(3, 20, 4));

	}
	
    public long solution(int price, int money, int count) {
    	
    	long totalPrice = (count + 1) * count * price / 2;
    	return totalPrice - money;
    	
    }

}
