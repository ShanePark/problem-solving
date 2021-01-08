

public class WaterMelon {
	

	public static void main(String[] args) {
		
		WatermelonSolution sol = new WatermelonSolution();
		System.out.println(sol.solutionWater(3));

	}
	


}
class WatermelonSolution {
    public String solutionWater(int n) {
    	StringBuffer answerb = new StringBuffer("");
    	for( int i=0; i<n; i++){
    		if(i%2 ==0)
    			answerb.append("수");
    		else
    			answerb.append("박");
    	}
        String answer = answerb.toString();
        return answer;
    }
}