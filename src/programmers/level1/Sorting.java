package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {
    public static void main(String[] args) {

        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};

        Sorting sorting = new Sorting();
        sorting.solution(k, score);

        int[] result = {10, 10, 10, 20, 20, 100, 100};
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> scoreList = new ArrayList<>();

        for(int i = 0; i < score.length; i++) {
            scoreList.add(score[i]);
            Collections.sort(scoreList, Comparator.reverseOrder());

            if(scoreList.size() > k) {
                scoreList.subList(k, scoreList.size()).clear();
            }
            answer[i] = scoreList.get(scoreList.size() - 1);
        }

        return answer;
    }
}
