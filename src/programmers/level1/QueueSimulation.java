package programmers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueSimulation {

    public static void main(String[] args) {
        QueueSimulation main = new QueueSimulation();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(main.solution(cards1, cards2, goal));
    }

    public String solution (String[] cards1, String[] cards2, String[] goal) {

        Queue<String> goalQueue = new LinkedList<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        for(String c : goal) {
            goalQueue.offer(c);
        }

        for(String c : cards1) {
            queue1.offer(c);
        }

        for(String c : cards2) {
            queue2.offer(c);
        }

        while(!goalQueue.isEmpty()) {
            String target = goalQueue.poll();

            if(target.equals(queue1.peek())){
                queue1.poll();
            }

            else if(target.equals(queue2.peek())){
                queue2.poll();
            }

            else
                return "NO";
        }

        return "YES";
    }

}
