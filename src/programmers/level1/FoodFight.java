package programmers.level1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class FoodFight {

    Deque<Integer> deque = new LinkedList<>();

//    food          result
//    [1, 3, 4, 6]	"1223330333221"
//    [1, 7, 1, 2]	"111303111"

    public static void main(String[] args) {

//        int[] food = {1, 3, 4, 6};
        int[] food = {1, 7, 1, 2};
        FoodFight foodFight = new FoodFight();
        foodFight.solution(food);
    }

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
