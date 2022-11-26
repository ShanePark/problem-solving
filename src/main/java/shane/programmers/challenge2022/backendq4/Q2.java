package shane.programmers.challenge2022.backendq4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(solution(new String[]{
                "jack:9,10,13,9,15",
                "jerry:7,7,14,10,17",
                "jean:0,0,11,20,0",
                "alex:21,2,7,11,4",
                "kevin:8,4,5,0,0",
                "brown:3,5,16,3,18",
                "ted:0,8,0,0,8",
                "lala:0,12,0,7,9",
                "hue:17,16,8,6,10",
                "elsa:11,13,10,4,13"}))
                .isEqualTo(new String[]{"alex", "brown", "elsa", "jerry", "hue", "jack", "lala", "kevin", "ted", "jean"});
    }

    public String[] solution(String[] record) {
        List<Player> players = new ArrayList<>();
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            courses.add(new Course(i));
        }
        for (String s : record) {
            Player player = new Player(s);
            for (Course course : courses) {
                course.addPlayer(player);
            }
            players.add(player);
        }
        for (Course course : courses) {
            course.giveMedals();
        }

//        Collections.sort(players);
        String[] answer = new String[players.size()];
        for (int i = 0; i < players.size(); i++) {
            answer[i] = players.get(i).name;
        }
        return answer;
    }

    class Player {
        int goldMedals;
        int silverMedals;
        int bronzeMedals;

        String name;
        int[] courses = new int[5];
        int totalTime;
        int completeCnt;
        int mostDifficultCourse = -1;

        public Player(String s) {
            String[] split = s.split(":");
            this.name = split[0];
            String[] times = split[1].split(",");
            for (int i = 0; i < 5; i++) {
                this.courses[i] = Integer.parseInt(times[i]);
                this.totalTime += courses[i];
                if (courses[i] > 0) {
                    mostDifficultCourse = i;
                    completeCnt++;
                }
            }
        }

        @Override
        public String toString() {
            return "Player{" +
                    "completeCnt=" + completeCnt +
                    ", mostDifficultCourse=" + mostDifficultCourse +
                    ", goldMedals=" + goldMedals +
                    ", silverMedals=" + silverMedals +
                    ", bronzeMedals=" + bronzeMedals +
                    ", totalTime=" + totalTime +
                    ", name='" + name + '\'' +
                    ", courses=" + Arrays.toString(courses) +
                    '}';
        }
    }

    class Course {
        int courseLevel;
        List<Player> players = new ArrayList<>();

        public Course(int courseLevel) {
            this.courseLevel = courseLevel;
        }

        public void addPlayer(Player player) {
            if (player.courses[courseLevel] == 0) {
                player.courses[courseLevel] = 20001;
            }
            players.add(player);
        }

        public void giveMedals() {
            players.sort(Comparator.comparingInt(p -> p.courses[courseLevel]));
            int size = players.size();
            for (int i = 0; i < size; i++) {
                Player player = players.get(i);
                if (i + 1 <= (Math.round(size / 12.0))) {
                    player.goldMedals++;
                } else if (i + 1 <= (Math.round(size / 4.0))) {
                    player.silverMedals++;
                } else if (i + 1 <= (Math.round(size / 2.0))) {
                    player.bronzeMedals++;
                } else {
                    break;
                }
            }
        }
    }

}
