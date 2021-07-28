package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (5.11ms, 52.5MB)
테스트 2 〉	통과 (3.75ms, 53.3MB)
테스트 3 〉	통과 (6.09ms, 52.2MB)
테스트 4 〉	통과 (3.98ms, 52.4MB)
테스트 5 〉	통과 (3.48ms, 52.6MB)
테스트 6 〉	통과 (1.74ms, 52.9MB)
테스트 7 〉	통과 (2.51ms, 52.3MB)
테스트 8 〉	통과 (0.60ms, 52.2MB)
테스트 9 〉	통과 (0.78ms, 52.4MB)
테스트 10 〉	통과 (4.09ms, 53.1MB)
테스트 11 〉	통과 (3.72ms, 53.1MB)
테스트 12 〉	통과 (3.25ms, 53.3MB)
테스트 13 〉	통과 (4.13ms, 53MB)
테스트 14 〉	통과 (3.02ms, 52.3MB)
테스트 15 〉	통과 (0.99ms, 53.1MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	통과 (22.65ms, 56.3MB)
테스트 3 〉	통과 (36.48ms, 55.3MB)
테스트 4 〉	통과 (20.24ms, 54.7MB)
테스트 5 〉	통과 (20.84ms, 55MB)
채점 결과
정확성: 75.0
효율성: 20.0
합계: 95.0 / 100.0
 */
public class Q_Boat {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {70, 50, 80, 50}, 100));
		System.out.println(solution(new int[] {70, 80, 50}, 100));

	}
	
    public static int solution(int[] people, int limit) {
    	Arrays.sort(people);
    	List<Integer> list = new ArrayList<>();
    	final int length = people.length;
    	for(int i=0; i<length; i++) {
    		list.add(people[i]);
    	}
    	
        int answer = 0;
        while(list.size() > 0) {
        	int lastWeight = list.get(list.size()-1);
        	list.remove(list.size()-1);
        	answer++;
        	while(list.size() > 0) {
        		int firstWeight = list.get(0);
        		if(lastWeight + firstWeight <= limit) {
        			lastWeight += firstWeight;
        			list.remove(0);
        		}else {
        			break;
        		}
        	}
        }
        return answer;
    }

}
