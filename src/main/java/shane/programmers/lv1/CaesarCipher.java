package shane.programmers.lv1;


public class CaesarCipher {

	public static void main(String[] args) {
		System.out.println(solution("Z E",25));

	}
	
    static public String solution(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(c==' ')
        		sb.append(c);
        	else if('a' <= c && c <= 'z') {
        		if(c+n <= 'z')
        			sb.append((char)(c+n));
        		else
        			sb.append((char)(c+n-26));
        	}
        	else if('A' <= c && c <= 'Z') {
        		if(c+n <= 'Z')
        			sb.append((char)(c+n));
        		else
        			sb.append((char)(c+n-26));
        	}
        }
        return sb.toString();
    }

}
