package shane.programmers.lv3;

import java.util.PriorityQueue;

/**
 * 채점을 시작합니다.
 * 정확성  테스트
 * 테스트 1 〉	실패 (1.00ms, 75.4MB)
 * 테스트 2 〉	실패 (11.23ms, 72.3MB)
 * 테스트 3 〉	실패 (시간 초과)
 * 테스트 4 〉	실패 (시간 초과)
 * 테스트 5 〉	실패 (시간 초과)
 * 테스트 6 〉	실패 (시간 초과)
 * 테스트 7 〉	실패 (시간 초과)
 * 테스트 8 〉	실패 (시간 초과)
 * 테스트 9 〉	실패 (시간 초과)
 * 채점 결과
 * 정확성: 0.0
 * 합계: 0.0 / 100.0
 */
public class Immigration {

    public static void main(String[] args) {

        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static int remainCnt;

    static class Officer implements Comparable {
        int processTime;
        int remainTime;

        Officer(int processTime) {
            this.processTime = processTime;
            this.remainTime = 0;
        }

        void process() {
            if (remainTime > 0) {
                this.remainTime--;
                remainCnt -= remainTime == 0 ? 1 : 0;
            }
        }

        void register() {
            this.remainTime = this.processTime;
        }

        @Override
        public int compareTo(Object o) {
            Officer officer = (Officer) o;
            return (processTime - remainTime) - (officer.processTime - officer.remainTime);
        }

        @Override
        public String toString() {
            return "Officer{" +
                    "processTime=" + processTime +
                    ", remainTime=" + remainTime +
                    '}';
        }
    }

    public static long solution(int n, int[] times) {

        remainCnt = n;
        PriorityQueue<Officer> pq = new PriorityQueue<>();

        for (int time : times) {
            Officer officer = new Officer(time);
            pq.add(officer);
        }

        long time = 0;

        while (remainCnt > 0) {
            for (Officer officer : pq) {
                if(officer.remainTime > 0){
                    break;
                }else if(n > 0){
                    officer.register();
                    n--;
                }
            }
            for (Officer officer : pq){
                officer.process();
            }
            time++;
        }

        return time;
    }
}
