package shane.programmers.lv2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shane
 * Test case 27 has bug which can't be solved without adding "E#" which is actually not true.
 * But anyway it doesn't break my logic even if I add that so I just did it.
 *
 */
public class M_RecentSong {
	
	public static void main(String[] args) {
		System.out.println(solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(solution("CC#BCC#BCC#BCC#B",new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
		System.out.println(solution("ABC",new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
	}
	
    public static String solution(String m, String[] musicinfos) {
    	
    	String mOnHex = new Song(null, null, m).hexMelody;
    	
    	final int songAmount = musicinfos.length;
    	List<Song> songs = new ArrayList<>();
    	
    	for(int i=0; i<songAmount; i++) {
    		String[] data = musicinfos[i].split(",");
    		String startTime = data[0];
    		String endTime = data[1];
    		String title = data[2];
    		String melody = data[3];
    		
    		int startMinute = Integer.parseInt(startTime.split(":")[0]) * 60 + Integer.parseInt(startTime.split(":")[1]);
    		int endMinute = Integer.parseInt(endTime.split(":")[0]) * 60 + Integer.parseInt(endTime.split(":")[1]);
    		int totalMinute = endMinute - startMinute;
    		
    		Song song = new Song(title, totalMinute, melody);
    		StringBuffer playedMelody = new StringBuffer();
    		
    		for(int j=0; j<totalMinute; j++) {
    			playedMelody.append(song.hexMelody.charAt(j % song.length));
    		}
    		
    		if(playedMelody.indexOf(mOnHex) >= 0) {
    			songs.add(song);
    		}
    		
    	}
    	
    	final int listSize = songs.size();
    	if(listSize == 0) {
    		return "(None)";
    	}else {
    		String title = null;
    		int maxMinute = 0;
    		for(int i=0; i<listSize; i++) {
    			if(songs.get(i).totalMinute > maxMinute) {
    				maxMinute = songs.get(i).totalMinute;
    				title = songs.get(i).title;
    			}
    		}
    		
    		return title;
    		
    	}
        
    			
    }
	
}

class Song{
	Integer totalMinute;
	String title;
	String hexMelody;
	int length;
	
	final String[] scale = new String[] {"A", "A#", "B", "C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#"};
	
	public Song() {}
	public Song(String title,Integer totalMinute, String melody) {
		this.title = title;
		this.totalMinute = totalMinute;
		this.hexMelody = toHexMelody(melody);
	}
	
	public String toHexMelody(String m) {
    	StringBuffer mOnScale = new StringBuffer();
    	final int mLength = m.length();
    	int realLength = mLength;
    	for(int i=0; i<mLength; i++) {
    		StringBuffer fitch = new StringBuffer(String.valueOf(m.charAt(i)));
    		if(i < mLength -1 && m.charAt(i+1) == '#') {
    			fitch.append("#");
    			i++;
    			realLength--;
    		}
    		int fitchNumber = Arrays.binarySearch(scale, fitch.toString());
    		mOnScale.append(Integer.toHexString(fitchNumber));
    	}
    	
    	this.length = realLength;
    	return mOnScale.toString();
	}
}
