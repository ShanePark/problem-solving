package lv2a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Y_openChat {
	
	public static void main(String[] args) {
		
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		System.out.println(Arrays.toString(solution(record)));
	}
	
    public static String[] solution(String[] record) {
    	
    	 class Record{
    	    	//enter : 1 , change : 2 , leave : 3
    	    	int type;
    	    	String userId;
    	    	@Override
    	    	public String toString() {
    	    		return String.format("type : %d, userId : %s, nickName : %s", type, userId);
    	    	}
    	    	
    	    	Record(String record, Map<String,String> nicknameMap){
    	    		String[] array = record.split(" ");
    	    		this.userId = array[1];
    	    		switch(array[0]) {
    		    		case "Enter" : 
    		    			this.type = 1;
    		    			nicknameMap.put(userId, array[2]);
    		    			break;
    		    		case "Leave" :
    		    			this.type = 2;
    		    			break;
    		    		case "Change" :
    		    			this.type = 3;
    		    			nicknameMap.replace(userId, array[2]);
    		    			break;
    		    		default : 
    		    			break;
    	    		}
    	    	}
    	    	
    	    	public String recordText(Map<String,String> nicknameMap) {
    	    		String nickName = nicknameMap.get(userId);
    	    		StringBuffer sb = new StringBuffer(String.format("%s님이 ", nickName));
    	    		switch(type){
    	    			case 1:
    	    				sb.append("들어왔습니다.");
    	    				return sb.toString();
    	    			case 2:
    	    				sb.append("나갔습니다.");
    	    				return sb.toString();
    	    			default:
    	    				return null;
    	    		}
    	    	}
    	    	
    	    }
    	
    	Map<String, String> nicknameMap = new HashMap<>();
    	List<Record> list = new ArrayList<>();
    	for(String str : record) {
    		Record rec = new Record(str, nicknameMap);
    		list.add(rec);
    	}
    	
    	List<String> answerList = new ArrayList<>();
    	for(Record rec : list) {
    		String recordText = rec.recordText(nicknameMap);
    		if(recordText != null) {
    			answerList.add(recordText);
    		}
    	}
    	
    	String[] answer = new String[answerList.size()];
    	answer = answerList.toArray(answer);
    	
    	return answer;
    }
    

}






