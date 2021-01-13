package lv1;


import java.util.Arrays;

/*
 * 두 개 뽑아서 더하기
문제 설명
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이는 2 이상 100 이하입니다.
numbers의 모든 수는 0 이상 100 이하입니다.
입출력 예
numbers	result
[2,1,3,4,1]	[2,3,4,5,6,7]
[5,0,2,7]	[2,5,7,9,12]
 */
public class SumTwo {

	public static void main(String[] args) {
		int[] arr = {5,0,2,7};
		System.out.println(Arrays.toString(new SolutionTwo().solution(arr)));		
		
	}

}

class SolutionTwo {
    public int[] solution(int[] numbers) {
    	int[] temp = new int[numbers.length*numbers.length];
        int n=0;
        for(int i=0; i<numbers.length-1; i++){
        	middle:for(int j=i+1; j<numbers.length; j++){
        		for(int k=0; k<n; k++){
        			if(numbers[i] + numbers[j] == temp[k]) continue middle;
        		}
        		temp[n++] =numbers[i] + numbers[j];
        	}
        }
        Arrays.sort(temp);
        int[] answer = new int[n];
        for(int i=temp.length-n; i-(temp.length-n)<n; i++){
        	answer[i-(temp.length-n)] = temp[i];
        }
        return answer;
    }
}