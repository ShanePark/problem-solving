package shane.programmers.weekly;

public class Week2Professor {

	public static void main(String[] args) {
		System.out.println(solution(new int[][]{{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}}));
		System.out.println(solution(new int[][]{{50,90},{50,87}}));
		System.out.println(solution(new int[][]{{70,49,90},{68,50,38},{73,31,100}}));
	}
	
    public static String solution(int[][] scores) {
    	final int length = scores.length;
    	char[] answerChar = new char[length];
    	for(int i=0; i<length; i++) {
    		int selfScore = scores[i][i];
    		int sum = selfScore;
    		boolean isMineIncluded = false;
    		int min = selfScore;
    		int max = selfScore;
    		for(int j=0; j<length; j++) {
    			if(j==i) continue;
    			int temp = scores[j][i];
    			if(temp == selfScore)
    				isMineIncluded = true;
    			max = Math.max(max, temp);
    			min = Math.min(min, temp);
    			sum += temp;
    		}
    		if(selfScore != max && selfScore != min) {
    			isMineIncluded = true;
    		}
    		double score = isMineIncluded? sum/length : (sum-selfScore)/(length-1);
    		answerChar[i] = scoreToChar(score);
    	}
    	
        return String.valueOf(answerChar);
    }
    
    public static char scoreToChar(double score) {
    	if(90 <= score) {
    		return 'A';
    	}else if(80 <= score) {
    		return 'B';
    	}else if(70 <= score) {
    		return 'C';
    	}else if(50 <= score) {
    		return 'D';
    	}else {
    		return 'F';
    	}
    }

}
