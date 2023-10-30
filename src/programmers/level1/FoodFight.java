package programmers.level1;

import java.util.Deque;
import java.util.LinkedList;

public class FoodFight {
    Deque<Integer> deque = new LinkedList<>();

    public String solution(int[] food) {
        String answer = "";

        deque.add(0);

        for(int i = food.length - 1; i > 0 ; i--) {
            useFood(i, food[i]);
        }

        StringBuffer sb = new StringBuffer();
        deque.forEach(sb::append);

        return sb.toString();
    }

    public void useFood(int foodNumber, int foodCount) {
        foodCount = foodCount / 2;

        for(int i = 0; i < foodCount; i++) {
            deque.addFirst(foodNumber);
            deque.addLast(foodNumber);
        }
    }
}