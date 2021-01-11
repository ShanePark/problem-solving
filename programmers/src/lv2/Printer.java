package lv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,1,3,2},2));
	}
	
    static public int solution(int[] priorities, int location) {
        class Document{
        	int location;
        	int priorities;
        	Document(int location, int priorities){
        		this.location = location;
        		this.priorities = priorities;
        	}
        }
        
        Queue<Document> queue = new LinkedList<>();   
        
        final int SIZE = priorities.length;
        for(int i=0; i < SIZE; i++) {
        	Document document = new Document(i,priorities[i]);
        	queue.offer(document);
        }
        int count = 1;
        while(true) {
        	boolean isPrint = true;
        	Iterator<Document> it = queue.iterator();
        	while(it.hasNext()) {
        		if(queue.peek().priorities < it.next().priorities) {
        			isPrint = false;
        			break;
        		}
        		if(isPrint) {
        			if(queue.peek().location == location)
        				return count;
        			else {
        				queue.poll();
        				count++;
        			}
        		}
        		else queue.offer(queue.poll());
        	}
        }
        
        
        
    }
    


}
