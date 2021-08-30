package shane.programmers.weekly;

public class Week5Dictionary {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        word = String.format("%-5s", word);

        int answer = 0;
        char c4 = word.charAt(4);
        char c3 = word.charAt(3);
        char c2 = word.charAt(2);
        char c1 = word.charAt(1);
        char c0 = word.charAt(0);

        if (c4 == 'A') {
            answer += 1;
        } else if (c4 == 'E') {
            answer += 2;
        } else if (c4 == 'I') {
            answer += 3;
        } else if (c4 == 'O') {
            answer += 4;
        } else if (c4 == 'U') {
            answer += 5;
        }else{

        }

        if (c3 == 'A') {
            answer += 1;
        } else if (c3 == 'E') {
            answer += (2 + 5 * (2-1) );
        } else if (c3 == 'I'){
            answer += (3 + 5 * (3-1));
        } else if (c3 == 'O'){
            answer += ( 4 + 5 * (4-1));
        } else if (c3 == 'U'){
            answer += ( 5 + 5 * (5-1));
        }else{

        }

        if (c2 == 'A' ){
            answer += 1;
        } else if (c2 == 'E'){
            answer += (2 + 5*5 * (2-1));
        } else if (c2 == 'I'){
            answer += (3 + 5*5 * (3-1));
        } else if (c2 == 'O'){
            answer += (4 + 5*5 * (4-1));
        } else if (c2 == 'U') {
            answer += (5 + 5*5 * (5 - 1));
        }else{

        }

        if (c1 == 'A' ){
            answer += 1;
        } else if (c1 == 'E'){
            answer += (2 + 5*5*5 * (2-1));
        } else if (c1 == 'I'){
            answer += (3 + 5*5*5 * (3-1));
        } else if (c1 == 'O'){
            answer += (4 + 5*5*5 * (4-1));
        } else if (c1 == 'U') {
            answer += (5 + 5*5*5 * (5-1));
        }else{

        }

        if (c0 == 'A' ){
            answer += 1;
        } else if (c0 == 'E'){
            answer += (2 + 5*5*5*5 * (2-1));
        } else if (c0 == 'I'){
            answer += (3 + 5*5*5*5 * (3-1));
        } else if (c0 == 'O'){
            answer += (4 + 5*5*5*5 * (4-1));
        } else if (c0 == 'U') {
            answer += (5 + 5*5*5*5 * (5-1));
        }else{

        }

        return answer;
    }
}
