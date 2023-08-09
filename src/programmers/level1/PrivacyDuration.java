package programmers.level1;

import java.util.ArrayList;
import java.util.HashMap;

public class PrivacyDuration {

    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, Integer> termsMap = new HashMap<>();
        for(int i = 0; i < terms.length; i++) {
            String[] termInfo = terms[i].split(" ");
            termsMap.put(termInfo[0], Integer.parseInt(termInfo[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] privacyInfo = privacies[i].split(" ");
            String termsType = privacyInfo[1];

            int started= calculateStringToIntDate(privacyInfo[0]);
            int expiration = started + (termsMap.get(termsType) * 28);
            int iToday =  calculateStringToIntDate(today);
            if(iToday >= expiration) answer.add(i + 1);

        }

        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public int calculateStringToIntDate(String date) {
        String[] dateInfo = date.split("[.]");
        int year = Integer.parseInt(dateInfo[0]);
        int month = Integer.parseInt(dateInfo[1]);
        int day = Integer.parseInt(dateInfo[2]);
        
        return (year * 28 * 12) + (month * 28) + (day);
    }

    public static void main(String[] args){

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        PrivacyDuration privacyDuration = new PrivacyDuration();
        privacyDuration.solution(today, terms, privacies);
    }

}
