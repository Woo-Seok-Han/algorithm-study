package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Reporting {

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        Reporting b = new Reporting();
        b.solution(id_list, report, k);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idMap = new HashMap<>();
        Map<String, List<String>> reporterMap = new HashMap<>();

        for(int i = 0; i < id_list.length; i++) {
            idMap.put(id_list[i], i);
        }

        // 중복 처리
        Set<String> dReport = new HashSet<>(Arrays.asList(report));

        for(String s : dReport) {
            String[] strings = s.split(" ");
            // 신고한 사람
            String reporter = strings[0];
            // 신고당한 사람
            String reported = strings[1];

            if(!reporterMap.containsKey(reported)) {
                reporterMap.put(reported, new ArrayList<>(Arrays.asList(reporter)));
            }else{
                List<String> reporterList = reporterMap.get(reported);
                reporterList.add(reporter);
            }
        }

        Set<Entry<String, List<String>>> entries = reporterMap.entrySet();

        for(Entry entry : entries) {
            List<String> t = (List) entry.getValue();
            if(t.size() >= k) {
                for(String reporter : t) {
//                    System.out.println("reporter : " + reporter);
                    answer[idMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }

}
