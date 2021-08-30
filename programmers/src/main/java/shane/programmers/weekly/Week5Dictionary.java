package shane.programmers.weekly;

public class Week5Dictionary {
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        int cnt = 1;
        StringBuffer sb = new StringBuffer("A");

        while(!word.equals(sb.toString())){
            sb = next(sb);
            cnt++;
        }

        return cnt;
    }

    private static StringBuffer next(StringBuffer sb) {
        if(sb.length() < 5){
            sb.append("A");
        }else{
            char c=sb.charAt(sb.length()-1);
            if(c == 'U'){
                while(c == 'U'){
                    sb.deleteCharAt(sb.length()-1);
                    c = sb.charAt(sb.length()-1);
                }
            }

            c = c=='A'? 'E' : c=='E'? 'I' : c=='I'? 'O' : 'U';
            sb.deleteCharAt(sb.length()-1);
            sb.append(c);
        }
        return sb;
    }
}
