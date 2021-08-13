package shane.programmers.lv3;

import java.util.*;

public class BestAlbum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "classic", "pop", "classic", "classic", "pop" },
				new int[] { 500, 600, 150, 800, 2500 })));
	}

	static class Genre {
		
		@Override
		public String toString() {
			return "Genre [total=" + total + ", list=" + list + "]";
		}

		public Genre() {
			total = 0;
			list = new ArrayList<>();
		}

		int total;
		List<Song> list;

		public void add(Song song) {
			total += song.plays;
			if(list.size() == 0) {
				list.add(song);
			}else if(list.size() == 1) {
				list.add(list.get(0).plays > song.plays ? 1 : 0, song);
			}else {
				if(list.get(0).plays < song.plays) {
					list.add(0,song);
				}else if (list.get(1).plays < song.plays) {
					list.add(1, song);
				}else {
					list.add(song);
				}
				list.remove(2);
			}
			
		}
	}

	static class Song {
		public Song(String genre, int plays, int index) {
			this.genre = genre;
			this.plays = plays;
			this.index = index;
		}

		String genre;
		int plays;
		int index;
		@Override
		public String toString() {
			return "Song [genre=" + genre + ", plays=" + plays + ", index=" + index + "]";
		}
		
	}

	public static int[] solution(String[] genres, int[] plays) {
		Map<String, Genre> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int playCount = plays[i];
			Song song = new Song(genre, playCount, i);
			if (!map.containsKey(genre)) {
				map.put(genre, new Genre());
			}
			map.get(song.genre).add(song);
		}
		List<Genre> list = new ArrayList<>();
		for(String key : map.keySet()) {
			list.add(map.get(key));
		}
		list.sort(new Comparator<Genre>() {

			@Override
			public int compare(Genre o1, Genre o2) {
				return o2.total - o1.total;
			}
			
		});
		List<Integer> answerList = new ArrayList<>();
		for(Genre genre : list) {
			for(Song song : genre.list) {
				answerList.add(song.index);
			}
		}
		int[] answer = new int[answerList.size()];
		for(int i=0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
	}

}





