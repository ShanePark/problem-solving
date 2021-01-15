package lv1;
/* Review
 * I had trouble in calculating failureRate when there was no one reached the stage
 * to solve that problem, i just added conditional state to check 'usersTriedStage' and then passed  
 * When I tried to sort array with "return (int)(failureRate-o.failureRate)" I had trouble as it only return 0
*/
import java.util.Arrays;

public class FailureRate {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(8,new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
	}

	static public int[] solution(int N, int[] users) {
		class Stage implements Comparable<Stage>{
			int stage;
			int usersOnStage=0;
			int usersTriedStage=0;
			double failureRate=0;
			public Stage(int stage) {
				this.stage = stage;
			}

			@Override
			public String toString() {
				return "Stage [stage=" + stage + ", usersOnStage=" + usersOnStage + ", usersTriedStage="
						+ usersTriedStage + ", failureRate=" + failureRate + "]";
			}

			@Override
			public int compareTo(Stage o) {
				if(o.failureRate == failureRate)
					return stage-o.stage;
				else return failureRate<o.failureRate ? 1 : -1;
			}
		}
		
		Stage[] stages = new Stage[N+1];
		for(int i=0; i<stages.length; i++)
			stages[i] = new Stage(i+1);
		for(int i : users) {
			stages[i-1].usersOnStage++;
			for(int j=1; j<=i; j++)
				stages[j-1].usersTriedStage++;
		}
		for(Stage stage: stages) {
			stage.failureRate = (double)stage.usersOnStage / stage.usersTriedStage;
			if(stage.usersTriedStage==0) stage.failureRate = 0;
		}
		
		Arrays.sort(stages, 0, N);
		
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			answer[i] = stages[i].stage;
		}
		return answer;
	}
}
