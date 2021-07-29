package shane.programmers.lv2c;

import java.util.*;

public class VisitLength {

	public static void main(String[] args) {
		System.out.println(solution("ULURRDLLU"));
		System.out.println(solution("LULLLLLLU"));
	}
	
    public static int solution(String dirs) {
        List<Move> list = new ArrayList<>();
        Point point = new Point(0,0);
        for(char c : dirs.toCharArray()) {
        	Point to = null;
        	switch(c) {
        	case 'U':
        		to = new Point(point.x,point.y+1);
        		if(to.y <= 5) {
        			Move mv = new Move(point, to);
        			point = to;
        			if(!list.contains(mv)) {
        				list.add(mv);
        			}
        		}
        		break;
        	case 'L':
        		to = new Point(point.x-1,point.y);
        		if(to.x >= -5) {
        			Move mv = new Move(point, to);
        			point = to;
        			if(!list.contains(mv)) {
        				list.add(mv);
        			}
        		}
        		break;
        	case 'R':
        		to = new Point(point.x+1,point.y);
        		if(to.x <= 5) {
        			Move mv = new Move(point, to);
        			point = to;
        			if(!list.contains(mv)) {
        				list.add(mv);
        			}
        		}
        		break;
        	case 'D':
        		to = new Point(point.x,point.y-1);
        		if(to.y >= -5) {
        			Move mv = new Move(point, to);
        			point = to;
        			if(!list.contains(mv)) {
        				list.add(mv);
        			}
        		}
        		break;
        	}
        }
        System.out.println(list);
        return list.size();
    }
    
    static class Move{
    	Point p1;
    	Point p2;
    	public Move(Point p1, Point p2) {
    		this.p1 = p1;
    		this.p2 = p2;
    	}
    	@Override
    	public boolean equals(Object obj) {
    		Move m = (Move)obj;
    		return (m.p1.equals(p1) && m.p2.equals(p2)) || (m.p1.equals(p2) && m.p2.equals(p1));
    	}
		@Override
		public String toString() {
			return "Move [p1=" + p1 + ", p2=" + p2 + "]";
		}
    	
    }
    
    static class Point{
    	int x;
    	int y;
    	public Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	@Override
    	public boolean equals(Object obj) {
    		Point p = (Point)obj;
    		return (p.x==x) && (p.y==y);
    	}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
    	
    }
    
    public static void move(Point from, Point to, List<Move> list) {
		Move mv = new Move(from, to);
		from = to;
		if(!list.contains(mv)) {
			list.add(mv);
		}
    }

}
