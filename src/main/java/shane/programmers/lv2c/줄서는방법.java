package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.52ms, 76MB)
 * 테스트 2 〉	통과 (29.32ms, 80.3MB)
 * 테스트 3 〉	통과 (12.53ms, 76.9MB)
 * 테스트 4 〉	통과 (0.12ms, 79.1MB)
 * 테스트 5 〉	통과 (0.04ms, 78.5MB)
 * 테스트 6 〉	통과 (0.03ms, 78.7MB)
 * 테스트 7 〉	통과 (1.19ms, 72.8MB)
 * 테스트 8 〉	통과 (0.24ms, 79.8MB)
 * 테스트 9 〉	통과 (0.11ms, 79.3MB)
 * 테스트 10 〉	통과 (136.48ms, 141MB)
 * 테스트 11 〉	통과 (159.08ms, 155MB)
 * 테스트 12 〉	통과 (281.53ms, 261MB)
 * 테스트 13 〉	통과 (485.54ms, 381MB)
 * 테스트 14 〉	통과 (0.43ms, 77.8MB)
 * 효율성  테스트
 * 테스트 1 〉	실패 (시간 초과)
 * 테스트 2 〉	실패 (시간 초과)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 73.7
 * 효율성: 0.0
 * 합계: 73.7 / 100.0
 */
public class 줄서는방법 {

    @Test
    public void test() {
        assertThat(solution(3, 5)).containsExactly(3, 1, 2);
    }

    int[] answer;
    int current;

    public int[] solution(int n, long k) {

        current = 1;
        dfs(new int[n], n, new boolean[n], 0, k);
        return answer;
    }

    private void dfs(int[] arr, int n, boolean[] visited, int count, long k) {
        if (count == n || current > k) {
            if (count == n) {
                answer = Arrays.copyOf(arr, arr.length);
            }
            current++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[count] = i + 1;
                visited[i] = true;
                dfs(arr, n, visited, count + 1, k);
                visited[i] = false;
            }
        }
    }
}
