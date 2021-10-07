package shane.programmers.monthly.sep2021;

/**
 * 문제 설명
 *
 * 길이가 n인 배열 a가 주어집니다. 당신은 여기에 q개의 쿼리를 순차적으로 날려 n개의 0으로 이루어진 배열을 a로 만들고자 합니다.
 * query(l, r, x)는 다음 수도코드와 같은 역할을 합니다. (0 ≤ l ≤ r < n, 1 ≤ x ≤ 105)
 * for i = l, l+1, ..., r:
 *     a[i] := max(a[i], x)
 * q개의 쿼리를 통해 a를 만드는 방법은 여러 가지가 있을 수 있습니다. 예를 들어 a = [1,2], q = 2라면 다음 4가지 방법으로 a를 만들 수 있습니다.
 * query(0, 0, 1), query(1, 1, 2)
 * query(1, 1, 2), query(0, 0, 1)
 * query(0, 1, 1), query(1, 1, 2)
 * query(1, 1, 2), query(0, 1, 1)
 * 정수 q와 정수 배열 a가 매개변수로 주어집니다. q개의 쿼리를 통해 a를 만드는 방법의 가짓수를 998,244,353으로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.
 * 제한사항
 * 1 ≤ q ≤ 50
 * 1 ≤ a의 길이 ≤ 50
 * 1 ≤ a의 모든 원소 ≤ 105
 * 입출력 예
 * q	a	result
 * 2	[1,2]	4
 * 3	[3]	19
 * 5	[1,4,4]	157740
 * 50	[1,6,5,2,4]	61953538
 */
public class P8 {

    public static void main(String[] args) {

    }

    public int solution(int q, int[] a) {
        int answer = -1;
        return answer;
    }
}
