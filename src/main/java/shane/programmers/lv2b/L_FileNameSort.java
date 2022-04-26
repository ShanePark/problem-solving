package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class L_FileNameSort {

	public static void main(String[] args) {
		String[] arr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		System.out.println(Arrays.toString(solution(arr)));
		arr = new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	  
	
    public static String[] solution(String[] files) {
    	List<FileName> list = new ArrayList<>();
        for(String str : files) {
        	FileName file = new FileName(str);
        	list.add(file);
        }
        
        Collections.sort(list, new Comparator<FileName>() {

			@Override
			public int compare(FileName o1, FileName o2) {
				String header1 = o1.header.toUpperCase();
				String header2= o2.header.toUpperCase();
				
				if(header1.compareToIgnoreCase(header2) != 0) {
					return header1.compareToIgnoreCase(header2);
				}
				
				
				int num1 = Integer.parseInt(o1.number);
				int num2 = Integer.parseInt(o2.number);
				
				return num1 - num2;
			}
        	
		});
        
        final int size = list.size();
        String[] answer = new String[size];
        for(int i=0; i<size; i++) {
        	answer[i] = list.get(i).fileName;
        }
        
        return answer;
    }
    
  

}

class FileName {
	String fileName;
	String header;
	String number;
	String tail;
	
	FileName(String fileName) {
		this.fileName = fileName;
		
		StringBuffer headerBuffer = new StringBuffer();
		StringBuffer numberBuffer = new StringBuffer();
		StringBuffer tailBuffer = new StringBuffer();
		
		for(char c : fileName.toCharArray()) {
			if('0' <= c && c <= '9') {
				if(tailBuffer.length() == 0) {
					numberBuffer.append(c);
				}else {
					tailBuffer.append(c);
				}
			}else {
				if(numberBuffer.length() == 0) {
					headerBuffer.append(c);
				}else {
					tailBuffer.append(c);
				}
			}
		}
		
		this.header = headerBuffer.toString();
		this.number = numberBuffer.toString();
		this.tail = tailBuffer.toString();
		
	}
	
}






