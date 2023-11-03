package programmers.level1;

import java.util.*;
import java.util.stream.IntStream;

public class MockExam {

//    answers	    return
//    {1,2,3,4,5}	[1]
//    {1,3,2,4,2}	[1,2,3]
    public static void main(String[] args) {

        int[] answers = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        MockExam mockExam = new MockExam();
        mockExam.solution(answers);
    }
    public int[] solution(int[] answers) {
        int[] answer = {};

        Queue<Integer> queue1 = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        Queue<Integer> queue2 = new LinkedList<>(List.of(2, 1, 2, 3, 2, 4, 2, 5));
        Queue<Integer> queue3 = new LinkedList<>(List.of(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        Person person1 = new Person(queue1, 0, 1);
        Person person2 = new Person(queue2, 0, 2);
        Person person3 = new Person(queue3, 0, 3);

        List<Person> people = List.of(person1, person2, person3);

        Arrays.stream(answers)
                .forEach((ans) -> {
                    people.forEach((person) -> {
                        if(!person.patternQueue.isEmpty()) {
                            Integer polled = person.patternQueue.poll();
                            person.patternQueue.offer(polled);
                            if (polled == ans) {
                                person.score++;
                            }
                        }
                    });
                });

        int maxScore = Integer.MIN_VALUE;
        for (Person person : people) {
            maxScore = Math.max(maxScore, person.score);
        }

        List<Integer> answerList = new ArrayList<>();
        for (Person person : people) {
            if(maxScore == person.score) {
                answerList.add(person.name);
            }
        }

//        answerList.forEach(System.out::println);
        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class Person {
        Queue<Integer> patternQueue;
        int score;
        int name;

        public Person(Queue<Integer> queue, int score, int name) {
            this.patternQueue = queue;
            this.score = score;
            this.name = name;
        }
    }
}
