package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class F_NewsClustring {
	
	public static void main(String[] args) {
		System.out.println(solution("FRANCE","french"));
		System.out.println(solution("handshake","shake hands"));
		System.out.println(solution("aa1+aa2","AAAA12"));
		System.out.println(solution("E=M*C^2","e=m*c^2"));
	}
	
    public static int solution(String str1, String str2) {
    	List<String> list1 = toList(str1);
    	List<String> list2 = toList(str2);
    	Set<String> set1 = new HashSet<>();
    	Set<String> set2 = new HashSet<>();
    	
    	Map<String, Integer> duplicateMap1 = new HashMap<>();
    	for(String str : list1) {
    		if(set1.add(str) == false) {
    			Integer value = duplicateMap1.get(str);
    			if(value == null) {
    				duplicateMap1.put(str, 1);
    			}else {
    				duplicateMap1.put(str, value + 1);
    			}
    		}
    	}
    	
    	Map<String, Integer> duplicateMap2 = new HashMap<>();
    	for(String str : list2) {
    		if(set2.add(str) == false) {
    			Integer value = duplicateMap2.get(str);
    			if(value == null) {
    				duplicateMap2.put(str, 1);
    			}else {
    				duplicateMap2.put(str, value + 1);
    			}
    		}
    	}
    	
    	Set<String> unionSet = new HashSet<>();
    	unionSet.addAll(set1);
    	unionSet.addAll(set2);
    	
    	Set<String> duplicateKeySet = new HashSet<>();
    	duplicateKeySet.addAll(duplicateMap1.keySet());
    	duplicateKeySet.addAll(duplicateMap2.keySet());
    	
    	List<String> union = new ArrayList<>();
    	List<String> intersection = new ArrayList<>();
    	
    	union.addAll(unionSet);
    	intersection.addAll(set1);
    	intersection.retainAll(set2);
    	
    	for(String key : duplicateKeySet) {
    		
    		Integer num1 = duplicateMap1.get(key);
    		Integer num2 = duplicateMap2.get(key);
    		
    		num1 = num1==null? 0 : num1;
    		num2 = num2==null? 0 : num2;
    		
    		int max = num1 > num2 ? num1 : num2;
    		int min = num1 > num2 ? num2 : num1;
    		
    		for(int i=0; i<max; i++) {
    			union.add(key);
    			if(i < min) {
    				intersection.add(key);
    			}
    		}
    		
    	}
    	
        int answer = union.size()==0? 65536 : 65536 * intersection.size() / union.size() ;
        return answer;
    }
    
    public static List<String> toList(String str){
    	List<String> list = new ArrayList<>();
    	final int length = str.length();
    	str = str.toUpperCase();
    	for(int i=0; i<length-1; i++) {
    		if((('A' <= (str.charAt(i)) && (str.charAt(i) <= 'Z' ))) && (('A' <= (str.charAt(i+1)) && (str.charAt(i+1) <= 'Z' ))) ) {
    			String temp = str.substring(i,i+2).toUpperCase();
    			list.add(temp);
    		}
    	}
    	return list;
    }
    
}










