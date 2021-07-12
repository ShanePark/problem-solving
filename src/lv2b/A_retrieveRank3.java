package lv2b;

import java.util.Arrays;

/**
 * @author shane
 * 테스트 1 〉	통과 (1.21ms, 52.6MB)
테스트 2 〉	통과 (1.23ms, 52.8MB)
테스트 3 〉	통과 (7.71ms, 52.6MB)
테스트 4 〉	통과 (41.24ms, 56.4MB)
테스트 5 〉	통과 (84.26ms, 69.3MB)
테스트 6 〉	통과 (115.22ms, 73.3MB)
테스트 7 〉	통과 (87.29ms, 72.1MB)
테스트 8 〉	통과 (190.01ms, 75MB)
테스트 9 〉	통과 (184.79ms, 75.2MB)
테스트 10 〉	통과 (221.04ms, 74.8MB)
테스트 11 〉	통과 (71.14ms, 66.7MB)
테스트 12 〉	통과 (95.67ms, 72.5MB)
테스트 13 〉	통과 (79.89ms, 71.7MB)
테스트 14 〉	통과 (178.96ms, 74.2MB)
테스트 15 〉	통과 (174.12ms, 74.8MB)
테스트 16 〉	통과 (68.72ms, 67.8MB)
테스트 17 〉	통과 (93.22ms, 71.3MB)
테스트 18 〉	통과 (197.53ms, 74.8MB)
채점 결과
정확성: 40.0
효율성: 0.0
합계: 40.0 / 100.0
 */
public class A_retrieveRank3 {
	
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] result = solution(info, query);
		System.out.println(Arrays.toString(result));

	}
	
    public static int[] solution(String[] info, String[] query) {
    	
    	
    	final int length = query.length;
    	int[] answer = new int[length];
    	for(int i=0; i<length; i++) {
    		
    		String[] queryData = query[i].split(" and ");
    		
    		int count = 0;
    		for(String applicant : info) {
    			// filter with language
    			if(!"-".equals(queryData[0]) && applicant.indexOf(queryData[0]) < 0 ) {
    				continue;
    			}
    			// filter with position
				if(!"-".equals(queryData[1]) && applicant.indexOf(queryData[1]) < 0 ) {
    				continue;
    			}
    			// filter with exp
    			if(!"-".equals(queryData[2]) && applicant.indexOf(queryData[2]) < 0 ) {
    				continue;
    			}
    			String[] soulFoodAndScore = queryData[3].split(" ");
    			String sf = soulFoodAndScore[0];
    			int score = Integer.parseInt(soulFoodAndScore[1]);
    			
    			// filter with soulFood
    			if(!"-".equals(sf) && applicant.indexOf(sf) < 0 ) {
    				continue;
    			}
    			
    			String applicantScore = applicant.substring(applicant.lastIndexOf(" ")+1);
    			if(Integer.parseInt(applicantScore) < score) {
    				continue;
    			}
    			
    			count++;
    			
    		}
    		
    		answer[i] = count;
    		
    	}
        
        
        return answer;
    }
    


}
