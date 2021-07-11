package lv2a;

/*
 * 
 * 	'A' : 65
 * 	'Z' : 90
 * 	'a' : 97
 * 
 * */
public class W_RecommendNewId {
	
	
	public static void main(String[] args) {
		
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		
	}
	
	
    public static String solution(String new_id) {
    	
        StringBuffer str = new StringBuffer(new_id);
        
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        int length = str.length();
        for(int i=0; i<length; i++) {
        	char c = str.charAt(i);
        	if(65 <= c && c <= 90) {
        		str.setCharAt(i, (char)(c + 32));
        	}
        }
        
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        int delCount = 0;
        for(int i=0; i-delCount<str.length(); i++) {
        	char c = str.charAt(i-delCount);
//        	System.out.println(c + " " + (int)c);
        	if(c < 45 || c==47 || (57 < c && c < 95) || c==96 || c > 122) {
        		str.deleteCharAt(i-delCount);
        		delCount++;
        	}
        }
        
        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while(true) {
        	int index = str.indexOf("..");
        	if(index == -1) break;
        	str.replace(index, index+2, ".");
        }
        
        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(str.length() > 0) {
        	if(str.charAt(0) == '.')
        		str.deleteCharAt(0);
        	length = str.length();
        	if(str.length() > 0 && str.charAt(length-1) == '.')
        		str.deleteCharAt(length-1);
        }
        
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(str.length() == 0)
        	str.append('a');
        
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        length = str.length();
        if(length >= 16) {
        	str.delete(15, length);
        	if(str.charAt(14) == '.') {
        		str.deleteCharAt(14);
        	}
        }
        
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        length = str.length();
        if(length <= 2) {
        	char lastChar = str.charAt(length - 1);
        	for(int i=length; i<3; i++) {
        		str.append(lastChar);
        	}
        }
        
        return str.toString();
    }
	
	
}







