package lv1;
/* 후기 
 *  해당 스테이지에 도달한 사람이 없었을때 실패율이 계산이 안되는 문제가 있었고, 해결 후에는 바로 통과가 가능했음.
 	Comparable 활용으로 비교 및, toString 메서드 구현으로 쉬운 테스트가 가능한게 도움이 크게 되었다.	*/
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
