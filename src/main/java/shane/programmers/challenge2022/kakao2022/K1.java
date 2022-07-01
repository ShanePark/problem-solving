package shane.programmers.challenge2022.kakao2022;

import java.util.*;
public class K1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2 )));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<id_list.length; i++){
            String id = id_list[i];
            Set<String> reportee = new HashSet<>();
            map.put(id, reportee);
            indexMap.put(id, i);
        }
        for(String info : report){
            String[] data = info.split(" ");
            String reporter = data[0];
            String reportee = data[1];
            map.get(reportee).add(reporter);
        }

        int[] answer = new int[id_list.length];

        for(String key : map.keySet()){
            if(map.get(key).size() >= k){
                for(String reporter : map.get(key)){
                    answer[indexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }

}
